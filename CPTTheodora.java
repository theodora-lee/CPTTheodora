import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.text.DecimalFormat; 

public class CPTTheodora{
	public static void main(String[] args){
		Console con = new Console("Math Training Game", 1280, 720);
		DecimalFormat df = new DecimalFormat("0.0");
		
		boolean blnstartup = true;
		boolean blnplay = false;
		boolean blnleaderboard = false;
		boolean blnAddQuiz = false;
		char chrStartup;
		
		 		
		while(blnstartup == true){
			con.clear();
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
			con.drawString("Play (P)", 550, 265);
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(325,375,610,100);
			con.setDrawColor(Color.BLACK);
			con.fillRect(330,380,620,105);	
			con.setDrawColor(new Color(67, 67, 89));
			con.fillRect(330,380,610,95);
			con.setDrawFont(fntSub);
			con.setDrawColor(Color.WHITE);
			con.drawString("Leaderboard (L)", 490, 395);	
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(325,500,610,100);
			con.setDrawColor(Color.BLACK);
			con.fillRect(330,505,620,105);
			con.setDrawColor(new Color(67, 67, 89));
			con.fillRect(330,505,605,95);
			con.setDrawFont(fntSub);
			con.setDrawColor(Color.WHITE);
			con.drawString("Add Quiz (A)", 505, 520);	
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
				con.setDrawFont(fntSub);
				con.clear();
				con.setBackgroundColor(new Color(250, 171, 102));	
				String strQzName[];
				int intQzCount = 0;
				con.setDrawColor(Color.WHITE);
				con.drawString("Name?", 250, 100);
				int intX = 250;
				int intY = 300;
				int intCharWidth = 20; 
				int intMaxLength = 0;
				String strName = "";
				char chrTyped = 0;

				while (chrTyped != 10) {
					chrTyped = con.getChar();

					if (chrTyped == 8 && strName.length() > 0) { 
						strName = strName.substring(0, strName.length() - 1);
					} else if (chrTyped >= 32 && chrTyped <= 126) { 
						strName += chrTyped;
					}

					if (strName.length() > intMaxLength) {
						intMaxLength = strName.length();
					}

					con.setDrawColor(new Color(250, 171, 102));
					con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 

					con.setDrawColor(Color.WHITE);
					con.drawString(strName , intX, intY);
					con.repaint();
				}

				System.out.println(strName);
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
					}
				}
				
				System.out.println(intMode+1 +" "+ strQzName[intMode]);	
				String strQuiz = strQzName[intMode];
				strQuiz+=".txt";
				con.setBackgroundColor(new Color(250, 171, 102));	

				con.setDrawColor(Color.WHITE);
				con.drawString((strQuiz+"...loading"),250, 250);
				con.sleep(500);
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
					con.setDrawColor(Color.WHITE);
					con.drawString((intScore+ "/" +intQcount), 800, 0);
					con.drawString((df.format(dblPrecentage)+"%"), 900, 0); 
					
					intX = 250;
					intY = 300;
					String strUserIn = "";
					chrTyped = 0;

					while (chrTyped != 10) {
						chrTyped = con.getChar();

						if (chrTyped == 8 && strUserIn.length() > 0) { 
							strUserIn = strUserIn.substring(0, strUserIn.length() - 1);
						} else if (chrTyped >= 32 && chrTyped <= 126) { 
							strUserIn += chrTyped;
						}

						if (strUserIn.length() > intMaxLength) {
							intMaxLength = strUserIn.length();
						}

						con.setDrawColor(new Color(250, 171, 102));
						con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 

						con.setDrawColor(Color.WHITE);
						con.drawString(strUserIn, intX, intY);
						con.repaint();
					}

					con.clear();			
					System.out.println(strUserIn);		
					intQcount ++;
					for(int intAns = 1; intAns < 3; intAns ++){
						//System.out.println(QnA[print][ans]);

						if(strQnA[intPrint][intAns].equalsIgnoreCase(strUserIn.trim())){
							intScore ++;
							con.setBackgroundColor(new Color(100, 250, 120));	
							con.setDrawColor(Color.WHITE);
							con.drawString("correct", 250, 250);
							con.sleep(500);
							con.repaint();
							break;
						}else{
							con.setBackgroundColor(new Color(250, 100, 120));	
							con.setDrawColor(Color.WHITE);
							con.drawString("wrong", 250, 250);
							con.drawString((strQnA[intPrint][1]+"/"+strQnA[intPrint][2]+"/"+strQnA[intPrint][3]), 100,300);

							con.sleep(500);	
							System.out.println(strQnA[intPrint][1]+"/"+strQnA[intPrint][2]+"/"+strQnA[intPrint][3]);
							con.repaint();
							break;
						}
						
					}
					dblPrecentage = 100.0* intScore/intQcount; 

				}	
				con.setBackgroundColor(new Color(250, 171, 102));	
				con.setDrawColor(Color.WHITE);
				con.setDrawFont(fntTitle);
				con.drawString((intScore+ "/" +intQcount), 300, 250);
				con.drawString((df.format(dblPrecentage)+"%"), 700, 250); 
				System.out.println((intScore+ "/" +intQcount + "	"+df.format(dblPrecentage)+"%")); 
				con.repaint();
				con.setDrawFont(fntSub);
				dply.close();

				

				TextOutputFile score = new TextOutputFile("leaderboard.txt",true);
				score.println(strName);
				score.println(strQuiz); 
				score.println(dblPrecentage);
				score.close();
				int intExit = con.getKey();
				while(intExit != 27){
					intExit = con.getKey();
					if(intExit == 27){
						blnleaderboard = false;
					}	
				}	 
			
			}
			if(blnleaderboard == true){
				con.clear();
				con.setBackgroundColor(new Color(127, 83, 166));
				String[][] leaderboard = functions.LeaderboardPrint(con);
				int y = 25;
				for(int i = 0; i < leaderboard.length; i++){
					String name = leaderboard[i][0];
					String quiz = leaderboard[i][1];
					String score = String.format("%.1f", Double.parseDouble(leaderboard[i][2]));
					con.setDrawColor(Color.WHITE);
					System.out.println(name + "    " + quiz + "    " + score);
					con.drawString((name + "    " + quiz + "    " + score), 50, y);
					y += 50;
					con.repaint();
				}	
				int intExit = con.getKey();
				while(intExit != 27){
					intExit = con.getKey();
					if(intExit == 27){
						blnleaderboard = false;
					}	
				}	
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
					con.clear();
					blnAddQuiz = false;
				}	
				
			}	
			
		}	
		
		con.closeWindow();
	
	}		
}		
