# **Maven Bank Application**

## **Revature Project0**

The goal of Project0 of my Revature training program is to build this Java banking application. This project allowed me to demonstrate my knowledge of Java programming, while implementing the various technologies learned in training. The application utilizes Log4j for logging of transactions, JUnit for testing various methods, Maven to handle dependencies for sharing this application, and PostgreSQL for storing and parsing the various data from the application.

## **Classes**

#### **Transactions**

- This method holds the `withdrawal`, `deposit`, and `transfer` methods that the customer can perform when their specific account is open.

#### **Janus**

- This class simply holds the various `String` objects which interact with the user during the console session. `Janus` informs the user about what they should do, or let them know about invalid inputs. I tried to have some fun with his messages.

#### **Menus**

- This class has three methods: `customerMenu`, `employeeMenu`, and `adminMenu`. Each method provides the logic flow for the `Driver` class's `main` method depending on which role the application user is.

#### **ProjectUtil**

- This class holds a variety of helper methods used by many of the other classes methods. The most notable methods are the `login`, `registerUser`, and `registerAccount` methods which are integral to the console flow. 

## **DAO Interfaces/Models**

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

## **Future Improvements**

- Improve the Javalin implementation to utilize forms and HTML for a prettier front end.
- Allow users to update their personal information.
- Allow employees and admins to hold accounts.
- Add color output and more concise text output for improved clarity of operations.
- Implement serialization in order to save a current session to return to.
- Connect user with their account when viewing accounts.
- Add more input checks for `Scanner.next()` method throughout the app.

## **Conclusion**

Building this application was a great challenge for me. I've never built an application this comprehensive of different technologies and it was fulfilling to have something working at the end. I feel like I understand scope, and Java loops significantly more now. While working on a project of this size I realized the importance of breaking up features and fully testing each feature before moving onto another aspect of the project. It was really easy for me to think of a better implementation of some other feature while I was working on another feature related to it. Often I went back and rewrote code, which was a terribly inefficient use of my time. 

I think the overall lesson I'll take from this project is to be overly organized and specific at the beginning when planning, then stay focused on that plan when building the project. When things are working at the end it's easier to go back and make aspects more efficient, instead of doing it in the middle of one aspect of the project. I hope to come back to this project and make things better in the future.