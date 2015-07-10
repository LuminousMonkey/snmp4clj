(ns snmp4clj.session
  (:import [org.snmp4j Snmp]
           [org.snmp4j.transport DefaultUdpTransportMapping]))

(defn create
  "Create the core SNMP object, in UDP listen mode."
  []
  (doto (Snmp. (DefaultUdpTransportMapping.))
    (.listen)))
