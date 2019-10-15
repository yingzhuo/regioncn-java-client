# regioncn-java-client

### download

```xml
<dependency>
    <groupId>com.github.yingzhuo</groupId>
    <artifactId>regioncn-java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

### config

```yaml
regioncn:
  enabled: true
  type: protobuf
  hostname: localhost
  port: 8080
```

### use

```java
@Autowired
private RegioncnService regioncnService;
```
