(ns snmp4clj.variable
  "Namespace for variables from query results.")

;; The SNMP4J library will return different types depending on the
;; values. They could be strings, ints, etc. Since Clojure is
;; dynamically typed, we want to be the type as close to the native
;; type from the SNMP result itself.

;; e.g. We don't want an int to be returned as a string. Create a
;; protocol so we can get the right type of value returned.
(defprotocol SNMPVariable
  "For handling the variable results from SNMP4J queries."
  (get-value [this]))

(extend-protocol SNMPVariable
  org.snmp4j.smi.Counter32
  (get-value [this]
    (.toLong this))
  org.snmp4j.smi.Counter64
  (get-value [this]
    (.toLong this))
  org.snmp4j.smi.Gauge32
  (get-value [this]
    (.toLong this))
  org.snmp4j.smi.Integer32
  (get-value [this]
    (.toLong this))
  org.snmp4j.smi.OctetString
  (get-value [this]
    (.toString this))
  org.snmp4j.smi.TimeTicks
  (get-value [this]
    (.toString this)))
