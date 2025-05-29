 import arc.*;

public class CPTTheodora{
	public static void main(String[] args){
		Console con = new Console();
		
		boolean blnstartup = true;
		boolean blnplay = false;
		boolean blnleaderboard = false;
		boolean blnAddQuiz = false;
		String Startup = "";
		 		
		while(blnstartup == true){
			Startup = con.readLine();
			switch(Startup){
				case "play":
					blnplay = true;
					break;
				case "leaderboard":
					blnleaderboard = true;
					break;
				case "add":
					blnAddQuiz = true;
					break;
				case "quit":
					blnstartup = false;
					break;
				default:
					con.println("inavlid");
			}		
 			if(blnplay == true){
				con.println("name?");
				String strName = con.readLine();
				con.println("quiz");
				String strQuiz = con.readLine();
				strQuiz+=".txt";
				con.println(strQuiz);
				System.out.println(strQuiz+"...loading");
				TextInputFile quiz = new TextInputFile (strQuiz);
				int intScore = 0;
				int intcount = 0; 
				int intQcount = 0;
				while(!quiz.eof()){
					String read  = quiz.readLine();
					intcount++;
				}
				intcount = intcount/4;
				System.out.println("There are " +intcount+" questions");
				quiz.close();
				TextInputFile dply = new TextInputFile (strQuiz);
				String[][] QnA = new String[intcount][5];
				for( int i = 0; i < intcount; i ++){
					QnA[i][0] = dply.readLine();
					//System.out.println(QnA[i][0]);
					QnA[i][1] = dply.readLine();
					//System.out.println(QnA[i][1]);
					QnA[i][2] = dply.readLine();
					//System.out.println(QnA[i][2]);
					QnA[i][3] = dply.readLine();
					//System.out.println(QnA[i][3]);
					int intRand = (int)(Math.random()*100+1);
					QnA[i][4] = String.valueOf((intRand));
					//System.out.println(QnA[i][4]);
				}	
				for(int sort = 0; sort < intcount-1; sort ++){
					for(int Qgen = 0; Qgen < intcount-1; Qgen++){
						if(Integer.parseInt(QnA[Qgen][4]) > Integer.parseInt(QnA[Qgen+1][4])){
							String[] temp = QnA[Qgen];
							QnA[Qgen] = QnA[Qgen +1];
							QnA[Qgen +1] = temp;
						}
					}
				}			
				
				for (int print = 0; print < intcount; print ++){
					con.println(QnA[print][0]);
					String userIn = con.readLine();
					intQcount ++;
					for(int ans = 1; ans < 3; ans ++){
						//System.out.println(QnA[print][ans]);
						if(QnA[print][ans].equalsIgnoreCase(userIn)){
							intScore ++;
						}	
					}
					con.println(intScore+ "/" +intQcount); 
				}	
				System.out.println(intScore);
				dply.close();
				
				TextOutputFile score = new TextOutputFile("leaderboard.txt",true);
				score.println(strName);
				score.println(strQuiz);
				score.println(intScore);
				score.close();
				blnplay = false; 
			
			}
			if(blnleaderboard == true){
				functions.LeaderboardPrint(con);	
				blnleaderboard = false;
			}		
			if(blnAddQuiz == true){
				con.println("What is your quiz name?");
				String strQuizName = con.readLine();
				TextOutputFile write = new TextOutputFile("quizes.txt", true);
				write.println(strQuizName);
				strQuizName = strQuizName + ".txt";
				write.close();
				TextOutputFile add = new TextOutputFile(strQuizName);
				int intAddNew = 1;
				while (intAddNew == 1){
					con.println("Question:");
					String Question= con.readLine();
					add.println(Question);
					for(int i = 1; i <= 3; i++){
						con.println("Answer "+i);
						String strAnswer = con.readLine();
						add.println(strAnswer);
					}	
					con.println("more?");
					intAddNew = con.readInt();
				}	
				if(intAddNew ==0){
					blnAddQuiz = false;
				}	
				
			}	
			
		}	
		
		con.closeWindow();
	
	}		
}		
