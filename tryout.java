import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class tryout{
	public static void main(String[] args){
		Console con = new Console();
		
		int confettiCount = 50;
        int[] x = new int[confettiCount];
        int[] y = new int[confettiCount];
        Color[] colors = new Color[confettiCount];
        boolean blnConfetti = true;

        // Initialize confetti with random positions and colors
        for (int i = 0; i < confettiCount; i++) {
            x[i] = (int)(Math.random() * 1000);
            y[i] = (int)(Math.random() * -720); // Start above screen
            colors[i] = new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)
            );
        }

        while (blnConfetti) {
            con.clear();

            for (int i = 0; i < confettiCount; i++) {
                con.setDrawColor(colors[i]);
                con.fillRect(x[i], y[i], 5, 5); // Confetti size 5x5
                y[i] += (int)(Math.random()*2); // Fall speed

                // Reset when it reaches bottom
                if (y[i] > 720) {
                    x[i] = (int)(Math.random() * 1000);
                    y[i] = (int)(Math.random() * -50);
                    colors[i] = new Color(
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256)
                    );
                }
            }
		}
	}
}		
