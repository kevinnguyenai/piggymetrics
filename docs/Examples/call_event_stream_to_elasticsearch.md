## CALL EVENT STREAM FROM FUSIONPBX TO ELASTICSEARCH FOR MONITORING , TROUBLESHOOTING , HISTORIES REPORT  USECASES


### I. REQUIREMENTS
you have to deploy kafka with elasticsearch 5 and kibana by deployment [kafka](../Environments/kafka.md)
you have to deploy lenses to control your kafka cluster and setup connector [lenses](../Environments/lenses.md)


### II. DEPLOYMENTS
STEP1: - Prepare configuration for your fusionpbx by setup plugion [mod_event_kafka](https://github.com/voiceip/mod_event_kafka)
    login to your fusionpbx by `docker-compose -f docker-compose.dev.fusionpbx.yml exec fusionpbx bash`
after that you can setup requirement environment as follow input

    
    apt-get update
    apt-get install librdkafka-dev libz-dev libssl-dev
    

then you build and install plugin

    
    make
    make install
    

after installation successful your will received a response like this on console

    
    install -d /usr/lib/freeswitch/mod
    install mod_event_kafka.so /usr/lib/freeswitch/mod
    install -d /etc/freeswitch/autoload_configs
    install event_kafka.conf.xml /etc/freeswitch/autoload_configs/
    
you have to change configuration of file `event_kafka.conf.xml` to point to your kafka Broker to push event to kafka simple like this

    
    <configuration name="event_kafka.conf" description="Kafka Event Configuration">
	    <settings>
		    <param name="bootstrap-servers" value="kafka-borker-ip:9092"/>
		    <param name="topic-prefix" value="topicname"/>
		    <param name="buffer-size" value="256" />
	    </settings>
    </configuration>
    

don't  miss input input `modules.xml` to enable `mod_event_kafka`

    
     <load module="mod_event_kafka"/>

STEP2: - After finnish step 1 you have finnish fusionpbx and event will automatically stream to kafka topics as you define
now you have to define connector on your kafka cluster to stream data on topics to sink it to elasticsearch by configuration as follow

Login into lenses by `http://yourdomain-ip:9991/` and check there exist item `Kafka Connect Clusters    1` if exist , you have successful connect to deploy any connector , if not you do something wrong in deployment lenses or kafka , please check it again before do this step

OK assume that you finnish with cluster kafka + lenses deployment with ready Kafka connect clusters OK , let define connector as follow, you point into connector and add new connector, chose `elasticsearch` and define configuration like this

    connector.class=io.confluent.connect.elasticsearch.ElasticsearchSinkConnector
    type.name=doc
    behavior.on.null.values=delete
    tasks.max=1
    topics=fusionpbx-...
    name=elastic-new-sink
    value.converter.schemas.enable=false
    connection.url=http://kafka-ip:9200
    value.converter=org.apache.kafka.connect.json.JsonConverter
    key.ignore=true
    key.converter=org.apache.kafka.connect.storage.StringConverter
    schema.ignore=true

That all , finnish it and you your have an ready running connector which will automatically consume on topic `fusionpbx...` then push it to elasticsearch realtime
    