Feature: Add To Cart

Scenario: Add project to wishlist and add least price product to cart
Given I add four different products to my wishlist
When I view my wishlist table
Then Find total four selected items in my wishlist
When i search for lowest price product
And I am able to add lowest price project to my cart
Then I am able to verify in my cart