import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class tryout{
	public static void main(String[] args){
		Console con = new Console();
		
		while(true){
			int a = con.getKey();
			con.println(a);
		}	
	}
}		
