
@second
Feature: sample karate test script




  Scenario: get all users and then get the first user by id

    Given url 'http://dummy.restapiexample.com/api/v1/employee/55808'
    When method get
    Then status 200

    * print response