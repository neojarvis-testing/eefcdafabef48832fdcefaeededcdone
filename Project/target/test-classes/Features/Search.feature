Feature: Testing ELC Website Functionality

  Scenario: Search for a product
    Given I am on ELC Website
    When I input the text "Peppa pig" into the search box
    And I click on the first option from the auto-populated list
    Then I confirm that the search results page contains the label "Peppa pig"

  Scenario: Filter products by price range
    Given I am on ELC Homepage
    When I hover the mouse over the "Shop by age" menu and click the "0-3 months" category
    And I scroll down until I locate the "Price" option on the left side of the page
    And I click the value "£15 - £29.99" from the price range options
    Then I verify the total number of results found based on the selected price range

  Scenario: Filter products by brand in "Offers" > "Wooden Toys"
  Given I am on ELC Application for click
  When I click on the "Offers" menu
  And I scroll down until I reach the "Brands" filter
  And I click on the "Show more" link
  And I click the checkbox of "Paw patrol"
  Then I verify whether the name of the chosen brand is available on the page
