# **Maven Bank Application**

## **Revature Project0**

The goal of Project0 of my Revature training program is to build this Java banking application. This project allowed me to demonstrate my knowledge of Java programming, while implementing the various technologies learned in training. The application utilizes Log4j for logging of transactions, JUnit for testing various methods, Maven to handle dependencies for sharing this application, and PostgreSQL for storing and parsing the various data from the application.

## **Class Models**

#### **User**

- The `User` class provides all the personal information about whichever user is logged into the application. They hold the name, username, password, email for the application to access for various opperations.

#### **Role**

- The application is designed to handle three roles that the `User` could be: customer, employee, and administrator (admin).

#### **Account**

- This class holds all information about customer's banking accounts. Each account has an account number, routing number, and a balance. An initial balance needs to be deposited from the user in order for an account to be opened.

#### **Type**

- The `Type` class simply labels each `Account` as a personal account, or joint account. Joint accounts will have multiple customer's linked to them.

#### **Status**

- The `Status` class lets employee's and administrator's know which accounts are new and need to be approved. An account's status is defaulted to "pending" when it's opened, and the administrator can either change the `Status` to "open" or "closed". Open accounts allow the customer to perform transactions, and "closed" accounts aren't allowed to perform any transactions.

#### **AccountsUsers**

- This class simply holds the `account_id` and `user_id` for linking each user with their account(s). Primarily exists for database management.

#### **Transactions**

- This method holds the `withdrawal`, `deposit`, and `transfer` methods that the customer can perform when their specific account is open.

#### **Janus**

- This class simply holds the various `String` objects which interact with the user during the console session. `Janus` informs the user about what they should do, or let them know about invalid inputs. I tried to have some fun with his messages.