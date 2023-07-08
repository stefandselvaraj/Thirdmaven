Feature: Validate the Search Hotel Page

  Scenario Outline: Verify Adactin Search Hotelpage for valid data
    Given User select all the fields in search hotel page "<Location>", "<Hotels>",  "<RoomType>", "<NumberofRooms>", "<CheckInDate>", "<CheckOutDate>", "<AdultsPerRoom>", "<childrenPerRoom>"
    Then User should verify the message after search hotel "Search Hotel"
    And User Clicks submit

    Examples: 
      | Location | Hotels        | RoomType     | NumberofRooms | CheckInDate | CheckOutDate | AdultsPerRoom | childrenPerRoom |
      | Paris    | Hotel Cornice | Super Deluxe |             5 | 05/07/2023  | 06/07/2023   |             1 |               1 |
      
      
      
