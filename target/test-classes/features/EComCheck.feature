Feature: E-Commerce Checkout Automation 


Background:
 Given User is on the product page
 When User adds "Brocolli " , "Pomegranate ", "Mushroom ","Walnuts","Beetroot" to cart
 Then Cart should have 5 items

Scenario: Add vegatables to cart and checkout with valid promo
 When User proceed to checkout and apply promo "rahulshettyacademy"
 Then Discount should be applied and order placed successfully


Scenario Outline: Handle invalid promo code
 When User apply invalid promo "<promocode>" 
 Then Error message "<error>" should be displayed

Examples: 
|promocode| error 		  |
|invalid  |Invalid Code !!|
