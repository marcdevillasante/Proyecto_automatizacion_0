Feature: Iniciar sesion

Scenario: Iniciar sesion con usuario valido
Given user is in the login page
When user enters valid username and password
Then the product catalog should be displayed