## Run 3 kafka cluster 
```
$ docker run --rm -ti -e KAFKA_HEAP_OPTS='-Xmx64M -Xms64M' -e KAFKA_BROKER_ID=1 -e KAFKA_ZOOKEEPER_CONNECT="172.17.42.1:2181,172.17.42.1:2182,172.17.42.1:2183" -e KAFKA_ADVERTISED_PORT=9092 -e KAFKA_ADVERTISED_HOST_NAME=172.17.42.1 --publish 9092:9092 endocode/kafka
$ docker run --rm -ti -e KAFKA_HEAP_OPTS='-Xmx64M -Xms64M' -e KAFKA_BROKER_ID=2 -e KAFKA_ZOOKEEPER_CONNECT="172.17.42.1:2181,172.17.42.1:2182,172.17.42.1:2183" -e KAFKA_ADVERTISED_PORT=9093 -e KAFKA_ADVERTISED_HOST_NAME=172.17.42.1 --publish 9093:9092 endocode/kafka
$ docker run --rm -ti -e KAFKA_HEAP_OPTS='-Xmx64M -Xms64M' -e KAFKA_BROKER_ID=3 -e KAFKA_ZOOKEEPER_CONNECT="172.17.42.1:2181,172.17.42.1:2182,172.17.42.1:2183" -e KAFKA_ADVERTISED_PORT=9094 -e KAFKA_ADVERTISED_HOST_NAME=172.17.42.1 --publish 9094:9092 endocode/kafka
```

## Create Kafka topics

```
$ docker run --rm -ti -e ZK="172.17.42.1:2181,172.17.42.1:2182,172.17.42.1:2183" endocode/kafka bash -c "\$KAFKA_HOME/bin/kafka-topics.sh --create --topic topic --partitions 3 --zookeeper \$ZK --replication-factor 2"
```

## Write messages to topic (be the producer):
```
$ docker run --rm -ti -e ZK="172.17.42.1:2181,172.17.42.1:2182,172.17.42.1:2183" endocode/kafka bash -c "\$KAFKA_HOME/bin/kafka-console-producer.sh --topic=topic --broker-list=172.17.42.1:9092"
```

## Read messages (be the consumer):
```
$ docker run --rm -ti -e ZK="172.17.42.1:2181,172.17.42.1:2182,172.17.42.1:2183" endocode/kafka bash -c "\$KAFKA_HOME/bin/kafka-console-consumer.sh --zookeeper \$ZK --topic topic –from-beginning"
```
