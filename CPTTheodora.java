import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTTheodora{
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);
		
		boolean blnstartup = true;
		boolean blnplay = false;
		boolean blnleaderboard = false;
		boolean blnAddQuiz = false;
		char chrStartup;
		
		con.setBackgroundColor(new Color(242, 166, 111));
		 		
		while(blnstartup == true){
			chrStartup = con.getChar();
			//switch to get char
			switch(chrStartup){
				case 'p':
					blnplay = true;
					break;
				case 'l':
					blnleaderboard = true;
					break;
				case 'a':
					blnAddQuiz = true;
					break;
				case 'q':
					blnstartup = false;
					break;
				default:
					con.println("inavlid");
			}		
 			if(blnplay == true){
				String strQzName[];
				int intQzCount = 0;
				con.println("name?");
				String strName = con.readLine();
				con.println("quiz");
				//select quiz from quizes.txt
				TextInputFile qz = new TextInputFile ("quizes.txt");
				while(qz.eof()==false){
					qz.readLine();
					intQzCount ++;
				}
				qz.close();
				//System.out.println(intQzCount);
				TextInputFile qzRead = new TextInputFile ("quizes.txt");
				strQzName = new String[intQzCount];
				for(int intQzRead = 0 ; intQzRead <= intQzCount-1; intQzRead ++){
					strQzName[intQzRead] = qzRead.readLine();
					con.println(intQzRead+" "+ strQzName[intQzRead]);
				}
				qzRead.close();
				char chrChooseMode = con.getChar();
				int intMode = Character.getNumericValue((chrChooseMode));

				System.out.println(intMode+1 +" "+ strQzName[intMode]);	
				String strQuiz = strQzName[intMode];
				strQuiz+=".txt";
				con.println(strQuiz);
				System.out.println(strQuiz+"...loading");
				TextInputFile quiz = new TextInputFile (strQuiz);
				int intScore = 0;
				int intcount = 0; 
				int intQcount = 0;
				while(!quiz.eof()){
					String strread  = quiz.readLine();
					intcount++;
				}
				intcount = intcount/4;
				System.out.println("There are " +intcount+" questions");
				quiz.close();
				TextInputFile dply = new TextInputFile (strQuiz);
				String[][] strQnA = new String[intcount][5];
				for( int i = 0; i < intcount; i ++){
					strQnA[i][0] = dply.readLine();
					//System.out.println(QnA[i][0]);
					strQnA[i][1] = dply.readLine();
					//System.out.println(QnA[i][1]);
					strQnA[i][2] = dply.readLine();
					//System.out.println(QnA[i][2]);
					strQnA[i][3] = dply.readLine();
					//System.out.println(QnA[i][3]);
					int intRand = (int)(Math.random()*100+1);
					strQnA[i][4] = String.valueOf((intRand));
					//System.out.println(QnA[i][4]);
				}	
				for(int sort = 0; sort < intcount-1; sort ++){
					for(int intQgen = 0; intQgen < intcount-1; intQgen++){
						if(Integer.parseInt(strQnA[intQgen][4]) > Integer.parseInt(strQnA[intQgen+1][4])){
							String[] strTemp = strQnA[intQgen];
							strQnA[intQgen] = strQnA[intQgen +1];
							strQnA[intQgen +1] = strTemp;
						}
					}
				}			
				
				for (int intPrint = 0; intPrint < intcount; intPrint ++){
					con.println(strQnA[intPrint][0]);
					String strUserIn = con.readLine();
					intQcount ++;
					for(int intAns = 1; intAns < 3; intAns ++){
						//System.out.println(QnA[print][ans]);
						if(strQnA[intPrint][intAns].equalsIgnoreCase(strUserIn)){
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
