Feature: Verify the Home Loan calculator page functionality

  Background: 
    Given Launch the Home Loan Calculator Application

  Scenario: 
    When Loan calculator application loaded successfully
    Then Enter the application form details
      | ApplicationType    | Single          |
      | Dependants         |               0 |
      | PuyingProperty     | Home to live in |
      | AnnualIncome       |           80000 |
      | OtherIncome        |           10000 |
      | LivingExpense      |             500 |
      | HomeLoanRepayment  |               0 |
      | OtherLoanRepayment |             100 |
      | OtherCommitments   |               0 |
      | CreditCardLimit    |           10000 |
    Then Click 'Work out how much I could borrow' button
    Then Verify the estimated amount is "$479,000"

  Scenario: Verify Start over behaviour
    When Loan calculator application loaded successfully
    Then Enter the application form details
      | ApplicationType    | Single          |
      | Dependants         |               0 |
      | PuyingProperty     | Home to live in |
      | AnnualIncome       |           80000 |
      | OtherIncome        |           10000 |
      | LivingExpense      |             500 |
      | HomeLoanRepayment  |               0 |
      | OtherLoanRepayment |             100 |
      | OtherCommitments   |               0 |
      | CreditCardLimit    |           10000 |
    Then Click 'Start Over' button to reset the form
    Then Verify form values are reset

  Scenario: Verify calculator response for setting only living expenses
    When Loan calculator application loaded successfully
    Then Enter living expense '1'
    Then Click 'Work out how much I could borrow' button
    Then Verify application displays the message as "Based on the details you\'ve entered, we\'re unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641."
