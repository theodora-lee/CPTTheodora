import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class tryout{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		Font fntTest = con.loadFont("ProfontwindowsBold-Eaq14.ttf", 40);
		con.setDrawFont(fntTest);
		con.setDrawColor(new Color(200,30,30));
		con.drawString("Math Trainng Game", 0, 0);		



	}
}		
