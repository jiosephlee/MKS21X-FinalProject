# MKS21X-FinalProject
Final Project: Tetris

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
