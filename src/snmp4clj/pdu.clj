(ns snmp4clj.pdu
  "Namespace for the 'protocol data unit' as used by SNMP4J"
  (:import [org.snmp4j PDU]
           [org.snmp4j.smi OID VariableBinding]))

;; TODO: Such a small simple namespace, should it just be in the snmp
;; namespace?

;; Only support GET PDUs at the moment, however, if this because more
;; advanced, this will have to be changed.
(defn create
  "Given sequence of OIDs, return the protocol data unit for a GET
  query."
  [oid-seq]
  (PDU. PDU/GET (java.util.ArrayList.
                 (map #(VariableBinding. (OID. %)) oid-seq))))
