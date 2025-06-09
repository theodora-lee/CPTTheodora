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
		boolean blnSecret = false;
		boolean blnHelp = false;
		char chrStartup;
		
		 		
		while(blnstartup == true){
			con.clear();
			//UX interface
			con.setBackgroundColor(new Color(67, 67, 89));

			Font fntTitle = con.loadFont("ProfontwindowsBold-Eaq14.ttf", 90);
			con.setDrawFont(fntTitle);
			con.setDrawColor(new Color(255,255,255));
			con.drawString("Math Trainng Game", 250, 100);	
			Font fntSmall = con.loadFont("ProfontwindowsBold-Eaq14.ttf",35);

			
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
				case 'h':
					blnHelp = true;
					break;
				case 's':
					blnSecret = true;
					break;
				default:
					continue;
			}		
			
			if(blnHelp == true){
				boolean blnTutorial = true;
				int intPage = 1;
				int intTotal = 10;
				con.setDrawColor(Color.WHITE);
				con.drawString("help page", 0, 0);
				con.repaint();
				while(blnTutorial == true){				
					int intKey = con.getKey();
					con.setDrawColor(Color.WHITE);
					con.drawString("page"+intPage, 250, 250);
				}	
			}	
			
			if(blnSecret == true){
				con.setBackgroundColor(new Color(102, 168, 250));
				con.setDrawColor(Color.WHITE);
				con.setDrawFont(fntTitle);
				con.drawString("2 3 5 7 ", 500, 250);
				con.setDrawFont(fntSub);
				con.drawString("Prime suspect", 500, 400);
				con.sleep (750);
				blnSecret = false;
				
			}
			
 			if(blnplay == true){
				//play ui design
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
					//if char != [bs]
					chrTyped = con.getChar();

					if (chrTyped == 8 && strName.length() > 0) { 
						strName = strName.substring(0, strName.length() - 1);
						//if its not a letter, dont count it
					} else if (chrTyped >= 32 && chrTyped <= 126) { 
						//controls the typed characters are letters
						strName += chrTyped;
					}

					if (strName.length() > intMaxLength) {
						intMaxLength = strName.length();
					}

					con.setDrawColor(new Color(250, 171, 102));
					con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 
					//draw over the deleted letters

					con.setDrawColor(Color.WHITE);
					con.drawString(strName , intX, intY);
					con.repaint();
				}

				//System.out.println(strName);
				con.clear();
				//select quiz from quizes.txt
				TextInputFile qz = new TextInputFile ("quizes.txt");
				//read quiz length
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
				//reads and assigns numbers to quiz
				for(int intQzRead = 0 ; intQzRead <= intQzCount-1; intQzRead ++){
					strQzName[intQzRead] = qzRead.readLine();
					con.setDrawColor(Color.WHITE);
					con.drawString(intQzRead+" "+ strQzName[intQzRead], 0,(150 +50*intQzRead));
					con.repaint();
				}
				qzRead.close();
				//quiz selection
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
				
				
				//actual quiz reading
				TextInputFile quiz = new TextInputFile (strQuiz);
				int intScore = 0;
				int intcount = 0; 
				int intQcount = 0;
				double dblPrecentage = 0; 
				
				while(!quiz.eof()){
					String strread  = quiz.readLine();
					intcount++;
				}
				//takes only the question
				intcount = intcount/4;
				System.out.println("There are " +intcount+" questions");
				quiz.close();
				TextInputFile dply = new TextInputFile (strQuiz);
				String[][] strQnA = new String[intcount][5];
				
				//reads to array
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
					strQnA[i][4] = intRand + "";
					//System.out.println(QnA[i][4]);
				}	
				//bubble sort
				for(int sort = 0; sort < intcount-1; sort ++){
					for(int intQgen = 0; intQgen < intcount-1; intQgen++){
						if(Integer.parseInt(strQnA[intQgen][4]) > Integer.parseInt(strQnA[intQgen+1][4])){
							String[] strTemp = strQnA[intQgen];
							strQnA[intQgen] = strQnA[intQgen +1];
							strQnA[intQgen +1] = strTemp;
						}
					}
				}			
				
				//gameplay ui
				for (int intPrint = 0; intPrint < intcount; intPrint ++){
					con.clear();
					boolean blnCorrect = false; 
					con.setBackgroundColor(new Color(250, 171, 102));	
					con.setDrawColor(Color.WHITE);
					con.setDrawFont(fntSub);
					functions.drawWrappedText(con, strQnA[intPrint][0], 50, 100, 800, 50, 20);
					con.setDrawFont(fntSmall);
					con.drawString((strName +"-"+ strQuiz), 0, 0);
					con.drawString((intScore+ "/" +intQcount), 900, 0);
					con.drawString((df.format(dblPrecentage)+"%"), 1100, 0); 
					con.repaint();
					if(strName.equalsIgnoreCase("jpxfrd")){
						con.setDrawColor(Color.WHITE);
						con.setDrawFont(fntSmall);
						con.drawString(strQnA[intPrint][1]+"/"+strQnA[intPrint][2]+"/"+strQnA[intPrint][3],0,650);
						con.repaint();
					}	
					
					intX = 250;
					intY = 300;
					String strUserIn = "";
					chrTyped = 0;
					con.setDrawFont(fntSub);
					//takes user input
					while (chrTyped != 10) {
						chrTyped = con.getChar();

						if (chrTyped == 8 && strUserIn.length() > 0) { 
							strUserIn = strUserIn.substring(0, strUserIn.length() - 1);
							//inavlid buttons are not counted
						} else if (chrTyped >= 32 && chrTyped <= 126) { 
							strUserIn += chrTyped;
							//controlled domain of typed characters and numbers
						}

						if (strUserIn.length() > intMaxLength) {
							intMaxLength = strUserIn.length();
						}

						con.setDrawColor(new Color(250, 171, 102));
						con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 
						//paints over deleted area

						con.setDrawColor(Color.WHITE);
						con.drawString(strUserIn, intX, intY); 
						con.repaint();
					}

					con.clear();			
					intQcount ++;
					for(int intAns = 1; intAns <= 3; intAns ++){
						System.out.println("User Input: [" + strUserIn.trim() + "] compared to Answer: [" + strQnA[intPrint][intAns].trim() + "]");
						//compares answers
						if(strQnA[intPrint][intAns].trim().equalsIgnoreCase(strUserIn.trim())){
							System.out.println(strQnA[intPrint][intAns]);
							blnCorrect = true; 
						}	
					}	
					if (blnCorrect == true){	
						intScore ++;
						con.setBackgroundColor(new Color(100, 250, 120));	
						con.setDrawColor(Color.WHITE);
						con.setDrawFont(fntTitle);
						con.drawString("correct", 250, 250);
						con.sleep(500);
						con.repaint();
						
					}else{
						con.setBackgroundColor(new Color(250, 100, 120));	
						con.setDrawColor(Color.WHITE);
						con.setDrawFont(fntTitle);
						con.drawString("wrong", 250, 250);
						con.setDrawFont(fntSub);
						con.drawString((strQnA[intPrint][1]+"/"+strQnA[intPrint][2]+"/"+strQnA[intPrint][3]), 100,500);
						con.sleep(500);	
						//System.out.println(strQnA[intPrint][1]+"/"+strQnA[intPrint][2]+"/"+strQnA[intPrint][3]);
						con.repaint();
							
					}
						
					
					dblPrecentage = 100.0* intScore/intQcount; 

				}	
				//final score screen

				con.setBackgroundColor(new Color(250, 171, 102));	
				con.setDrawColor(Color.WHITE);
				con.setDrawFont(fntTitle);
				con.drawString((intScore+ "/" +intQcount), 300, 250);
				con.drawString((df.format(dblPrecentage)+"%"), 700, 250); 
				System.out.println((intScore+ "/" +intQcount + "	"+df.format(dblPrecentage)+"%")); 
				con.repaint();
				con.setDrawFont(fntSub);
				con.drawString((strName +"-"+ strQuiz), 0, 0);
				con.drawString(("Press Esc to exit"), 900, 0);

				dply.close();

				
				//print to leaderboard
				TextOutputFile score = new TextOutputFile("leaderboard.txt",true);
				score.println(strName);
				score.println(strQuiz); 
				score.println(dblPrecentage);
				score.close();
				//press esc to exit
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
				//reads the leaderboard and saves into a 2d array
				String[][] leaderboard = functions.LeaderboardPrint(con);
				int intTotal = (int)Math.ceil((double)leaderboard.length/9);
				System.out.println(intTotal);
				
				int intPage = 0;
				boolean blnView = true;
				
				while (blnView == true){
					con.clear();
					con.setBackgroundColor(new Color(127,83, 166));
					con.setDrawColor(Color.WHITE);
					//headers
					con.drawString("Name", 205, 50);
					con.drawString("Quiz", 550, 50)	;				
					con.drawString(("Score"), 900, 50);
					con.setDrawFont(fntSmall);
					con.drawString(("Esc to exit"), 0, 0);

					
					
					//prints out the leaderboard
					int intStart = intPage *  9;
					int intEnd = Math.min(intStart + 9, leaderboard.length);
					int intY = 0;
					
					for(int i = intStart; i < intEnd; i++){

						String strName = leaderboard[i][0];
						String strQuiz = leaderboard[i][1];
						String strScore = String.format("%.1f", Double.parseDouble(leaderboard[i][2]));
						
						//offshitfs y int with each print
						con.drawString(strName, 200, 100+ intY);
						con.drawString(strQuiz, 550, 100+ intY)	;				
						con.drawString(strScore, 900, 100+ intY);
						intY+= 50;
						con.repaint();
					}	
					con.drawString("Page " + (intPage + 1) + "/" + intTotal, 500, 600);

					con.repaint();
					
					int intKey = con.getKey();
					
					if(intKey == 27){
						//esc key to leave page
						blnView = false;
						blnleaderboard = false;
					}else if(intKey == 38 && intPage > 0){
						// ^ arrow to go up
						intPage--;
					}else if(intKey == 40 && intPage < intTotal - 1){
						// v arrow to go down
						intPage ++;
					}		
				}
	
			}		
			if(blnAddQuiz == true){
				//UI Design
				con.setBackgroundColor(Color.WHITE);
				con.setDrawColor(Color.BLACK);
				con.drawString("What is your quiz name?", 200, 100);
				// character read (same code as strName read in blnPlay)
				int intX = 250;
				int intY = 300;
				int intCharWidth = 20; 
				int intMaxLength = 0;
				String strQuizName = "";
				char chrTyped = 0;

				while (chrTyped != 10) {
					//if char != [bs]
					chrTyped = con.getChar();

					if (chrTyped == 8 && strQuizName.length() > 0) { 
						strQuizName = strQuizName.substring(0, strQuizName.length() - 1);
						//if its not a letter, dont count it
					} else if (chrTyped >= 32 && chrTyped <= 126) { 
						//controls the typed characters are letters
						strQuizName += chrTyped;
					}

					if (strQuizName.length() > intMaxLength) {
						intMaxLength = strQuizName.length();
					}

					con.setDrawColor(Color.WHITE);
					con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 
					//draw over the deleted letters

					con.setDrawColor(Color.BLACK);
					con.drawString(strQuizName , intX, intY);
					con.repaint();
				}

				TextOutputFile write = new TextOutputFile("quizes.txt", true);
				write.println(strQuizName);
				write.close();
				TextOutputFile add = new TextOutputFile(strQuizName+".txt");
				
				int intAddNew = 10;
				while (intAddNew == 10){
					con.setBackgroundColor(Color.WHITE);
					con.setDrawColor(Color.BLACK);					
					con.drawString("Question:", 200, 100);
					intX = 250;
					intY = 300;
					intCharWidth = 20; 
					intMaxLength = 0;
					String strQuestion = "";
					chrTyped = 0;

					while (chrTyped != 10) {
						//if char != [bs]
						chrTyped = con.getChar();
						if (chrTyped == 8 && strQuestion.length() > 0) { 
							strQuestion = strQuestion.substring(0, strQuestion.length() - 1);
							//if its not a letter, dont count it
						} else if (chrTyped >= 32 && chrTyped <= 126) { 
							//controls the typed characters are letters
							strQuestion += chrTyped;
						}
						if (strQuestion.length() > intMaxLength) {
							intMaxLength = strQuestion.length();
						}

						con.setDrawColor(Color.WHITE);
						con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 
						//draw over the deleted letters
						con.setDrawColor(Color.BLACK);
						//combining the next line code and the draw user input code together ... ish
						functions.drawWrappedText(con, strQuestion , intX, intY, 800, 50, 20);
						con.repaint();
					}
					add.println(strQuestion);
				
					
					con.setBackgroundColor(Color.WHITE);

					for(int i = 1; i <= 3; i++){
						con.setBackgroundColor(Color.WHITE);
						con.setDrawColor(Color.BLACK);					
						con.drawString("Answer "+i, 200, 100);
						intX = 250;
						intY = 300;
						intCharWidth = 20; 
						intMaxLength = 0;
						String strAnswer = "";
						chrTyped = 0;

						while (chrTyped != 10) {
							//if char != [bs]
							chrTyped = con.getChar();
							if (chrTyped == 8 && strAnswer.length() > 0) { 
								strAnswer = strAnswer.substring(0, strAnswer.length() - 1);
								//if its not a letter, dont count it
							} else if (chrTyped >= 32 && chrTyped <= 126) { 
								//controls the typed characters are letters
								strAnswer += chrTyped;
							}
							if (strAnswer.length() > intMaxLength) {
								intMaxLength = strAnswer.length();
							}

							con.setDrawColor(Color.WHITE);
							con.fillRect(intX, intY + 20, (intMaxLength + 1) * intCharWidth, 50); 
							//draw over the deleted letters
							con.setDrawColor(Color.BLACK);
							functions.drawWrappedText(con, strAnswer , intX, intY, 800, 50, 20);
							con.repaint();
						}
						add.println(strAnswer);
					}	
					con.setBackgroundColor(Color.WHITE);
					con.setDrawColor(Color.BLACK);	
					con.drawString("Enter for more questions.", 200, 250);
					intAddNew = con.getKey();
				}	
				if(intAddNew != 10){
					con.clear();
					blnAddQuiz = false;
				}	
				
			}	
			
		}	
		
		con.closeWindow();
	
	}		
}		
