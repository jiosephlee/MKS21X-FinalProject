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
			System.out.println(game);
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

				String storage = game.toString();

				int xcor = 3;
				int ycor = 5;
				for (int i = 0; i < storage.length() - 1; i++){
					xcor++;
					if (storage.charAt(i) =='\t'){
						xcor+=3;
					}
					/*if (((storage.charAt(i) == '|' || storage.charAt(i) == '-') && yes) ||
						storage.charAt(i) == '[' ||
						(((linecount > 7 && linecount < 17) || (linecount > 19 && linecount < 29)) && ((storage.charAt(i+12) == '\n') ||
						(storage.charAt(i+9) == '\n'))))*/
				 	if(storage.charAt(i) == '.' || storage.charAt(i) == '_'){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(255, 255, 255),
						new TextColor.RGB(255, 255, 255));
						screen.setCharacter(xcor, ycor, put);
						}
					else if (storage.charAt(i) == 234234){
						TextCharacter put = new TextCharacter(
						' ',
						new TextColor.RGB(0, 0, 0),
						new TextColor.RGB(0, 0, 0));
						screen.setCharacter(xcor, ycor, put);
						}
						if (storage.charAt(i)=='\n'){
							ycor++;
							xcor = 3;
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
