# Captcha Harvester
This is a simple program that allows a user to manually harvest captchas.

# Ussage
You must first create the CaptchaHarvester object
```java
final CaptchaHarvester captchaHarvester = new CaptchaHarvester("DOMAIN", "SITE_KEY", PORT (OPTIONAL));
```

Then you can create a CaptchaWindow object (it will automatically show unless you put false in the arguments)
```java
final CaptchaWindow captchaWindow = captchaHarvester.createWindow();
```

Getting Captcha Tokens
```java
final List<CaptchaToken> tokens = captchaWindow.getCaptchaTokens();
```
