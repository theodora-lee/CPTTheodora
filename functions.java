import arc.*;

public class functions{

	public static void LeaderboardPrint(Console con){
		int intcount = 0;	
		TextInputFile ldb = new TextInputFile("leaderboard.txt");
		while(ldb.eof() == false){
			String read  = ldb.readLine();
			intcount++;
			System.out.println("leaderboard count =" +intcount);
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
					if(Integer.parseInt(LeaderBoard[i][2])<Integer.parseInt(LeaderBoard[i+1][2])){
						String[] temp = new String[intLeaderBoardCount];
						temp = LeaderBoard[i];
						LeaderBoard[i] = LeaderBoard[i+1];
						LeaderBoard[i+1] = temp;
					}	
				}
			}
			for(int i = 0; i <intLeaderBoardCount; i ++){
				con.println(LeaderBoard[i][0]+"	"+LeaderBoard[i][1]+"	"+LeaderBoard[i][2]);
			}	
	}	

}				
