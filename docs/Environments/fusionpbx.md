## FUSIONPBX 

### REQUIREMENTS
fusionpbx is an controller with UI portal help you easier to controler the core Freeswitch PBX 
your have to deploy this to run examples `Call event log streamming`

### DEPLOYMENTS
```
docker-compose -f docker-compose.dev.fusionpbx.yml up -d 
```

### RESULTS
after deployment you will have result as follow by input `docker-compose -f docker-compose.dev.fusionpbx.yml ps`
```
          Name                        Command               State                 Ports
-----------------------------------------------------------------------------------------------------
piggymetrics_db_1          docker-entrypoint.sh postgres    Up      5432/tcp
piggymetrics_fusionpbx_1   /bin/sh -c /usr/bin/superv ...   Up      0.0.0.0:16384->16384/udp,:::16384
                                                                    ->16384/udp, 0.0.0.0:16385->16385
                                                                    /udp,:::16385->16385/udp, 0.0.0.0
                                                                    :16386->16386/udp,:::16386->16386
                                                                    /udp, 0.0.0.0:16387->16387/udp,::
                                                                    :16387->16387/udp, 0.0.0.0:16388-
                                                                    >16388/udp,:::16388->16388/udp, 0
                                                                    .0.0.0:16389->16389/udp,:::16389-
                                                                    >16389/udp, 0.0.0.0:16390->16390/
                                                                    udp,:::16390->16390/udp, 0.0.0.0:
                                                                    8443->443/tcp,:::8443->443/tcp, 0
                                                                    .0.0.0:5060->5060/tcp,:::5060->50
                                                                    60/tcp, 0.0.0.0:5060->5060/udp,::
                                                                    :5060->5060/udp, 0.0.0.0:5061->50
                                                                    61/tcp,:::5061->5061/tcp, 0.0.0.0
                                                                    :5080->5080/tcp,:::5080->5080/tcp
                                                                    , 0.0.0.0:5080->5080/udp,:::5080-
                                                                    >5080/udp, 0.0.0.0:5081->5081/tcp
                                                                    ,:::5081->5081/tcp, 0.0.0.0:7443-
                                                                    >7443/tcp,:::7443->7443/tcp, 0.0.
                                                                    0.0:8880->80/tcp,:::8880->80/tcp,
                                                                    0.0.0.0:8021->8021/tcp,:::8021->8
                                                                    021/tcp
```
There will be many of port are used by fusionpbx will expose to used for registration, ws, wss, event_socket 
and many more plugion was setup and default enabled for used ready

after deployment you can go to `https://yourdomain-ip:8443/` and setup your database for fusionpbx 
- change your password login for your fusionpbx
- change ip your databse to `db` as the name of docker of `postgres`
- used a default define password of database `fusionpbx` in `docker-compose.dev.fusionpbx.yml` when setup fusionpbx first time

### NOTE
some tips remember to use fusionpbx
- change your rtp ip to public ip , this help your call media can go though two call together
you have to change `vars.xml` in `/etc/freeswitch/vars.xml` your directly on fusion portal `https://yourdomain-ip:8443/`