# City Bike Api Automated Tests 
> City Bike Api Scenarios on maven 

## How to

### Execute Tests in Local
#### 1. Maven Execution (Command-line or Intellij Terminal) : 
This is recommended for a handful of features to mimic the pipeline execution on your local machine.

 - Control the `dataproviderthreadcount` in **pom.xml** against the -profile ***local*** to the desired value (To control the parallel execution)
 - Open Command-line or Terminal (Intellij)
 - `mvn clean test -P AllTests -Dcucumber.filter.tags="@city_network_test" allure:report`
 - Allure report will be generated in ```target/allure-results/html```

#### 2. IntelliJ Execution :
This is recommended for debug or less scenarios during dry run

 - Create a new ***TestNG*** Run configuration in intelliJ
 - In the ***configuration*** tab, select the ***Test Kind*** as **Suite**
 - Add the .xml from .`./../cep_dps_front-end_application_tests_java/config/local-config.xml`
 - In VM Options parse the env and tags `-Denv=dev -Dcucumber.filter.tags="@city_network_test"` (Other params can also be parsed here including `allure:report` etc)
 - The scenario(s) can be run or debug using this option

### Generating a report
run the command ```mvn allure:report```, the html report will be generated in ```target/allure-results/html``` and it is named 'index.html'

