# GaribKart

# The application flow.

You enter the application.
**The application will ask you for login or register.**
     If you skip login or register it will show you the product list as a guest user.
     You will be able to see the product. 
          If you still choose to buy any product again it will prompt you to login or register. 
          If you do you will be able to checkout else the application will be closed with thank you for visiting GaribKart message.
          
**If you login and the logged in user is:**
     An admin: it will open all the operations admin can perform.
     User: Buy product, check cart, etc.
     
**If you register again it will ask you to login then the same process as mentioned in the previous option.**



**How to update the database?**
garibKart has 4 tables in the database:
1. users
2. product
3. roles
4. purchase history.

**For inserting users in the table. **
     you can use the addUser() method of UserConnection class.

**For adding the products in the product table**
     You can use the insertData() method from the ProductOperation class.

**For purchase history**
     You can use the recordPurchase() method of ProductOperation class.

**For user and admin roles**
     There is a UserConnection class where you can update the roles using the insertRole().
     You can assign roles to the user using assignRoleToUser();
