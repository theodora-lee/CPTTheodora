import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class tryout{
	public static void main(String[] args){
		Console con = new Console();
		TextOutputFile eqn = new TextOutputFile("basics.txt", false); 
		for( int i = 0; i < 50; i ++){
			expressionGenerator.Qgen(con, eqn);

		}
	}
}		
