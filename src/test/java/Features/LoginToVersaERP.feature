Feature: Login to Versa Cloud ERP
  Scenario: Versa cloud ERP end to end workflow

      Given User is on Versa Cloud ERP login page
      And user wait for 2 sec
      When User enter valid username as "testuser"
      And user wait for 2 sec
      And User enter valid password as "32Bv56SV7F"
      And user wait for 2 sec
      And User click on loginButton
      And user wait for 2 sec
      Then sales menu should be visible
      And user wait for 2 sec

      When User clicks on Sales menu
      And user wait for 2 sec
      And User clicks on New Sales order
      And user wait for 2 sec
      And User selects customer name as "Oscar Probiel (Kitchener, ON)"
      And user wait for 2 sec
      When User clicks on assign order number button
      And user wait for 2 sec
      Then order should be created successfully
      And user wait for 2 sec

      When User enters product or service name as "ZD01-21200N / SWITCH PT CONV"
      And user wait for 2 sec
      And User enters unit price as "20"
      And user wait for 2 sec
      And User clicks on create button
      And user wait for 2 sec
      And User clicks on Ship order button
      And user wait for 2 sec
      And User clicks on ship All available items
      And user wait for 2 sec
      And User clicks on post shipment button
      And user wait for 2 sec
      And User clicks on alert pop up message
      And user wait for 2 sec
      And User enters shipment tracking no as "12321"
      And user wait for 2 sec
      And Again User clicks on post shipment button
      And user wait for 2 sec
      Then Shipment successful message should be visible
      And user wait for 2 sec

