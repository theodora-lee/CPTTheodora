import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class tryout{
	public static void main(String[] args){
		Console con = new Console(1280, 720);
		con.setDrawColor(Color.WHITE);
		con.drawString("Name?", 250, 100);
		char chrTyped = 0;
		String strName = "";
		while(chrTyped != 10){
			chrTyped = con.getChar();
			strName += chrTyped;
			con.drawString(strName, 250, 300);
			con.repaint();
		}
		con.println(strName);	
		


	}
}		
