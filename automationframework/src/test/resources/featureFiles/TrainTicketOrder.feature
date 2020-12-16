Feature: Product Train
  
Scenario: Create transaction with non-instant payment for one-way trip, xx adults and xx infants and select seats
    Given User go to tiket website
    And Choose Kereta api menu
    And Select departure
    And Select destination
    And Select date
    And Add Dewasa passanger <dewasa>
		And Add Bayi passanger <bayi>
		When User Click Cari Kereta Api
		Then User Can see list of kereta api that available
    When User Filter Kereta Api Eksekutif
    Then User Can see only Ekonomi list of kereta api
    When User Choose kereta api  
    Then Fill Detail Pemesanan "<email>" and "<nama>" and "<ktp>" and "<phone>"
    And User Pilih kursi 
    When User click lanjutkan pembayaran 
   	Then Payment page show 
   	When User select payment transfer bank bca
   	Then Order Created 
      
    Examples:
    | email            			| nama 						| ktp				|	phone				|dewasa	|bayi		|
    | rahasia@gmail.com     |test automation  |12345678|0812213222|2			|2			|