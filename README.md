# MAIL SENDER DEMO
The simple project to send e-mails using Java


# Requisites

- Java 1.8
- Spring Boot 2.0.1.RELEASE

<code>

    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Finchley.RC1</spring-cloud.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

</code>


# Email configurations available

- MailHog (local)

<pre>
# LOCAL SMTP MAIL SERVER
### Tip: Use a test mail server as the MailHog (see more in docker-series ion GitHub huntercodexs account)
#mail-sender.to={RECEPTOR-USERNAME}@gmail.com
#mail-sender.from=huntercodexs@mail.com
#spring.mail.host=192.168.0.204
#spring.mail.port=31025
#spring.mail.username=huntercodexs@mail.com
#spring.mail.password=
#spring.mail.properties.mail.smtp.auth=false
#spring.mail.properties.mail.smtp.starttls.enable=true
#spring.mail.properties.mail.smtp.connectiontimeout=5000
#spring.mail.properties.mail.smtp.timeout=5000
#spring.mail.properties.mail.smtp.writetimeout=5000
#spring.mail.properties.mail.smtp.socketFactory.port=31025
#spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
</pre>

- Outlook

<pre>
# OUTLOOK SMTP MAIL SERVER
#mail-sender.to={RECEPTOR-USERNAME}@gmail.com
#mail-sender.from={OUTLOOK-USERNAME}@outlook.com
#spring.mail.host=smtp-mail.outlook.com
#spring.mail.port=587
#spring.mail.user={OUTLOOK-USERNAME}@outlook.com
#spring.mail.username={OUTLOOK-USERNAME}@outlook.com
#spring.mail.password={APP-PASSWORD}
#spring.mail.properties.mail.smtp.ssl=true
#spring.mail.properties.mail.smtp.auth=true
#spring.mail.properties.mail.smtp.starttls.enable=true
#spring.mail.properties.mail.smtp.starttls.required=true
#spring.mail.properties.mail.smtp.connectiontimeout=5000
#spring.mail.properties.mail.smtp.timeout=5000
#spring.mail.properties.mail.smtp.writetimeout=5000
#spring.mail.properties.mail.smtp.socketFactory.port=587
#spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
</pre>

- Office 365
<pre>
# OFFICE-365 SMTP MAIL SERVER
#mail-sender.to={RECEPTOR-USERNAME}@gmail.com
#mail-sender.from={OFFICE365-USERNAME}@outlook.com
#spring.mail.host=smtp.office365.com
#spring.mail.port=587
#spring.mail.user={OFFICE365-USERNAME}@outlook.com
#spring.mail.username={OFFICE365-USERNAME}@outlook.com
### In this case is required have to one account for Office 365 products
### and then generate the app password as administrator
#spring.mail.password={APP-PASSWORD}
#spring.mail.properties.mail.smtp.ssl=true
#spring.mail.properties.mail.smtp.auth=true
#spring.mail.properties.mail.smtp.starttls.enable=true
#spring.mail.properties.mail.smtp.starttls.required=true
#spring.mail.properties.mail.smtp.connectiontimeout=5000
#spring.mail.properties.mail.smtp.timeout=5000
#spring.mail.properties.mail.smtp.writetimeout=5000
#spring.mail.properties.mail.smtp.socketFactory.port=587
#spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
</pre>

- Gmail

<pre>
# GMAIL SMTP MAIL SERVER
#mail-sender.to={RECEPTOR-USERNAME}@outlook.com
#mail-sender.from={GMAIL-USERNAME}@gmail.com
#spring.mail.host=smtp.gmail.com
#spring.mail.port=587
#spring.mail.user={GMAIL-USERNAME}@gmail.com
#spring.mail.username={GMAIL-USERNAME}@gmail.com
### In this case, use (App Passwords) from your Google account
### See more details in: https://support.google.com/accounts/answer/185833?visit_id=638435192013564446-2153225892&p=InvalidSecondFactor&rd=1
#spring.mail.password={APP-PASSWORD}
#spring.mail.properties.mail.smtp.ssl=true
#spring.mail.properties.mail.smtp.auth=true
#spring.mail.properties.mail.smtp.starttls.enable=true
#spring.mail.properties.mail.smtp.starttls.required=true
#spring.mail.properties.mail.smtp.connectiontimeout=5000
#spring.mail.properties.mail.smtp.timeout=5000
#spring.mail.properties.mail.smtp.writetimeout=5000
#spring.mail.properties.mail.smtp.socketFactory.port=587
#spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
</pre>

# How to use

- Set up the configurations [application.properties](src/main/resources/application.properties)

- Make a review and code adjusts [mailsenderdemo](src/main/java/com/huntercodexs/mailsenderdemo)

- Make a test 
  - Without attachment file 
    - GET http://localhost:31303/mail-sender-demo/api/send
  - With attachment file 
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/conf
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/csv
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/doc
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/jpg
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/pdf
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/png
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/txt
    - GET http://localhost:31303/mail-sender-demo/api/send-attach/xls
