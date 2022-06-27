# IGSSeleniumTest
## Pre-requisite softwares to be installed ##

  
		* Install Java
		* Install Maven
		* Download Chromedriver (Version should match with Installed chrome browser version). Downloaded file would be in zipped format. Unzip the contents in a convenient directory
	
## Steps to run ##
   
    1. git clone the repository
	  
	  https://github.com/VINUPRASANTH/IGSSeleniumTest.git
	
	2. Go to Folder IGSSeleniumTest\src\test\resources\testdat\webdriver
	    
	   Copy and paste downloaded chromedriver file here
	
	3. Open config.properties and update platform value
	 
	   platform = windows or platform = mac
	 
	4. Go to Repo directory IGSSeleniumTest
	
	5. Open command line and execute below command
	
		mvn test
		
	6. Once test finished, go to IGSSeleniumTest\target
	
	7. Open report.html to check the result
	
	
	
