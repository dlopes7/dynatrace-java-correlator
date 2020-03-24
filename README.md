# Dynatrace Java Correlator

This is a simple webservice, that responds to requests on any path with a Dynatrace correlation tag.

This is intended to be used in a very specific case:

* An application, where the Dynatrace SDK cannot be used (IIB Execution Group)
* The application makes a request to this webservice
* The response is a single string with the Dynatrace Tag.
* The tag is injected onto the outgoing request for downstream processing

