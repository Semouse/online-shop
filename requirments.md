## Menu navigation
**Scenario - main menu**  
**GIVEN** I’m an app use  
**WHEN** I run the program  
**THEN** I see the main menu  

### Tech notes:  
Main menu consists of the next items:
- Sign Up
- Sign In / Sign Out
- Product Catalog
- My Orders
- Settings
- Customer List
When User is logged in, then paragraph 2 label is changed to “Sign Out” instead of Sign In.

**Scenario - stop the program**  
**GIVEN** I’m an app user and I’m in main menu  
**WHEN** I enter ‘exit’ in console 
**THEN** program execution is stopped  

**Scenario - incorrect input handling**  
**GIVEN** I’m an app user  
**WHEN** I entered any digit except 1, or 2, or 3, or 4, or 5  
**THEN** I see the error message “Only 1, 2, 3, 4, 5 is allowed. Try one more time.” AND I navigated back to the main menu

## SIGN UP
**Scenario - new user sign up**  
**GIVEN** I’m an app user and I see main menu in console  
**WHEN** I entered 1 and I selected ‘Sign Up’ in main menu  
**THEN** registration process is started:  
- I asked to enter my first name  
- I asked to enter my last name  
- I asked to enter my password  
- I asked to enter my email  
- application successfully registered me  
- I see notification that ‘New user is created’  
- I navigated back to main menu  
- instead of ‘Sign In’ I see ‘Sign Out’ label  

### Technical note:
Each new user should have an ID.  
The ID number should be automatically incremented for each new user (static counter field should be a part of DefaultUser class)

**Scenario - new user sign up - unique email successful validation**  
**GIVEN** I’m an app user and I see main menu in console  
**WHEN** I entered 1 and I selected ‘Sign Up’ in main menu  
**THEN** registration process is started:
- I asked to enter my first name
- I asked to enter my last name
- I asked to enter my password
- I asked to enter my email
- I enter unique email
- application successfully registered me
- I see notification that ‘new user is created’
- I navigated back to main menu
- instead of ‘Sign In’ I see ‘Sign Out’ label


**Scenario - new user sign up - unique email unsuccessful validation**  
**GIVEN** I’m an app user and I see main menu in console  
**WHEN** I entered and I selected ‘Sign Up’ in main menu  
**THEN** registration process is started  
- I asked to enter my first name
- I asked to enter my last name
- I asked to enter my password
- I asked to enter my email
- I enter NOT unique email
- application doesn’t register me
- I see notification that ‘This email is already used by another user. Please, use another email’
- I navigated back to main menu

**Scenario - new user sign up - empty email unsuccessful validation**  
**GIVEN** I’m an app user and I see main menu in console  
**WHEN** I entered 1 and I selected ‘Sign Up’ in main menu  
**THEN** registration process is started
- I asked to enter my first name
- I asked to enter my last name
- I asked to enter my password
- I asked to enter my email
- I enter empty email
- application doesn’t register me
- I see notification that ‘You have to input email to register. Please, try one more time’
- I navigated back to main menu

## SIGN IN
**Scenario - successful sign in**  
**GIVEN** I’m an app user and I have registered account  
**WHEN** I entered 2 and I selected ‘Sign In’ in main menu  
**THEN** Login process is started
- I asked to enter my email
- I asked to enter my password
- credentials are valid
- I see welcome message ‘Glad to see you back <First Name> <Last Name>’
- I see main menu
- instead of ‘Sign In’ I see ‘Sign Out’ label

**Scenario - unsuccessful sign in**  
**GIVEN** I’m an app user and I have registered account  
**WHEN** I entered 2 and I selected ‘Sign In’ in main menu  
**THEN** Login process is started  
- I asked to enter my email
- I asked to enter my password
- credentials are not valid
- I see error message ‘Unfortunately, such login and password doesn’t exist’
- I see main menu

### Technical notes:
‘not valid’ credentials mean that user either not exist or password is wrong

## SIGN OUT
**Scenario - successful sign out**  
**GIVEN** I’m an app user and I’m logged in I navigated to the main menu  
**WHEN** I entered 2 and I selected ‘Sign Out’ in main menu  
**THEN** I see sign out message ‘Have a nice day! Look forward to welcoming back!’ and I see main menu  and instead of ‘Sign Out’ I see ‘Sign In’ label

## PRODUCT CATALOG
**Scenario - list products**  
**GIVEN** I’m an app user     
**WHEN** I entered 3 and I selected ‘Product Catalog’ in main menu  
**THEN** I see list of products printed to console  

### Technical notes:
Product has next fields:
- int id
- String productName
- String categoryName
- double price

**Scenario - navigate back to menu**    
**GIVEN** I’m an app user and I navigated to Product Catalog menu  
**WHEN** I enter ‘menu’ in console  
**THEN** I navigated back to the main menu

**Scenario - add product to cart**  
**GIVEN** I’m an app user and I entered and I selected ‘Product Catalog’ in main menu and I see product list
I see message:   
‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’  
**WHEN** I entered any product id  
**THEN** I see the message ‘Product <PRODUCT_NAME> has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word ‘checkout’ to console’ and I see product list again

**Scenario - add product to cart - error handling**  
**GIVEN** 
 - I’m an app user 
 - I entered 3 
 - I selected ‘Product Catalog’ in main menu
 - I see product list
 - I see message ‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’  

**WHEN** I entered any random number that doesn't match with product id  
**THEN** I see the message ‘Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu.’ and I see product list again

### CHECKOUT
**Scenario - successful checkout**  
**GIVEN** 
- I’m an app user
- I’m logged in
- I entered 3
- I selected ‘Product Catalog’ in main menu
- I see product list
- I see message ‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’
- I added products to the cart

**WHEN** I entered ‘checkout’  

**THEN** 
- I see the message ‘Enter your credit card number without spaces and press enter if you confirm purchase’ 
- I entered credit card number
- I pressed enter
- I see the message ‘Thanks a lot for your purchase. Details about order delivery are sent to your email.’
- I navigated back to main menu

### Technical notes:
Cart should be cleared after order is created


**Scenario - checkout - error handling - empty cart**

**GIVEN** 
- I’m an app user
- I entered 3
- I selected ‘Product Catalog’ in main menu
- I see product list
- I see message ‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’
- I have empty cart because I didn’t add products yet

**WHEN** I entered ‘checkout’

**THEN**
I see the message ‘Your cart is empty. Please, add product to cart first and then proceed with checkout’  
I see product list again

**Scenario - checkout - error handling - not logged in user**  
**GIVEN** 
- I’m an app user
- I entered 3
- I selected ‘Product Catalog’ in main menu
- I see product list
- I see message ‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’
- I added products to the cart
- I’m not logged in

**WHEN** I added products to the cart

**THEN** I see the message ‘You are not logged in. Please, sign in or create new account’  
I navigated back to the main menu

**Scenario - checkout - error handling - invalid credit card number**  
**GIVEN** 
- I’m an app user
- I’m logged in
- I entered 3
- I selected ‘Product Catalog’ in main menu
- I see product list
- I see message ‘Enter product ID to add it to the cart’
- I added products to the cart

**WHEN** I entered ‘checkout’

**THEN** 
- I see the message ‘Enter your credit card number without spaces and press enter if you confirm purchase’
- I entered invalid credit card number
- I pressed enter
- I see the message ‘You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.’
- I’m asked to enter credit card number one more time

### Technical note:
Implement credit card validation: any 16 digits

## MY ORDERS
**Scenario - list my orders**  
**GIVEN** I’m an app user and I’m logged in  
**WHEN** I entered 4 and I selected ‘My Orders’ in main menu  
**THEN** I navigated to ‘My Orders’.
I see list of all my purchases.
I navigated back to the main menu.

**Scenario - list my orders - error handling - not logged in**  
**GIVEN** I’m an app user  
**WHEN** I entered 4 and I selected ‘My Orders’ in main menu  
**THEN** I see message ‘Please, log in or create new account to see list of your orders’
and I navigated back to the main menu

**Scenario - list my orders - error handling - no orders**  
**GIVEN** I’m an app user and I’m logged in and I don’t have any purchases yet  
**WHEN** I entered 4 and I selected ‘My Orders’ in main menu  
**THEN** I navigated to ‘My Orders’. I see the message ‘Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order’

## SETTINGS
**Scenario - change password**
**GIVEN**
- I’m an app user
- I’m logged in
- I entered 5
- I selected ‘Settings’ in main menu
- I see list of options to change settings
- I select option number 1 ‘Change Password’
- I enter 1 in console
- I am asked to enter new password

**WHEN** I entered new password  
**THEN** I see message ‘Your password has been successfully changed’. I navigated to main menu

**Scenario - change email**  
**GIVEN**  
- I’m an app user
- I’m logged in
- I entered 5
- I selected ‘Settings’ in main menu
- I see list of options to change settings
- I select option number 2 ‘Change Email’
- I enter 2 in console
- I am asked to enter new email

**WHEN** I entered new email  
**THEN** I see message ‘Your email has been successfully changed’. I navigated to main menu

**Scenario - setting - error handling - not valid option**  
**GIVEN**  
- I’m an app user
- I’m logged in
- I entered 5
- I selected ‘Settings’ in main menu
- I see list of options to change settings

**WHEN** I enter any number beside 1 and 2  
**THEN** I see the message ‘Only 1, 2 is allowed. Try one more time’. I see settings menu again

**Scenario - setting - navigate back to the main menu**
**GIVEN**  
- I’m an app user
- I’m logged in
- I entered 5
- I selected ‘Settings’ in main menu
- I see list of options to change settings

**WHEN** I enter ‘menu’  
**THEN** I navigated back to the main menu

**Scenario - setting - error handling - not logged in**  
**GIVEN** I’m an app user  
**WHEN** I entered 5 and I selected ‘Settings’ in main menu  
**THEN** I see message ‘Please, log in or create new account to change your account settings’


## CUSTOMER LIST 
**Scenario - print list of customers to console**  
**GIVEN** I’m an app user  
**WHEN** I entered 6 and I selected ‘Customer List’ in main menu  
**THEN** I see list of customers and I navigated back to the main menu  

### Technical note:
We shouldn’t print Customer password

