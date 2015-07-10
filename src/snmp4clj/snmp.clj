(ns snmp4clj.snmp
  (:require (snmp4clj [pdu :as pdu]
                      [session :as session]
                      [target :as target]
                      [variable :as variable])))

(defn get
  "Takes an IP address as a string, along with a sequence of OID
  numbers as strings, and returns a hash map. The OID name (as a
  keyword) will be the key, and the value will be the... well, value.
  If the query timesout, then it will return nil.

  A leading period on the OID is removed from the result."
  [address oid-seq]
  (let [pdu (pdu/create oid-seq)
        target (target/create address)
        result (some-> (.send (session/create) pdu target)
                       (.getResponse)
                       (.getVariableBindings)
                       (seq))]
    (map #(hash-map (keyword (.toString (.getOid %)))
                    (variable/get-value (.getVariable %)))
         result)))
