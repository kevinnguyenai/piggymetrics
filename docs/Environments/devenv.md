## PIGGY METRICS MICROSERVICE CLUSTER 


### REQUIREMENTS
Deploy piggymetrics microservice system by very simple step as below

### DEPLOYMENTS
```
docker-compose up -d 
```

### RESULT
after successful deployment you will se result as bellow by input `docker-compose ps`
```
           Name                         Command                State                 Ports
-----------------------------------------------------------------------------------------------------
piggymetrics_access-          /initx.sh                     Up             27017/tcp
mongodb_1
piggymetrics_access-          java -Xmx200m -jar /app/ac    Up             7000/tcp
service_1                     ...
piggymetrics_account-         /initx.sh                     Up             27017/tcp
mongodb_1
piggymetrics_account-         java -Xmx200m -jar /app/ac    Up             6000/tcp
service_1                     ...
piggymetrics_auth-mongodb_1   /initx.sh                     Up             27017/tcp
piggymetrics_auth-service_1   java -Xmx200m -jar /app/au    Up             5000/tcp
                              ...
piggymetrics_config_1         java -Xmx200m -jar /app/co    Up (healthy)   8888/tcp
                              ...
piggymetrics_elasticsearch_   /start                        Up (healthy)   0.0.0.0:9200->9200/tcp,:::
1                                                                          9200->9200/tcp, 0.0.0.0:93
                                                                           00->9300/tcp,:::9300->9300
                                                                           /tcp
piggymetrics_gateway_1        java -Xmx200m -jar /app/ga    Up             0.0.0.0:80->4000/tcp,:::80
                              ...                                          ->4000/tcp
piggymetrics_kibana_1         /docker-entrypoint.sh         Up             0.0.0.0:5601->5601/tcp,:::
                              kibana                                       5601->5601/tcp
piggymetrics_logstash_1       /usr/local/bin/docker-entr    Up             0.0.0.0:5000->5000/tcp,:::
                              ...                                          5000->5000/tcp, 5044/tcp,
                                                                           9600/tcp
piggymetrics_monitoring_1     java -Xmx200m -jar /app/mo    Up             0.0.0.0:9000->8080/tcp,:::
                              ...                                          9000->8080/tcp
piggymetrics_notification-    /initx.sh                     Up             27017/tcp
mongodb_1
piggymetrics_notification-    java -Xmx200m -jar /app/no    Up             8000/tcp
service_1                     ...
piggymetrics_rabbitmq_1       docker-entrypoint.sh rabbi    Up             15671/tcp, 0.0.0.0:15672->
                              ...                                          15672/tcp,:::15672->15672/
                                                                           tcp, 15691/tcp, 15692/tcp,
                                                                           25672/tcp, 4369/tcp,
                                                                           5671/tcp, 5672/tcp
piggymetrics_registry_1       java -Xmx200m -jar /app/re    Up             0.0.0.0:8761->8761/tcp,:::
                              ...                                          8761->8761/tcp
piggymetrics_statistics-      /initx.sh                     Up             27017/tcp
mongodb_1
piggymetrics_statistics-      java -Xmx200m -jar /app/st    Up             7000/tcp
service_1                     ...
piggymetrics_turbine-         java -Xmx200m -jar /app/tu    Up             0.0.0.0:8080->8080/tcp,:::
stream-service_1              ...                                          8080->8080/tcp
piggymetrics_zipkin_1         java -Xmx200m -jar /app/zi    Up             0.0.0.0:9411->9411/tcp,:::
                              ...                                          9411->9411/tcp
```