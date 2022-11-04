## ACCOUNT SERVICE
Create new Account
```
$ curl --location --request POST 'http://localhost:6000/accounts/' --header 'Content-Type: application/json' --header 'Authorization: Basic YnJvd3Nlcjo=' --data-raw '{"scope": "ui","username":"guestguest","password":"password","grant_type": "password"}'

{"name":"guester","lastSeen":"2021-08-06T11:10:22.051+0000","incomes":null,"expenses":null,"saving":{"amount":0,"currency":"USD","interest":0,"deposit":false,"capitalization":false},"note":null}
```

GET Current Account
```
curl --location --request GET 'http://localhost:6000/accounts/current' --header 'Authorization: Bearer e1650361-1114-42de-b9c2-a842e0d1e7de' --header 'Content-Type: application/json'

{"name":"guest","lastSeen":"2021-08-06T11:22:08.470+0000","incomes":null,"expenses":null,"saving":{"amount":0,"currency":"USD","interest":0,"deposit":false,"capitalization":false},"note":null}
```

CREATE Account Profile
```
curl --location --request POST 'http://localhost:6000/accounts/profile' --header 'Authorization: Bearer 52ea581f-2647-449a-b349-ed99fa53172d' --header 'Content-Type: application/json' --data-raw '{"firstname": "Kevin", "lastname": "Nguyen", "email": "tuanna47@fpt.com.vn", "countryname": "Vietnam", "postalcode": "700000", "phonenumber": "+84933864884"}'
```

GET Account Profile
```
curl --location --request GET 'http://localhost:6000/accounts/profile' --header 'Authorization: Bearer 52ea581f-2647-449a-b349-ed99fa53172d' --header 'Accept: application/json'

{"firstname":"Kevin","lastname":"Nguyen","email":"tuanna47@fpt.com.vn","postalcode":70000,"phonenumber":"+84933864884","countryName":"Vietnam"}
```

UPDATE Account Profile
```

```

## ACCESS SERVICE
login to msfrpcd port 55553
```
curl --location --request POST 'http://access-service:8000/access/metasploit/login' --header 'Authorization: Bearer 8a0f86fd-691d-401f-90be-a4c917713c84'

{"result":"success","token":"TEMPn2bg8vfmFtPrklCutxWjp4kIa3th"}

```
execute a module metasploit
```
curl --location --request POST 'http://access-service:8000/access/metasploit/module/execute' --header 'Content-Type: application/json' --header 'Authorization: Bearer 8a0f86fd-691d-401f-90be-a4c917713c84' --data-raw '{"token":"TEMP4u9qJOGLH3KL5Ru2jqgDGkVXVm0p", "moduleType": "auxiliary", "moduleName": "scanner/sip/options", "host": "112.213.83.81", "port":"5060"}'

```

info a module metasploit
```
curl --location --request POST 'http://localhost:8000/access/metasploit/module/info' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPvcwac74uCho2SMpdr7iY5SoC0hL0", "moduleType": "auxiliary", "moduleName": "scanner/sip/options"}'
```
info a job metasploit
```
curl --location --request POST 'http://localhost:8000/access/metasploit/job/info' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPvcwac74uCho2SMpdr7iY5SoC0hL0", "jobID": "14"}'
```

log of a task  ( PRO VERSION ONLY)
```
curl --location --request POST 'http://localhost:8000/access/metasploit/pro/tasklog' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPOtCmHOeTelizXmrHiK0u8WoLaSsr", "jobID": "14"}'
```

session list
```
curl --location --request POST 'http://localhost:8000/access/metasploit/session/list' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPzMJuDLZnyrQYkMZuQLfK9YVvyZ4Q"}'
```

console create
```
curl --location --request POST 'http://localhost:8000/access/metasploit/console/create' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPSTW9hVtVyXWHZE1sJ3OVfmlGNNM5"}'
```

console list
```
curl --location --request POST 'http://localhost:8000/access/metasploit/console/list' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TTEMPSTW9hVtVyXWHZE1sJ3OVfmlGNNM5"}'
```

console write
```
curl --location --request POST 'http://localhost:8000/access/metasploit/console/write' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPSTW9hVtVyXWHZE1sJ3OVfmlGNNM5", "consoleID": "0", "consoleCommand":"set RHOST 112.213.83.81\nset RPORT 5060\nrun\n"}'
```

console read
```
curl --location --request POST 'http://localhost:8000/access/metasploit/console/read' --header 'Content-Type: application/json' --header 'Authorization: Bearer 0c7b92b7-b789-4c72-a20c-b0bcf6db6da9' --data-raw '{"token":"TEMPSTW9hVtVyXWHZE1sJ3OVfmlGNNM5", "consoleID": "0"}'
```

## AUTHEN SERVICE
Get user token
```
curl --location --request POST 'http://auth-service:5000/uaa/oauth/token'  --header 'Authorization: Basic YnJvd3Nlcjo=' -F grant_type=password -F username=guest -F password=password -F scope=ui

"access_token":"c73566b1-eb1e-4ca7-8cdb-94df12e8e58e","token_type":"bearer","refresh_token":"4312cd25-990e-4368-8089-6782863570aa","expires_in":43199,"scope":"ui"}
```