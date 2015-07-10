# snmp4clj

A simple Clojure wrapper for the SNMP4J library. Very minimal at the
moment because I only need support for V2 and it's just querying
values from a SNMP server.

Raw OID numbers are expected, since SNMP4J only allows MIB support via
a paid licence. Use `snmptranslate` with the MIB files for your
particular device to get OID numbers, if needed.

## Usage

FIXME

## License

Copyright © 2015 Mike Aldred

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
