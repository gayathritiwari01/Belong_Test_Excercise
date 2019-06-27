$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/Register.feature");
formatter.feature({
  "name": "Registration",
  "description": "  As a user\n  I want to register myself to automation practice website\n  So that I can do online shopping",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@register"
    }
  ]
});
formatter.scenario({
  "name": "Register with valid email",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@pass"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am at the Authentication page",
  "keyword": "Given "
});
formatter.match({
  "location": "RegisterSteps.I_Am_At_The_Authentication_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "enter a valid email address: gayathri.tiwari01@yopmail.com.au",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterSteps.enter_a_valid_email_address(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to proceed with Registeration: Create an account",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterSteps.I_should_be_able_to_proceed_with_Registeration(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Register with invalid email",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@fail"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am at the Authentication page",
  "keyword": "Given "
});
formatter.match({
  "location": "RegisterSteps.I_Am_At_The_Authentication_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "enter an invalid email address",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterSteps.enter_an_invalid_email_address()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see error message: Invalid email address.",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterSteps.I_should_see_error_message(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded5.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});