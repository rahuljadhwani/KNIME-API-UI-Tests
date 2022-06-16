# KNIME hub UI-API test automation using Selenium and RestAssured.

****************************************************************************

How to run this framework?
> Please make sure you have Java 11+, Maven, Chrome and/or Firefox browsers installed in your system. 
> Also environment variables are set for them.

Clone this repository to your workspace.
1. Open Terminal
2. Navigate to cloned project folder where pom.xml is present
3. Run one of the following commands: "mvn clean test -Dbrowser=chrome" or "mvn clean test -Dbrowser=firefox"
Note: If you won't add "-Dbrowser" in above maven command, by default it will run on Chrome browser.

******************************************************************************

Sensitive Data management:

Sensitive data like usernames and passwords are now Base64 encoded and added in properties file for simplicity.

******************************************************************************

Reports:

1. Report can be found inside "extent-test-output" folder in project directory with name index.html after test run.
2. Default TestNG reports are also generated in project directory - target -> surefire-reports -> "emailable-report.html"


******************************************************************************

Below mentioned improvements would be good to have if more time is spent on framework:

1. Data driven tests using @DataProvider and/or data can be fetched from an Excel sheet can be added.
2. For sensitive data - advanced encryption techniques and processes like "git-crypt" can be implemented(requires extra installations and gnupg key generations in every repository- collaborator systems)