
# Automation of GitLab Issues API

This Project is a small poc of Serenity BDD framework using Cucumber, Rest-Assured and Java.
Maven has been used for dependency management.

**Table of Contents**
* [Task](#task)
* [Behavior Driven Development](#behavior-driven-development)
* [Testing Framework](#testing-framework)
* [Testing Coverage](#testing-coverage)
* [How to Run the tests](#how-to-run-the-tests)
    * [Using Maven](#1-using-maven)
    * [Using IDE](#2-using-ide)
    * [Test Result](#3-test-result)


# Task
* Task here is 
1. To perform CRUD operations on Gitlab issues API
 
* All the functional tests are created in feature files (using Gherkin).
* Step definition are written in Java class.
* API methods are written in Java class.

CRUD operations are performed, considering the time I have only tested few parameters and created automation framework in such a way that all the tests can be tested by writting proper gherkin scenarios.

Found 3 Bugs and out of 20 cases automated 3 are failing due to bugs, below are the list of Bugs

1) A issue is being created even with a past date. This should be a bug
2) Using update issue API created_at is not being updated, as per documentation this should be updated. This should be a bug
3) Views issue with milestone are not working, even when issues exist with milestone they are not displayed. This should be a bug

Above 3 Bugs are failures in Test Automation run

# Behavior Driven Development

The test cases here in the automation framework are added in BDD format.
The reason for choosing to writ tests  in BDD format are:

		1) Currently many teams are using BDD in SDLC as Acceptance criteria are very well available for both Development and testing
		2) Using BDD Acceptance test Will help the business understand the test cases very easily

# Testing Framework

I have used BDD Test Automation framework Using SerenityBDD and Rest Assured. Serenity BDD is a library which uses Cucumber and rest-assured for its API test development. There are several alternatives(like karate DSL, Chakram, postman scripts .. etc ) options out in the market but below are reason to use Serenity

### Reasons for choosing Serenity framework:

		1) Easily maintainable automated acceptance criteria
		2) Compatiable with several opensource tools also built on famous libraries like selenium, cucumber and rest-assured
		3) Storage of data in runtime for easy access
		4) Living documentation of test results
		5) Opensource tool with huge support Online

# Testing Coverage

Test coverage is a living documentation thats generated from test automation, this a huge advantage of using Serenity BDD.

Detailed test coverage report along with the results and clasification can be found [here_on_this_link](https://output.circle-artifacts.com/output/job/05a57b6e-eaf1-42f0-ae86-e8af2d72f723/artifacts/0/target/site/serenity/index.html)

# How to Run the tests

	# Pre-requisite:
	* JDK 8
	* Maven is installed in the machine and configured properly


## 1) Using Maven

	Open a command window and run:

		WindowsOS:	mvn clean verify

		MacOs : mvn clean verify 

	To Run Specific Tags of a test (Specific group of tests):

	  	mvn clean verify -Dcucumber.options="--tags @TAGNAME"

## 2) Using IDE
	Open the cloned project in IDE. Enable Auto-Import for Maven-dependency
	Run Testrunner files in the path (\src\test\java\runner\RunAllTest.java)


## 3) Test Result
Serenity BDD has one of the best reporting and the test reports are generated every time we execute the tests.
When the project is cloned into Local, test results reporting, along with screenshots, can be seen if we open **_`index.html`_** from `(target\site\serenity\index.html)`.

Also a sample executed results can be found in this [link](https://output.circle-artifacts.com/output/job/05a57b6e-eaf1-42f0-ae86-e8af2d72f723/artifacts/0/target/site/serenity/index.html)


Kindly let me know if you need any further Information. You can contact me on my emailID.
