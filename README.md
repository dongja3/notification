# notification
## Try snyc call in postman
http://localhost/api/notification
```json
{
    "type":"sms",
    "receiver":"1301020202020",
    "message": "hello from sync call"
}
```

## Try asnyc call in postman
http://localhost/api/notification/sendmsg
```json
{
    "type":"sms",
    "receiver":"1301020202020",
    "message": "hello from sync call"
}
```
