Feature: Successfully logged in

Background: User navigates to application URL
Given The application has been launched

Scenario Outline: User should be able to login with valid credential
When i enter "<username>" in field username
And i enter "<password>" in field password
And i click on login button
Then System should display page header 'PRODUCTS'

Examples:
| username                  | password      |
| standard_user             | secret_sauce  |
| problem_user              | secret_sauce  |
| performance_glitch_user   | secret_sauce  |

Scenario Outline: User should not be able to login with invalid credential
When i enter "<username>" in field username
And i enter "<password>" in field password
And i click on login button
Then System should display '<errorMsg>' Error Message

Examples:
| username        | password        | errorMsg                                                                  |
|                 |                 | Epic sadface: Username is required                                        |
|                 | test123         | Epic sadface: Username is required                                        |
| test            |                 | Epic sadface: Password is required                                        |
| test            | test123         | Epic sadface: Username and password do not match any user in this service |
| locked_out_user | secret_sauce    | Epic sadface: Sorry, this user has been locked out.                       |