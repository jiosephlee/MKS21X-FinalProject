import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.awt.Color;

/*  Mr. K's TerminalDemo edited for lanterna 3 by Ethan
*/

public class TerminalDemo {

	public static void putString(int x, int y, Screen screen, String str) {
		for (int i = 0; i < str.length(); ++i) {
			screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
		}
	}

	public static void main(String[] args) throws IOException {

		int x = 10;
		int y = 10;
		//Grid game = new Grid();

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

			/*String storage = game.toString();
			String storage = "|                | +\n + |      |";
			int xcor = 1;
			int ycor = 5;
			for (int i = 0; i < storage.length(); i++){
							if (storage.charAt(i) == '|'){
								TextCharacter put = new TextCharacter(
									' ',
									new TextColor.RGB(50, 50, 50),
									new TextColor.RGB(50,50,50)
								);
								screen.setCharacter(xcor, ycor, put);
							} else if (storage.charAt(i) == ' '){
								TextCharacter put = new TextCharacter(
									' ',
									new TextColor.RGB(0, 0, 0),
									new TextColor.RGB(0, 0, 0)
								);
								screen.setCharacter(xcor, ycor, put);
							}
							xcor++;
							if (storage.charAt(i)=='\n'){
								ycor++;
							}
			}*/
			if (key != null) {
				screen.setCharacter(x, y, new TextCharacter(' '));

				if      (key.getKeyType() == KeyType.Escape)     break;
				else if (key.getKeyType() == KeyType.ArrowLeft)  x--;
				else if (key.getKeyType() == KeyType.ArrowRight) x++;
				else if (key.getKeyType() == KeyType.ArrowUp)    y--;
				else if (key.getKeyType() == KeyType.ArrowDown)  y++;

				putString(1, 1, screen, key+"                 ");
			}
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1, 2, screen, "Milliseconds since start of program: "+millis);
			if (millis / 1000 > lastSecond) {
				lastSecond = millis / 1000;
				putString(1, 3, screen, "Seconds since start of program: "+millis/1000);
			}
			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}
}
