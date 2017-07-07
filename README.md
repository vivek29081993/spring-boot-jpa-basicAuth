# spring-boot-jpa-basicAuth
A Rest Api using spring-boot , Basic auth and using Hibernate implementation for JPA for persistence 
* Hibernnate is used along with JPA for persistence to DataStore which is MySql database.
* Authentication using Spring Basic Auth using JWT.
* Session Token is returned after initial authentication, which is used in rest of the calls in the header of each call.
  something like this : 
  "Token:eyJhbGciOiJIUzUxMiJ9"


Following is the requests performed
A simple API allowing users to login and manage contacts. All contact management calls must be authenticated.

"/contacts" - GET

* List All Contacts (Authenticated)

"/contacts"  - POST

* Create Contact (Authenticated)

"/contacts/{contacts_id}" - POST

* Updates the name associated with a Contact.

"/contacts/{contacts_id}" - DELETE

* Deletes a Contact (Authenticated)

"/contacts/entries" - POST

* Adds a new phone number to a Contact. (Authenticated)

"/user" - POST

* Allows a user to login returning a session token that should be sent in all above  authenticated calls.
