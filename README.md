https://nchain.atlassian.net/wiki/spaces/QA/pages/1358004236/BSV+node+setup

# City Bike Api Automated Tests 
> City Bike Api Scenarios are automated using Java, rest assured and Maven 

## User story
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

sudo apt-get update
sudo apt-get upgrade
sudo apt-get install build-essential linux-headers-$(uname -r)
sudo apt-get install libevent-devsudo apt-get -y install git build-essential libtool autotools-dev automake pkg-config libssl-dev libevent-dev bsdmainutils libboost-all-dev libdb-dev libdb++-dev libzmq3-dev libqt5gui5 libqt5core5a libqt5dbus5 qttools5-dev qttools5-dev-tools libprotobuf-dev protobuf-compiler

nstall more-up-to-date version of zmq manually
Informative links:
https://pkgs.org/search/?q=libzmq
https://github.com/zeromq/libzmq/archive/v4.3.2.tar.gz
https://gist.github.com/mnlcandelaria/c9a741801caf15de4e8b
https://askubuntu.com/questions/918140/how-to-install-0mq-on-ubuntu-16-04
Get the tar.gz file from step 2 and follow the instructions as per links 3 and 4
configure script might not be in directory. Run autogen.sh to create it.
Clone Bitcoin SV repo to your home directory
Internal repo is for actual testing. For just wanting to understand BSV, public repo might be more stable.
Internal: git clone https://<username>@bitbucket.org/nch-atlassian/sv.git
Public: git clone https://github.com/bitcoin-sv/bitcoin-sv.git 
Build the Bitcoin executables


1cd <repo directory>
2./autogen.sh && ./configure && make
 Starting Bitcoin SV nodes
Create the Bitcoin data directory for the node
e.g. mkdir ~/bsv-data
default is ~/.bitcoin
multiple data directories enables multiple nodes to be started (and ultimately networked)

Configure the node properties
Create a bitcoin.conf file in the data directory with the following:


Example bitcoin.conf


Start the node
<repo directory>/src/bitcoind #will start with default data directory .bitcoind
e.g. 


1angeliki@angeliki-VirtualBox:~/bitcoin-sv/src$ $PWD/bitcoind
2Bitcoin server starting
3angeliki@angeliki-VirtualBox:~/bitcoin-sv/src$ ps -ef | grep bitcoin
4angeliki 15814     1 22 09:29 ?        00:00:00 /home/angeliki/bitcoin-sv/src/bitcoind
5angeliki 15847 13926  0 09:29 pts/4    00:00:00 grep --color=auto bitcoin
or with a custom data directory


1cd <repo directory>/src/
2./bitcoind -datadir=<custom-dir> #choose custom data directory
Monitor logging
Duplicate tab in mRemoteNG (if using) and run tail -f <data directory>/regtest/bitcoind.log

git clone https://srajan1988@bitbucket.org/nch-atlassian/sv.git
