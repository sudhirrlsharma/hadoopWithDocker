## Start the Zookeeper cluster(3) 
```
$ docker run --rm -ti -e ZK_SERVERS="server.1=172.17.42.1:2888:3888 server.2=172.17.42.1:2889:3889 server.3=172.17.42.1:2890:3890" -e ZK_ID=1 --publish 2181:2181 --publish 2888:2888 --publish 3888:3888 endocode/zookeeper
$ docker run --rm -ti -e ZK_SERVERS="server.1=172.17.42.1:2888:3888 server.2=172.17.42.1:2889:3889 server.3=172.17.42.1:2890:3890" -e ZK_ID=2 --publish 2182:2181 --publish 2889:2889 --publish 3889:3889 endocode/zookeeper
$ docker run --rm -ti -e ZK_SERVERS="server.1=172.17.42.1:2888:3888 server.2=172.17.42.1:2889:3889 server.3=172.17.42.1:2890:3890" -e ZK_ID=3 --publish 2183:2181 --publish 2890:2890 --publish 3890:3890 endocode/zookeeper
```

## Check if zookeper is working

```
$ for i in {2181..2183}; do echo mntr | nc 172.17.42.1 $i | grep zk_followers ; done
```
