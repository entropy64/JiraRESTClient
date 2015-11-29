# JiraRESTClient

A Java client for interacting with the JIRA REST API.

### Example Usage:

```java
final String url = "http://jira.organisation.org";
final String username = "Jono";
final String password = "aPa$$w0rd";
 
final JiraClient client = JiraClient.builder()
    .baseURL(url)
    .username(username)
    .password(password)
    .build();

Issue issue = client.getIssue("FYP-100");
```    

### Disclaimer

This library is currently still under active development, a MAVEN artifact will be published when complete.
