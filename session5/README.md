# HW: Sesion 5

Note: used istio version 1.6

#Auth0 OIDC configuration

Run script: `script-auth.sh`

[Configuration for Auth0 JWT token validation](/network/auth.yml)

#Validation
Request: ```curl --request GET   --url http://localhost/frontend-catalog/api/v1/dashboard/   --header 'authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IlFrM1ZkQWNkbWpkSmY5WVR3Y1dibyJ9.eyJpc3MiOiJodHRwczovL2Rldi1sb2hpa2EuYXV0aDAuY29tLyIsInN1YiI6IkxOb3VQNlRVUDVpTU1NT2kwd0ZXRHJsajlwMWJhYnBEQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2Jvb2tpbmZvLmlvIiwiaWF0IjoxNTkxNzE3MTAwLCJleHAiOjE1OTE4MDM1MDAsImF6cCI6IkxOb3VQNlRVUDVpTU1NT2kwd0ZXRHJsajlwMWJhYnBEIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.Ugo9mFGyI9iVA4mgUaNB8hac2qHU2Q83znJMhHbf9ZB4qHWhKbRwKszH-UHDFsgh3geciPc-FVx2UKCDFVF2Npb_lHUGHvANGsexVU2sv34ZSHUrIlR3Wxm85PxV_es7NY8vVfarLtyk617vF0_OXFvvgvF3bzfBJzhZUEQQQqP8FsMMeNjKMhv4cKnasE1CqHeB3X8TGtrb6_i30crdoCMqMwOigAHpJJf6t4yaE2hX8k01jC2a6ZqD2q15OkzTRSWm2afLTRacsynZFcGPfssAWoO38jWv3ADY_OK9zy2CdahGcHVNEt53WegFg3qRxDyx40aWn_CSf22-lmGKpw'```

Respponse: ```{"authors":[{"id":1,"firstName":"Loreth Anne","lastName":"White","birthDate":"1959-12-28T00:00:00.000+0000"},{"id":2,"firstName":"Lisa","lastName":"Regan","birthDate":"1979-12-31T00:00:00.000+0000"},{"id":3,"firstName":"Ty","lastName":"Patterson","birthDate":"1964-06-11T00:00:00.000+0000"}],"developer":"Oleksii Sitnianskyi","books":[{"id":1,"title":"Semiosis: A Novel","pages":326,"authorId":1,"genre":"Science fiction"},{"id":2,"title":"The Loosening Skin","pages":132,"authorId":1,"genre":"Science fiction, Fantasy"},{"id":3,"title":"Ninefox Gambit","pages":384,"authorId":2,"genre":"Science-fiction, Space-opera"},{"id":4,"title":"Raven Stratagem","pages":400,"authorId":3,"genre":"Science fiction, Fantasy, Space-opera"},{"id":5,"title":"Revenant Gun","pages":466,"authorId":3,"genre":"Science-fiction, Space-opera"}]}```

Request: `curl --request GET --url http://localhost/frontend-catalog/api/v1/dashboard/`
Respponse: `RBAC: access denied`


#Enable mTLS in cluster

Run script: `script-mtls.sh`

[Configuration for mTLS](/network/destination-rule-mtls.yml)

![Alt text](resources/mtls.png?raw=true)