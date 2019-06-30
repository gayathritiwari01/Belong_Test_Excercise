@register @automationpractise
Feature: Registration
  As a user
  I want to register myself to automation practice website
  So that I can do online shopping

  @pass
  Scenario: Register with valid email
    Given I am at the Authentication page
    When enter a valid email address: gayathri.tiwari01@yopmail.com.au
    Then I should be able to proceed with Registeration: Create an account
    
  @fail
    Scenario: Register with invalid email
    Given I am at the Authentication page
    When enter an invalid email address
    Then I should see error message: Invalid email address.