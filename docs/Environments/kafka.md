## KAFKA , ELASTICSEARCH, KIBANA , REDIS FOR YOUR DEV ENV

### REQUIREMENT
before host lenses UI for management kafka cluster or prepare an connector for your kafka source/sink from DB or to ESLASTICSEARCH, you have to deploy this first

### DEPLOYMENT
```
docker-compose -f docker-compose.dev.kafka.yml up -d
```

### RESULT
after finnish deployment you can view your deployment as below by `docker-compose -f docker-compose.dev.kafka.yml ps`

```
           Name                         Command                State                 Ports
-----------------------------------------------------------------------------------------------------
piggymetrics_elasticsearch_   /start                        Up (healthy)   0.0.0.0:9200->9200/tcp,:::
1                                                                          9200->9200/tcp, 0.0.0.0:93
                                                                           00->9300/tcp,:::9300->9300
                                                                           /tcp
piggymetrics_kafka-           /usr/bin/dumb-init -- /usr    Up             0.0.0.0:2181->2181/tcp,:::
cluster_1                     ...                                          2181->2181/tcp, 0.0.0.0:30
                                                                           30->3030/tcp,:::3030->3030
                                                                           /tcp, 3031/tcp, 0.0.0.0:80
                                                                           81->8081/tcp,:::8081->8081
                                                                           /tcp, 0.0.0.0:8082->8082/t
                                                                           cp,:::8082->8082/tcp, 0.0.
                                                                           0.0:8083->8083/tcp,:::8083
                                                                           ->8083/tcp, 0.0.0.0:9092->
                                                                           9092/tcp,:::9092->9092/tcp
                                                                           , 0.0.0.0:9581->9581/tcp,:
                                                                           ::9581->9581/tcp, 0.0.0.0:
                                                                           9582->9582/tcp,:::9582->95
                                                                           82/tcp, 0.0.0.0:9583->9583
                                                                           /tcp,:::9583->9583/tcp, 0.
                                                                           0.0.0:9584->9584/tcp,:::95
                                                                           84->9584/tcp, 0.0.0.0:9585
                                                                           ->9585/tcp,:::9585->9585/t
                                                                           cp
piggymetrics_kibana_1         /docker-entrypoint.sh         Up             0.0.0.0:5601->5601/tcp,:::
                              kibana                                       5601->5601/tcp
piggymetrics_redis_1          docker-entrypoint.sh redis    Up             0.0.0.0:6379->6379/tcp,:::
                              ...                                          6379->6379/tcp

```

### NOTE
After finnish deployment , you can login into kibana to show your elastic data by `http://yourdomain-ip:5601/`
kafka have many port information expose as follow:
```
BROKERS: 9092
ZOOKEEPER: 2181 - JMX : 9585
JMX METRICS PORTS: 9581
SCHEMA REGISTRY: 8082 - JMX: 9582
KAFKA CONNECT: 8083 - JMX: 9584
WEB: 3030
```