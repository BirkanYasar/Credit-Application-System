## Credit Application System
---
*Writing a restful application for a loan application system, using the Spring Boot framework, which will take the loan application requests and return the loan result to the customer according to the relevant criteria.*

**Backend :** *The user's identity number, name-surname, monthly income and telephone information are obtained, the credit score service is assumed to be written with the identity number before, and the credit score of the relevant person is obtained and the credit result is shown to the user according to the following rules.
(There may be two options as Approval or Rejection.)*


- New users can be defined in the system, existing customers can be updated or deleted. -
If the credit score is below 500, the user will be rejected. (Credit result: Red) - Credit score 500
between 1000 points and 1000 points and monthly income is below 5000 TL

- The user's loan application is approved and a limit of 10,000 TL is assigned to the user. (Credit Result: Confirmation)

- If the credit score is between 500 points and 1000 points and if the monthly income is above 5000 TL
The user's loan application is approved and a limit of 20,000 TL is assigned to the user. (Credit Result: Confirmation)

- MONTHLY INCOME INFORMATION to the user if the credit score is equal to or above 1000 points * CREDIT
Limit is assigned as much as LIMIT MULTIPLIER. (Credit Result: Confirmation)

- As a result of the conclusion of the loan, the relevant application is recorded in the database. later If not, a notification SMS will be sent to the relevant phone number and the confirmation status will be sent from the endpoint.

- A completed loan application can only be queried with an identification number

**Notes :** *The credit limit multiplier is 4 by default.*

---
### Use Case Diagram
![usecasediagram](https://user-images.githubusercontent.com/94866363/184557284-5cfb1d51-1df5-439c-9d64-fedce90c4ab9.png)

---
### UML Case Diagram
![UMLCasediagram](https://user-images.githubusercontent.com/94866363/184608876-b34b503b-6010-4c79-89e9-778f314a3014.png)
