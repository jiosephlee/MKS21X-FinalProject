import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;
import java.awt.Color;
/*  Mr. K's TerminalDemo edited for lanterna 3 by Ethan
*/
public class Tetris {
	public static void putString(int x, int y, Screen screen, String str) {
		int xcor = x;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\n') {
				y++;
				xcor = x;
			} else {
				xcor++;
				screen.setCharacter(xcor, y, new TextCharacter(str.charAt(i)));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		boolean isEnter = false;
		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
		int x = 1;
		int y = 1;
		Grid game = new Grid(); //set up grid
		game.playGame(true);

		int wait = 0;

		long tStart = System.currentTimeMillis(); //time tracking variables
		long lastSecond = 0;
		long tEnd = System.currentTimeMillis();
		long millis = tEnd - tStart;
		long time2 = System.currentTimeMillis();
		long time1 = System.currentTimeMillis();
		long diff = time2 - time1;
		long lasts = 0;

		putString(1, 1, screen,"____    __    ____  _______  __        ______   ______   .___  ___.  _______    .___________.  ______   ");
		putString(1, 2, screen, "\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|   |           | /  __  \\  ");
		putString(1, 3, screen, " \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__      `---|  |----`|  |  |  | ");
		putString(1, 4, screen, "  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|         |  |     |  |  |  | ");
		putString(1, 5, screen, "   \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____        |  |     |  `--'  | ");
		putString(1, 6, screen, "    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|       |__|      \\______/  ");
		putString(1, 8, screen, "                  .___________. _______ .___________..______       __       _______.                    ");
		putString(1, 9, screen, "                  |           ||   ____||           ||   _  \\     |  |     /       |                    ");
		putString(1, 10, screen, "                  `---|  |----`|  |__   `---|  |----`|  |_)  |    |  |    |   (----`                    ");
		putString(1, 11, screen, "                      |  |     |   __|      |  |     |      /     |  |     \\   \\                        ");
		putString(1, 12, screen, "                      |  |     |  |____     |  |     |  |\\  \\----.|  | .----)   |                       ");
		putString(1, 13, screen, "                      |__|     |_______|    |__|     | _| `._____||__| |_______/                        ");
		//this ascii art is creditted from http://patorjk.com/software/taag/#p=display&f=Star%20Wars&t=Welcome%20to%0A%20%20%20%20%20%20%20Tetris
		putString(42, 15, screen, "Press space to begin");
		screen.doResizeIfNecessary();
		screen.refresh();

		while (!isEnter) {
			KeyStroke key = screen.pollInput();
			if (key != null) {
				if (key.getKeyType() == KeyType.Escape) {
					break;
				}
				if (key.getKeyType() == KeyType.Character) {
					if (key.getCharacter() == ' ') {
						isEnter = true;
					}
				}
			}
		}

		screen.clear();

		while (true) {
			time2 = System.currentTimeMillis();
			diff = time2 - time1;

			if (!game.getPlay()) { //if game ended put this screen on until they want to play again
				putString(10, 10, screen, "To play again, please press Enter");
				putString(10, 15, screen, "Current Highscore: " + game.highscore);

				KeyStroke keyone = screen.pollInput();

				if (keyone != null) {
					if (keyone.getKeyType() == KeyType.Escape) {
						break;
					}
					if (keyone.getKeyType() == KeyType.Enter) {
						game.playGame(true);
					}
				}
				screen.doResizeIfNecessary();
				screen.refresh();

			} else if (diff / 20 > lasts) {
				lasts = diff / 20;
				screen.clear();
				String storage = game.toString();
				int xcor = 3;
				int ycor = 5;
				for (int i = 0; i < storage.length(); i++) { //set up the game graphics
					xcor++;
					if (storage.charAt(i) == '\t') {
						xcor += 3;
					}
					if (storage.charAt(i) == '.' || storage.charAt(i) == '_') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(255, 255, 255),
							new TextColor.RGB(255, 255, 255)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '1') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(102, 205, 170),
							new TextColor.RGB(102, 205, 170)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '2') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(0, 0, 255),
							new TextColor.RGB(0, 0, 255)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '3') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(255, 165, 0),
							new TextColor.RGB(255, 165, 0)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '4') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(255, 255, 0),
							new TextColor.RGB(255, 255, 0)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '5') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(50, 205, 50),
							new TextColor.RGB(50, 205, 50)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '6') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(238,130,238),
							new TextColor.RGB(238,130,238)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '7') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(255, 0, 0),
							new TextColor.RGB(255, 0, 0)
						);
						screen.setCharacter(xcor, ycor, put);
					} else if (storage.charAt(i) == '8') {
						TextCharacter put = new TextCharacter (
							' ',
							new TextColor.RGB(105,105,105),
							new TextColor.RGB(105,105,105)
						);
						screen.setCharacter(xcor, ycor, put);
					}
					if (storage.charAt(i) == '\n') {
						ycor++;
						xcor = 3;
					}
				}

				KeyStroke key = screen.pollInput();
				if (key != null) { //check for user input

					if (key.getKeyType() == KeyType.Escape) {
						break;
					} else if (key.getKeyType() == KeyType.Character) {
						if (key.getCharacter() == ' ') game.hardDrop();
						else if (key.getCharacter() == 'c' && !game.getHeld()) {
							game.setHold();
							game.setDrop();
							game.setNext();
						} else if (key.getCharacter() == 'z'){
							game.rotateCW();
						} else if (key.getCharacter() == 'x'){
							game.rotateCCW();
						}
					} else if (key.getKeyType() == KeyType.ArrowLeft) {
						game.moveLeft(1);
					} else if (key.getKeyType() == KeyType.ArrowRight) {
						game.moveRight(1);
					} else if (key.getKeyType() == KeyType.ArrowUp) {
						game.rotateCW();
					} else if (key.getKeyType() == KeyType.ArrowDown) {
						game.moveDown(1);
					}
				}

				if (game.isDoneDropping()) {//if dropped reached the bottom, set it in stone and set up the next piece
					if (wait > 10){
						game.setInStone();
						game.setDrop();
						game.setNext();
						game.setHeld(false);
						wait = 0;
					} else {
						wait++;
					}
				}
				tEnd = System.currentTimeMillis(); //move down the current moving piece every second
				millis = tEnd - tStart;
				if (millis / (1000 - game.level * 20)> lastSecond) {
					lastSecond = millis / (1000 - game.level * 20);
					game.moveDown(1);
				}

				int[] cleared = game.checkTetris(); //clear levels that need to be cleared
				if (cleared.length > 0) {
					game.removeTetris(cleared);
				}
				if (game.checkFailure()) { //check if the game ended
					game = new Grid(game.highscore);
					screen.clear();
				}
				screen.doResizeIfNecessary();
				screen.refresh();
	 		}
		}
		screen.stopScreen();
	}
}
