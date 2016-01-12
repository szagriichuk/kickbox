# kickbox

The Java API for the <a href="http://docs.kickbox.io/docs/using-the-api">Kickbox.io</a> service.

# How to use

Simple validate:

```
 KickBoxApi kickBoxApi = new KickBoxApi("KEY");
 boolean valid = kickBoxApi.verify("your_email@gmail.com");
```

Validate with response:

```
 KickBoxApi kickBoxApi = new KickBoxApi("KEY");
 KickBoxResponse response = kickBoxApi.verifyWithResponse("your_email@gmail.com");
```
Where KickBoxResponse is response structure:
 
```
 public class KickBoxResponse {
     public String result;
     public String reason;
     public boolean role;
     public boolean free;
     public boolean disposable;
     public boolean accept_all;
     public String did_you_mean;
     public double sendex;
     public String email;
     public String user;
     public String domain;
     public boolean success;
}
```

# Build for Java application
 
 ```gradle clean test jar``` or ```gradle -Pprofile=none clean jar``` 

# Build for Android application
 
 ```gradle -Pprofile=android clean jar```



