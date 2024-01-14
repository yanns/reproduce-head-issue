# reproduce-head-issue
Reproduce HEAD issue

## Steps to reproduce

### Run the HTTP server

```bash
sbt httpServer/run
```

### Check with curl
```bash
# curl --head localhost:8080/hello
HTTP/1.1 200 OK
Server: akka-http/10.2.6
Date: Sun, 14 Jan 2024 13:06:53 GMT
Content-Type: text/plain; charset=UTF-8
Content-Length: 2
```

### Run the tests
```bash
sbt featureTests/test
```

Update the cornichon version to `0.21.0`, and the tests will fail.
