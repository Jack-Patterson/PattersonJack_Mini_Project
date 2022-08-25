# Java Mini-Project - Draughts

This project was created using *Java*. In the first semester of second year we were assigned a project to make something using Java. We has the option ourselves whether it would be a game, a business system or something else entirely, but it must be made using Java, must include GUI, must use OOP as well as a few more requirements. I opted to make draughts as I wished to challenge myself with what I knew of Java. We also used Javadocs to document our project. We only had to document one class so it is incomplete.

*Note: 100% of this is not made by me as I was stuck on some elements of it but those are clearly documented within the code.*

## Project Structure
### GUI
The *GUI* as the name suggests handles everything to do with the GUI of the game, from handling the board to moving the pieces the *GUI* handles it with the assistance of mouse events. This is the primary thing I needed assistance on due to my inexperience with *GUI*. This class also handles the IO of the save and load system for loading a game from memory.

### Point
The most simple part of the project. It is a simple object which stores an x,y position of each point. Each *Piece* object has a point as a part of it.

### Piece
*Piece* is an object which extends the *Point* class. Each piece stores vital information such as its colour, whether it is a king, if it's been captures and whether it has a valid move on the board. This object also handles checking if there is a valid move on the board through a static method and also handles removing itself from the board if it is captured. Finally it also holds a reference to a static *ArrayList* of all pieces of each colour on the board.

### Player
*Player* is an object which contains information about each player as is implied. It stores the players name, their colour, whether it's their turn and a unique player ID.

### Validator
*Validator* handles validation of all the information from the above classes and tries to ensure no errors occur.

### Documentation
The documentation for the project is provided via Javadocs. However only one class is fully documented due to the requirements only making us do one. The class i chose to document is *Piece* due to it being sufficiently complex but not as long as something like the *GUI* class.