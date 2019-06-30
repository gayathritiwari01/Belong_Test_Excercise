$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/MegamenuCart.feature");
formatter.feature({
  "name": "Registration",
  "description": "  As a user\n  I want to summer dresses of  automation practice website\n  So that I can successfully add them to cart",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@MegamenuCart"
    },
    {
      "name": "@automationpractise"
    }
  ]
});
formatter.scenario({
  "name": "Add a summer dress to cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MegamenuCart"
    },
    {
      "name": "@automationpractise"
    },
    {
      "name": "@megamenu"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am at the megamenu page",
  "keyword": "Given "
});
formatter.match({
  "location": "MegamenuCartSteps.I_Am_At_megamenu_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Summer Dresses via megamenu Dresses",
  "keyword": "When "
});
formatter.match({
  "location": "MegamenuCartSteps.I_navigate_to_Summer_Dresses_via_megamenu_Dresses()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to add a dress to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "MegamenuCartSteps.I_should_be_able_to_add_a_dress_to_the_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the Cart Summary page",
  "keyword": "And "
});
formatter.match({
  "location": "MegamenuCartSteps.I_navigate_to_the_Cart_Summary_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see product details",
  "rows": [
    {
      "cells": [
        "productname",
        "Printed Summer Dress"
      ]
    },
    {
      "cells": [
        "productcolor",
        "Yellow"
      ]
    },
    {
      "cells": [
        "productqty",
        "1"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MegamenuCartSteps.I_should_see_product_details(Item)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/main/resources/features/Register.feature");
formatter.feature({
  "name": "Registration",
  "description": "  As a user\n  I want to register myself to automation practice website\n  So that I can do online shopping",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@automationpractise"
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
      "name": "@automationpractise"
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
formatter.embedding("image/png", "embedded5.png");
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
formatter.embedding("image/png", "embedded6.png");
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
formatter.embedding("image/png", "embedded7.png");
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
      "name": "@automationpractise"
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
formatter.embedding("image/png", "embedded8.png");
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
formatter.embedding("image/png", "embedded9.png");
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
formatter.embedding("image/png", "embedded10.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});