import arc.*;
import java.awt.Color;


public class functions{

	public static String[][] LeaderboardPrint(Console con){
		//leaderboard sort
		int intcount = 0;	
		TextInputFile ldb = new TextInputFile("leaderboard.txt");
		while(ldb.eof() == false){
			String read  = ldb.readLine();
			intcount++;
			//System.out.println("leaderboard count =" +intcount);
		}
		ldb.close();
			
		int intLeaderBoardCount = intcount/3;
				
		TextInputFile lead = new TextInputFile("leaderboard.txt");
			
		String[][] LeaderBoard = new String[intcount/3][3];
		
		for(int intLBCount = 0; intLBCount < intLeaderBoardCount; intLBCount ++){
			LeaderBoard[intLBCount][0]=lead.readLine();
			LeaderBoard[intLBCount][1]=lead.readLine();
			LeaderBoard[intLBCount][2]=lead.readLine();
		}	
			String strNameTemp;
			String strQuizTemp;
			String strScoreTemp;
			for(int ii = 0; ii < intLeaderBoardCount-1; ii ++){
				for(int i = 0; i < intLeaderBoardCount-1; i ++){
					if(Double.parseDouble(LeaderBoard[i][2])<Double.parseDouble(LeaderBoard[i+1][2])){
						String[] temp = new String[intLeaderBoardCount];
						temp = LeaderBoard[i];
						LeaderBoard[i] = LeaderBoard[i+1];
						LeaderBoard[i+1] = temp;
					}	
				}
			}
			return LeaderBoard;
	}	
	public static void drawWrappedText(Console con, String text, int x, int y, int maxWidth, int lineHeight, int charWidth) {
		String[] words = text.split(" ");
		String line = "";
		int yOffset = 0;

		for (int i = 0; i < words.length; i++) {
			String testLine = line + words[i] + " ";
			int lineLengthInPixels = testLine.length() * charWidth;

			if (lineLengthInPixels > maxWidth) {
				con.drawString(line, x, y + yOffset);
				yOffset += lineHeight;
				line = words[i] + " ";
			} else {
				line = testLine;
			}
		}

		if (!line.equals("")) {
			con.drawString(line, x, y + yOffset);
		}
	}

}				
