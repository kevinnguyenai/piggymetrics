## LENSES FOR KAFKA ENV

### REQUIREMENT
lenses is an UI portal for management kafka cluster and in this development env is kafka standalone
before host lenses you have to host your kafka first, check document in [kafka](./kafka.md) to setup kafka first

### DEPLOYMENT
```
docker-compose -f docker-compose.dev.lenses.yml up -d

```

### RESULT
after finnish deployment , you can check you lenses environment as follow `docker-compose -f docker-compose.dev.lenses.yml ps`
```
        Name                       Command               State                  Ports
-----------------------------------------------------------------------------------------------------
piggymetrics_lenses_1   /usr/local/bin/dumb-init - ...   Up      0.0.0.0:9102->9102/tcp,:::9102->9102
                                                                 /tcp, 0.0.0.0:9991->9991/tcp,:::9991
                                                                 ->9991/tcp
```

then you can login into your lenses dashboard as follow
`http://yourdomain-ip:9991/` using default username and password admin to login
in case of change default login password, you can update docker-compose.dev.lenses.yml and recreate again

### SETUP CONNECTOR
Sample connector to elasticsearch using `elasticsearch` module from confluent , ensure that your lenses show
`Kafka Connect Clusters` is `1` it indicate that lense client was successful connect to kafka worker 
you can define your connector elasticsearch configuration as follow
```
connector.class=io.confluent.connect.elasticsearch.ElasticsearchSinkConnector
type.name=doc
behavior.on.null.values=delete
tasks.max=3
topics=fusionpbx_886a340d1b35
name=elastic-new-sink
value.converter.schemas.enable=false
connection.url=http://kafka-ip:9200
value.converter=org.apache.kafka.connect.json.JsonConverter
key.ignore=true
key.converter=org.apache.kafka.connect.storage.StringConverter
schema.ignore=true
```