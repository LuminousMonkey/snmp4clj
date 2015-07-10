(ns snmp4clj.target
  (:import [org.snmp4j CommunityTarget]
           [org.snmp4j.mp SnmpConstants]
           [org.snmp4j.smi Address GenericAddress OctetString]))

(defn create
  "Create the SNMP target, which is the object used to refer to the
  SNMP device. Assumes default port, community of 'public' and V2."
  [address]
  (doto (CommunityTarget.)
    (.setCommunity (OctetString. "public"))
    (.setVersion SnmpConstants/version2c)
    (.setAddress (GenericAddress/parse (str "udp:" address "/161")))))
