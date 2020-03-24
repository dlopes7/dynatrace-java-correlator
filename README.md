# Dynatrace Java Correlator

This is a simple webservice, that responds to requests on any path with a Dynatrace correlation tag.

This is intended to be used in a very specific case:

* An application, where the Dynatrace SDK cannot be used (IIB Execution Group)
* The application makes a request to this webservice
* The response is a single string with the Dynatrace Tag.
* The tag is injected onto the outgoing request for downstream processing

## Usage

1. Download the latest version from Releases
2. java -jar correlator-0.0.1-SNAPSHOT.jar
3. `curl http://localhost:8080`

### Configuration

#### Port

* By default 8080, can be changed with `-Dserver.port` 

#### Downstream

* Hostname: cyberbankCoreAlias, can be changed with `-Dcorrelator.hostname`
* Port: 4444, can be changed with `-Dcorrelator.port`

#### Logging

Requests and tags will be logged to the console and `/tmp/dynatrace-correlator.log`

```log
2020-03-23 20:57:09.434 INFO  DynatraceController:26 (http-nio-8080-exec-2) - Received GET on 'http://arch-david:8080/' from 0:0:0:0:0:0:0:1
2020-03-23 20:57:09.439 INFO  Correlator:27 (http-nio-8080-exec-2) - Created tag 'FW4;2041375367;8;-1303529815;1;0;126298367;836;564d;2h01;3hb24db6a9;4h01' for 'cyberbankCoreAlias:4444'
2020-03-23 21:04:40.983  INFO  DynatraceController:26 (http-nio-8080-exec-1) - Received GET on 'http://arch-david:8080/' from 0:0:0:0:0:0:0:1
2020-03-23 21:04:40.995  INFO  Correlator:27 (http-nio-8080-exec-1) - Created tag 'FW4;2041375367;9;1015452124;0;0;126298367;720;8343;2h01;3h3c8691dc;4h00' for 'cyberbankCoreAlias:4444'
```