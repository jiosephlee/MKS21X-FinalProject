# MKS21X-FinalProject
Final Project: Tetris
## Instructions:

Hi! Welcome to Tetris.

Our project is based on the game of Tetris

The game is played in the same manner of the original. Try to stack tetriminoes in a manner to complete and clear a level. The more levels you clear, the higher your score! But be warned. The higher your score, the tougher the game will get!

The controls are:

- Down: lower piece by 1 space
- Left/Right : Move piece to the Left/Right
- Up : Rotate Clockwise

- Z/X: Rotate Clockwise / Rotate CounterClockwise
- C: Store piece in holding
- Space: HardDrop piece
- Esc: Leave game

Note: if you move a piece using down, left, right, or up such that the piece will go off the screen, the game will let you! If this happens, move away from the screen and try the move again.

## DevLogs:
### 1/3/19
- Made the classes Grid, Tetrimino, and Piece, and started the skeleton (Joseph)
- Made a rudimentary toString for Grid, and is only showing the playing area, not the hold and the next. Made a temp toString for Piece just so the toString for Piece works. (George)
### 1/4/19
- Realized that our toString for Grid was not in the right “format” in order to include the hold and the next, so we had to rewrite it s.t. We used arrays instead of strings with \n’s. (George)
- We edited our UML diagram a bit to add some necessary params for Grid.
### 1/5/19
- Worked on toString for Grid for a tiny bit by finishing up the hold and the next string arrays. (George)
### 1/6/19
- Officially made toString for Grid and merged the branch toStringFirst and master. Waiting for Tetrimino and Piece. (George)
- Finished working on Pieces.java and figured out how Pieces will fit into Tetrimino (Joseph)
### 1/7/19
- In class, worked on translating Tetriminos and Pieces (George)
- In class, fixed the few methods of Tetriminos and Pieces (Joseph)
- At home, worked on rotating Tetriminos by using freshman Euclidean Geometry (George)
- At home, started figuring out the graphics using Laterna (Joseph)
### 1/8/19
- In class, we started figuring out how to make the blocks. We realized we needed to change how our classes worked and their constructors.
- At home, I made new constructors and methods with different kinds of inputs depending on the class using it. I also made all the classes for all the 7 different kinds of Tetriminos in Tetris. Today was productive dabdab (George)
<img src="https://media.giphy.com/media/A4R8sdUG7G9TG/giphy.gif" width="768" height="400" />

### 1/9/19
- I tested the toString and other methods and they now work! (George)
- At home, I figured out how the Demo and graphics works for Lanterna 3 and started modifying the code to our project (Joseph)
- At home, I added a bunch of easy misc. functions in Grid to help prepare for tomorrow's intensive work of trying to move a tetrimino :( (George)
### 1/10/19
- I started doing the actual functions of Grid such as moving the blocks and rotating them, but however, I realized my constructors for the blocks were wrong. I also finished testing the other methods (George)
### 1/12/19
- I started adjusting Tetris.java for our project and figured out how to integrate the game objects from the grid onto the terminal (Joseph)
- I changed constructors for the blocks which accepts a character that enables colors for the dropping tetrimino. (George)
### 1/13/19
- I added mechanics in Grid.java which enables the Driver, which is the Tetris file, which allows the Driver to access its elements, move the dropping tetrimino down, rotate it, move left, stacking the tetriminos, and adding tetriminos. (George)
- I integrated Tetris mechanics into Graphics and got a working game but the levels don't clear yet (Joseph)
### 1/14/19
- I added two features. One of which removes rows whenever you have an entire row full of nonempty pieces. The second of which basically doubles the block size which makes it easier for the user to read the tetriminos. (George)
- Integrated more features like double wide pixel and clearing levels (Joseph)
<img src="https://media.giphy.com/media/GhUkXNflFxJ0A/giphy.gif" width="768" height="400" />

### 1/15/19
- I added only one function, which is to see whether you have failed the game or not. The rest of the time was used to testing whether every function works and so far it seems like it. (George)
- Started working on the queueing feature and block loading (Joseph)

### 1/16/19
- Created branches which helped me test whether my code worked or not (George)
- Found a bug and debugged for many times but I wasn't able to find it (Joseph)

### 1/17/19
- Added a function which allows you to hardDrop the current tetrimino. This pushes the tetrimino all the way to the bottom, and automatically selects the next tetrimino. (George)
- Worked on queuing and holding and looked into debugging again(Joseph)

### 1/18/19
- Added a new branch in which Tetris.java is being edited to allow the player to have a home screen before you actually play.
- Coded the algorithm to randomly choose pieces for what comes next (Joseph)

### 1/19/19
- I spent most of my time retabbing/formatting the Tetris.java file to become readable. I also started making a HomeScreen branch which I set up the while and booleans needed to create a homescreen to start the game after pressing a certain button, which is the space. (George)

### 1/20/19
- I finished adding some textgraphics in the home screen so now it looks super cool and it says "Welcome to // Tetris //Press space to begin". I also had trouble merging, but that's okay now. Hopefully we're at the stage where we can (George)
- I also FIXED MORE TABBING OH MY GOD (George)
- I finished the toString by allowing it take in multiple different shapes for the Hold and the Next section. I also added a score and a level section in the toString (George)
- Finished the end game features and integrated replayability into the graphics. Fixed a bunch of bugs and visaul errors and fixed some of the new graphics that was merged. Added/fixed a bunch of small features such as a highscore and framerate to make the game playing experience much better (Joseph)

### 1/21/19
- I made a feature which enables the Grid to have a Ghost Block which shows where the dropping Tetrimino would go if you to hard drop the tetrimino. (George)
- I fixed an error where the center of rotation of the IBlock is incorrect. (George)
- Fixed alot of bugs and errors today such as the glitchiness of the game and the holding feature. Added a bunch of features such as the game getting hard over time and score showing and allowing the player to move the piece around a bit after it landed. Modified a bunch of little things to increase the gaming experience (Joseph)
