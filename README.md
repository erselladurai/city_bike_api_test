# City Bike Api Automated Tests 
> City Bike Api Scenarios are automated using Java, rest assured and Maven 

#User story
As a biker I would like to know the exact location of city bikes around the world in a given application.

·         Endpoint: http://api.citybik.es/v2/networks

·         Auth: No

·         HTTPS: No

·         Understands how the API works.

·         Create some BDD scenarios and automate them using Java to test the API

·         Test this particular scenario: “As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude”


## How to

### Execute Tests in Local
#### 1. Maven Execution (Command-line or Intellij Terminal) : 
 - Control the `dataproviderthreadcount` in **pom.xml** against the -profile ***local*** to the desired value (To control the parallel execution)
 - Open Command-line or Terminal (Intellij)
 - `mvn clean test -P AllTests -Dcucumber.filter.tags="@city_network_test" allure:report`

#### 2. IntelliJ Execution :
 - Create a new ***TestNG*** Run configuration in intelliJ
 - In the ***configuration*** tab, select the ***Test Kind*** as **Suite**
 - Add the .xml from .`./../cep_dps_front-end_application_tests_java/config/local-config.xml`
 - In VM Options parse the env and tags `-Dcucumber.filter.tags="@city_network_test"`
 - The scenario(s) can be run using this option

### Generating a report
**Allure setup in your system**
Download allure latest version https://docs.qameta.io/allure/
extract the binary file
in System PATH variable add allure->bin path,
check whether allure is installed or not, in cmd prompt run allure

**Step to generate allure report**
run the **GenerateReport.bat**(this should be present in the root directory) the html report will be generated and Opened in chrome automatically.

### Technical Design Overview
**Features Path** :  src\test\resources\features
- Defined the scenarios in the feature file
- Made the Get Api call to the given EndPoint.
- Created a POJO classes for the response JSON - **src/main/java/service/model** and Deserialize the same.
- Validations are applied after Deserialized the response Json to Pojo object.
