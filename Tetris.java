import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.awt.Color;
/*  Mr. K's TerminalDemo edited for lanterna 3 by Ethan
*/
	public class Tetris {
		public static void putString(int x, int y, Screen screen, String str) {
			int xcor = x;
			for (int i = 0; i < str.length(); ++i) {
				if(str.charAt(i)=='\n'){
					y++;
					xcor = x;
				}else{
				xcor++;
				screen.setCharacter(xcor, y, new TextCharacter(str.charAt(i)));
				}
			}
		}
		public static void main(String[] args) throws IOException {
			int x = 1;
			int y = 1;
			Grid game = new Grid();
	        game.setDrop(new IBlock(5, 4));
			game.setNext(new IBlock(5, 4));
			System.out.println(game);
			Screen screen = new DefaultTerminalFactory().createScreen();
			screen.startScreen();

			long tStart = System.currentTimeMillis();
			long lastSecond = 0;
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			long time2 = System.currentTimeMillis();
			long time1 = System.currentTimeMillis();
			long diff = time2 - time1;
			long lasts = 0;
			while (true) {
			time2 = System.currentTimeMillis();
			diff = time2 - time1;
			if (diff / 50 > lasts) {
				lasts = diff / 50;

				screen.clear();
				String storage = game.toString();
				int xcor = 3;
				int ycor = 5;
				for (int i = 0; i < storage.length(); i++){
					xcor++;
					if (storage.charAt(i) =='\t'){
						xcor+=3;
					}
					if(storage.charAt(i) == '.' || storage.charAt(i) == '_'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(255, 255, 255),
						new TextColor.RGB(255, 255, 255));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '1'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(102,205,170),
						new TextColor.RGB(102,205,170));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '2'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(0,0,255),
						new TextColor.RGB(0,0,255));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '3'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(255,165,0),
						new TextColor.RGB(255,165,0));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '4'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(255,255,0),
						new TextColor.RGB(255,255,0));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '5'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(50,205,50),
						new TextColor.RGB(50,205,50));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '6'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(238,130,238),
						new TextColor.RGB(238,130,238));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == '7'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(255,0,0),
						new TextColor.RGB(255,0,0));
						screen.setCharacter(xcor, ycor, put);
						}
					if (storage.charAt(i)=='\n'){
						ycor++;
						xcor = 3;
					}
				}
				KeyStroke key = screen.pollInput();

			if (key != null) {

				if      (key.getKeyType() == KeyType.Escape) break;
				else if (key.getKeyType() == KeyType.Backspace) x++;
				else if (key.getKeyType() == KeyType.Character){
					if (key.getCharacter() == ' ') game.moveDown(1);
				}
				else if (key.getKeyType() == KeyType.Character){
					if (key.getCharacter() == 'c') setHold();
					game.setDrop();
					game.setNext(new IBlock(5, 4));
				}
				else if (key.getKeyType() == KeyType.ArrowLeft) game.moveLeft(1);//game.moveLeft();
				else if (key.getKeyType() == KeyType.ArrowRight) game.moveRight(1);//game.moveRight();
				else if (key.getKeyType() == KeyType.ArrowUp) game.rotateCW();
				else if (key.getKeyType() == KeyType.ArrowDown)  game.rotateCCW();
			}
			if (game.isDoneDropping()){
				game.setInStone();
				game.setDrop();
				game.setNext(new IBlock(5, 4));
			}
			tEnd = System.currentTimeMillis();
			millis = tEnd - tStart;
			if (millis / 1000 > lastSecond) {
				lastSecond = millis / 1000;
				game.moveDown(1);
			}
			screen.doResizeIfNecessary();
			screen.refresh();
		}
	}
		screen.stopScreen();
	}
}
