Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    And User checks lastDiv visibility
    And User checks cart visibility
    And User checks register button visibility
    And User checks sign in button visibility
    When User opens today deals
    And User checks Title fields visibility
    Then User checks that language downPage switcher is '<language>'


    Examples:
      | homePage                            | language   |
      | https://www.amazon.com/             | English    |


  Scenario Outline: Check change the language
    Given User opens '<homePage>' page
    And User checks lastDiv visibility
    Then User checks that language downPage switcher is '<language_1>'
    And User clicks 'Language D'
    And User chooses '<language_2>'
    And User clicks 'Save changes'
    Then User checks that language switcher is '<lang>' in url

    Examples:
      | homePage                | language_2 | lang           | language_1  |
      | https://www.amazon.com/ | Deutsch    | language=de    | English     |


  Scenario Outline: Check variable search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks input variable visibility customer reviews

    Examples:
      | homePage                            | keyword     |
      | https://www.amazon.com/             | iphone11    |


  Scenario Outline: Check customer service
    Given User opens '<homePage>' page
    And User opens customer service
    And User checks title customer service fields visibility
    When User makes search help by keyword '<keyword>'
    Then User checks that has link

    Examples:
      | homePage                            | keyword             |
      | https://www.amazon.com/             | can not to login    |


  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User opens search result
    And User clicks first product on list
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart popup visible
    And User checks 'Cart' button visibility
    Then User checks that add to cart popup header is '<header>'

    Examples:
      | homePage                            | keyword  | header                                |
      | https://www.amazon.com/             | pet gate | Proceed to checkout (1 item)          |


  Scenario Outline: Check choose deliver to which country
    Given User opens '<homePage>' page
    And User clicks 'Deliver To' link
    And User clicks 'Country choice' menu
    And User chooses '<delivery>' country
    Then User checks that 'Deliver To' contains '<delivery>'

    Examples:
      | homePage                | delivery  |
      | https://www.amazon.com/ | Turkey    |



  Scenario Outline: Check choice variable search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks input variable visibility customer reviews
    And User checks input variable brand
    And User checks input variable price
    And User checks input variable shelf height
    And User checks input variable shelf depth
    And User checks input variable shelf width
    And User checks input variable furniture Material
    When User clicks input variable price


    Examples:
      | homePage                            | keyword     |
      | https://www.amazon.com/             | bookshelf   |


  Scenario Outline: Check can to create the account
    Given User opens '<homePage>' page
    And User clicks 'Sign In' button
    And User clicks 'create your amazon account' button
    Then User checks 'Name field' visibility
    And User enters '<name field>' in 'Name field'
    Then User checks 'email field' visibility
    And User enters '<email field>' in 'Email field'
    And User enters '<password>' in 'Password field'
    And User enters '<password>' in 'Re-enter'
    And User clicks 'Create your Amazon account'
    Then User checks that captcha visibility

    Examples:
      | homePage                | name field  | email field              | password      |
      | https://www.amazon.com/ | Petro       | petroabramkov@gmail.com  | petropetro    |



  Scenario Outline: Check can to create the account with incorrect email
    Given User opens '<homePage>' page
    And User clicks 'Sign In' button
    And User clicks 'create your amazon account' button
    Then User checks 'Name field' visibility
    Then User checks 'email field' visibility
    And User enters '<name field>' in 'Name field'
    And User enters '<email field>' in 'Email field'
    And User enters '<password>' in 'Password field'
    And User enters '<password>' in 'Re-enter'
    And User clicks 'Create your Amazon account'
    Then User checks that answer visibility

    Examples:
      | homePage                | name field  | email field              | password      |
      | https://www.amazon.com/ | Vasya       | Vasya                    | VasyaVasya    |




  Scenario Outline: Check add product to cart and sign up
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User opens search result
    And User clicks first product on list
    And User clicks 'Add to Cart' button on product
    And User clicks cart icon
    And User clicks sign up in system
    Then User checks 'Name field' visibility
    And User enters '<name field>' in 'Name field'
    Then User checks 'email field' visibility
    And User enters '<email field>' in 'Email field'
    And User enters '<password>' in 'Password field'
    And User enters '<password>' in 'Re-enter'
    And User clicks 'Create your Amazon account'
    Then User checks that captcha visibility


    Examples:
      | homePage                  | keyword  | name field  | email field              | password      |
      | https://www.amazon.com/   | laptop   | Petro       | petroabramkov@gmail.com  | petropetro    |


  Scenario Outline: Check another page
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User clicks 'Sell products on Amazon' button
    Then User checks that current url contains '<keyword>'


    Examples:
      | homePage                  | keyword   |
      | https://www.amazon.com/   | sell      |