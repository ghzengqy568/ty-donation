scp  ../bcd-supervision/target/bcd-supervision-1.0.0-SNAPSHOT.jar root@122.112.158.98:/root/apps/bcd/jar/
ssh root@122.112.158.98 "/usr/bin/sh /root/apps/bcd/start-supervision.sh"
