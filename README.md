Black - Jack
The black jack file holds 7 different classes that allow you to play the classic game of black jack. 
The main class is the Game class that contains all the logic. The game starts by creating the player
and the dealer and dealing out two cards a piece. From there the logic determines if either player has 
a total value of 21. If not the game continues and allows the player to either double down, hit or stay.
If the player decides to double down the bet is doubled and the logic continues onto the Dealers hit. 
If the player decides to hit the logic continues onto the next deal method and will continue to add 
cards to the players hand as long as they do not bust and continue to hit. Finally if the player desides to 
stay the Dealer hit method is called. The dealer method first checks to if the dealer is less than or equal to
16, if so they hit, if not they are forced to stay. After the dealer is done, the checkCard method is called
and it determines if the dealer or player wins, or if it is a push. 
