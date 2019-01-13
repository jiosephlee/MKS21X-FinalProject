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
			for (int i = 0; i < str.length(); ++i) {
				screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
			}
		}
		public static void main(String[] args) throws IOException {
			int x = 10;
			int y = 10;
			Grid game = new Grid();
			Screen screen = new DefaultTerminalFactory().createScreen();
			screen.startScreen();
			long tStart = System.currentTimeMillis();
			long lastSecond = 0;
			while (true) {
				TextCharacter chr = new TextCharacter(
					'\u263B',
					new TextColor.RGB((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random())),
					TextColor.ANSI.DEFAULT
				);
				screen.setCharacter(x, y, chr);

				KeyStroke key = screen.pollInput();

				//String storage = game.toString();
				String storage = game.toString();
				//String storage = "|                | +\n + |      |";
				int xcor = 3;
				int ycor = 5;
				boolean yes = true;
				for (int i = 0; i < storage.length(); i++){
								xcor++;
								if (storage.charAt(i) == '|' && yes){
									TextCharacter put = new TextCharacter(
										' ',
										new TextColor.RGB(50, 50, 50),
										new TextColor.RGB(50,50,50)
									);
									yes = false;
									screen.setCharacter(xcor, ycor, put);
								} else if (storage.charAt(i) == 234234){
									TextCharacter put = new TextCharacter(
										' ',
										new TextColor.RGB(0, 0, 0),
										new TextColor.RGB(0, 0, 0)
									);
									screen.setCharacter(xcor, ycor, put);
								}
								if (storage.charAt(i)=='\n'){
									TextCharacter put = new TextCharacter(
										' ',
										new TextColor.RGB(50, 50, 50),
										new TextColor.RGB(50,50,50)
									);
									yes = false;
									screen.setCharacter(xcor, ycor, put);
									ycor++;
									xcor = 3;
									yes = true;
								}
				}
			if (key != null) {
				screen.setCharacter(x, y, new TextCharacter(' '));

				if      (key.getKeyType() == KeyType.Escape)     break;
				else if (key.getKeyType() == KeyType.ArrowLeft)  x--;
				else if (key.getKeyType() == KeyType.ArrowRight) x++;
				else if (key.getKeyType() == KeyType.ArrowUp)    y--;
				else if (key.getKeyType() == KeyType.ArrowDown)  y++;
				putString(1, 1, screen, key+"                 ");
			}

			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}
}
