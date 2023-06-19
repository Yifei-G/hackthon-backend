#!/bin/bash

json='{
    "message": "This is a message",
}'

username="admin"
password="admin"
auth_header="Authorization: Basic $(echo -n "$username:$password" | base64)"

ab -c 10 -n 200 -T 'application/json' -p <(echo "$json") -r -s 500 -H "$auth_header" http://localhost:8085/api/message/send
