@login
Feature: Library app login feature
  User Story: users should successfully log in
  Background:
    Given I am on the login page
  @student
  Scenario: Login as a student
    When I login as a student
    Then books should be displayed

  @librarian
  Scenario: Login as librarian
    When I login as a librarian
  Then dashboard should be displayed







