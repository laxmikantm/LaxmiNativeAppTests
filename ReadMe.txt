(c) Laxmikant Somni


=========================
Note
=========================
Requirement:
Firefox 41.0 or earlier
(Make sure that Firefox is not on the most latest version as SeleniumHQ might not yet incorporated it in their supported version)

OS: Mac OS X
or Win 7/8

Java 7 - installed

1. I have created Couple of variants of this exercise.

All tests are build using standard packaging solution: Maven. 
& could be centrally deployed using standard POM.XML
Few tests are written in Cucumber BDD fashion and few in traditional TestNG driven

To Run Test:
a) Import Maven Dependencies (if not done earlier)
b) Option1: Right click on POM.XML & Run As> Maven Install
(This will in turn invoke TestNG driven tests on FireFox)
> Right Click on testng.xml & Run as > TestNg test

Option2: 
Right click on POM.XML & Run As> Maven Install
(This will in turn invoke TestNG driven tests on FireFox)
>From Project tree expand below package:
com.seleniumtests.test
> Then by right clicking Run WebDriverExcercise.java as TestNG test {Preferred way in local development env.}


c) If you would like to change the Browser then change browser value in testng.xml

2. Tests will create static snapshots at below folder
/LaxmiSearchScreenExcercise/target/snapshots

3. Tests will also create screen recordings & will store in 
/username/movies folder in Mac OS X environment
and 
/documents/Videos folder in Windows environment

4. TestNG result
/LaxmiSearchScreenExcercise/test-output/Default suite/Default test.html

Thanks


