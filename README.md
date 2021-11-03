# IpChecker
Matches IP's against https://github.com/firehol/blocklist-ipsets


## Sample Request
```
POST http://localhost:8080/checkIp/
content-type: application/json

{
  "ips": ["213.194.164.102","213.194.164.101","223.72.35.210","223.72.35.212"]
}
```

## Sample Response

```
{
  "matchedIps": [
    "213.194.164.101",
    "223.72.35.210"
  ]
}
```
