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
		
		 		
		while(blnstartup == true){
			//UX interface
			con.setBackgroundColor(new Color(67, 67, 89));

			Font fntTitle = con.loadFont("ProfontwindowsBold-Eaq14.ttf", 90);
			con.setDrawFont(fntTitle);
			con.setDrawColor(new Color(255,255,255));
			con.drawString("Math Trainng Game", 250, 100);	
			
			Font fntSub = con.loadFont("ProfontwindowsBold-Eaq14.ttf", 45);
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(325,245,610,100);
			con.setDrawColor(Color.BLACK);
			con.fillRect(330,250,620,105);
			con.setDrawColor(new Color(250, 171, 102));			
			con.fillRect(330,250,610,95);
			con.setDrawFont(fntSub);
			con.setDrawColor(Color.WHITE);
			con.drawString("Play", 575, 265);
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(325,375,610,100);
			con.setDrawColor(Color.BLACK);
			con.fillRect(330,380,620,105);	
			con.setDrawColor(new Color(67, 67, 89));
			con.fillRect(330,380,610,95);
			con.setDrawFont(fntSub);
			con.setDrawColor(Color.WHITE);
			con.drawString("Leaderboard", 525, 395);	
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(325,500,610,100);
			con.setDrawColor(Color.BLACK);
			con.fillRect(330,505,620,105);
			con.setDrawColor(new Color(67, 67, 89));
			con.fillRect(330,505,605,95);
			con.setDrawFont(fntSub);
			con.setDrawColor(Color.WHITE);
			con.drawString("Add Quiz", 550, 520);	
			con.repaint();
			
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
					continue;
			}		
			
 			if(blnplay == true){
				con.clear();
				con.setBackgroundColor(new Color(250, 171, 102));	
				String strQzName[];
				int intQzCount = 0;
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
				con.clear();
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
				con.setBackgroundColor(new Color(250, 171, 102));	
				con.setDrawColor(Color.WHITE);
				con.drawString("Quiz Selection", 250, 100);
				for(int intQzRead = 0 ; intQzRead <= intQzCount-1; intQzRead ++){
					strQzName[intQzRead] = qzRead.readLine();
					con.setDrawColor(Color.WHITE);
					con.drawString(intQzRead+" "+ strQzName[intQzRead], 0,(150 +50*intQzRead));
					con.repaint();
				}
				qzRead.close();
				int intMode = -1;
				while(intMode == -1){
					char chrChooseMode = con.getChar();
					intMode = Character.getNumericValue((chrChooseMode));
					if(intMode > intQzCount -1){
						intMode = -1;
						con.drawString("invalid", 400, 600);
					}
				}
				System.out.println(intMode+1 +" "+ strQzName[intMode]);	
				String strQuiz = strQzName[intMode];
				strQuiz+=".txt";
				con.drawString((strQuiz+"...loading"),640, 450);
				TextInputFile quiz = new TextInputFile (strQuiz);
				int intScore = 0;
				int intcount = 0; 
				int intQcount = 0;
				double dblPrecentage = 0; 
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
					con.clear();
					con.setBackgroundColor(new Color(250, 171, 102));	
					con.setDrawColor(Color.WHITE);
					con.drawString(strQnA[intPrint][0], 50, 100);
					String strUserIn = con.readLine();
					intQcount ++;
					for(int intAns = 1; intAns < 3; intAns ++){
						//System.out.println(QnA[print][ans]);
						if(strQnA[intPrint][intAns].equalsIgnoreCase(strUserIn)){
							intScore ++;
						}	
					}
					dblPrecentage = intScore/intQcount; 
					con.setDrawColor(Color.WHITE);
					con.drawString((intScore+ "/" +intQcount + "	"+dblPrecentage), 1250, 0); 
				}	
				System.out.println(dblPrecentage);
				dply.close();
				
				TextOutputFile score = new TextOutputFile("leaderboard.txt",true);
				score.println(strName);
				score.println(strQuiz);
				score.println(dblPrecentage);
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
					con.println("more?(0 for No, 1 for yes)");
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
