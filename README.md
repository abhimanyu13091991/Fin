# Fin

How to run the application locally:
--------------------------
Go to this package in your IDE
package --> com.fin.payment.fundtranfer
class   --> FundtranferApplication.java
Right click on this class --> Run as --> java application

Swagger-URL
------------
http://localhost:8080/swagger-ui/

H2-console
-----------
http://localhost:8080/h2-console/

How to run the application as Docker Container:
----------------------------------------------

docker run -p 8081:8080 -d abhimbha/fund-transfer:0.0.1-SNAPSHOT
http://localhost:8081/swagger-ui/

DB Details
-----------
url=jdbc:h2:mem:testdb
driverClassName=org.h2.Driver
username=sa
password=password


Inserted some record in Account table: default
--------------------------------------
AccountNumber AccountName AccountType Amount
('Account1','user1','wallet',1500);
('Account2','user2','wallet',1500);
('Account3','user3','wallet',1500);
('Account4','user4','wallet',1500);



API:
----

To get the balance using accountNumber :Account1,Account2,Account3,Account4
---------------------------------------------------------------------------

account --> Account1
@PostMapping("/balance/{account}")

To tranfer amount from one account to another --> Account1 --->Account2
------------------------------------------------------------------------
frmAccount--> Account1
toAccount --> Account2
amount    --> 500

@PostMapping("/transact/{frmAccount}/{toAccount}/{amount}")

To get all the transaction details of an Account -->Account1,Account2
---------------------------------------------------------------------

frmAccount --> Account1
@PostMapping("/transaction/{frmAccount}")


Data persistence
-----------------
I have used H2 in memory database for data persistence, Url for the same has been shared above.
http://localhost:8080/h2-console/

Docker Container
----------------

pushed the image as abhimbha/fund-transfer:0.0.1-SNAPSHOT
run--> docker run -p 8081:8080 -d abhimbha/fund-transfer:0.0.1-SNAPSHOT
http://localhost:8081/swagger-ui/





