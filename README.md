This is a fork of the Java client library for Google Identity Toolkit services.

[![Build Status](https://travis-ci.org/Hollerweger/identity-toolkit-java-client.svg?branch=master)](https://travis-ci.org/Hollerweger/identity-toolkit-java-client)

Initialize Gitkit client instance

```
GitkitClient gitkitClient = GitkitClient.newBuilder()
      .setGoogleClientId("your-oauth2-web-client-id-at-Google")
      .setServiceAccountEmail("your-service-account-email-at-Google-developer-console")
      .setKeyStream(new FileInputStream("path-to-your-service-account-private-file"))
      .setWidgetUrl("/gitkit.jsp")
      .setCookieName("gtoken")
      .build();
```

Verifies a GitkitToken

```
GitkitUser gitkitUser = gitkitClient.validateTokenInRequest(request);
```

Download all accounts from Google Identity Toolkit

```
Iterator<GitkitUser> userIterator = gitkitClient.getAllUsers();
while (userIterator.hasNext()) {
  // individual user info is returned in userIterator.next()
}
```
