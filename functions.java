import arc.*;

public class functions{
	public static int Equations(){
		Console con = new Console();
		TextOutputFile eqn = new TextOutputFile ("expressions.txt", false);
		int intOpSign;
		int intAns = 1;
		int setup;
		int intx1 = (int)(Math.random()*10+1);
		//con.println(intx1);
		int intx2 = (int)(Math.random()*10+1);
		//con.println(intx2);
		//to ensure that the answer rn is only whole numbers
		if(intx1 % intx2 == 0){
			setup = 4;
		}else{
			setup = 3;
		}		
		intOpSign = (int)(Math.random()*setup+1);
		switch(intOpSign){
			case 1:
				intAns = intx1 + intx2;
				eqn.println(intx1+ " + "+intx2);
				break;
			case 2:
				intAns = intx1 - intx2;
				eqn.println(intx1+ " - "+intx2);
				break;	
			case 3:
				intAns = intx1 * intx2;
				eqn.println(intx1+ " * "+intx2);
				break;
			case 4:	
				intAns = intx1 / intx2;
				eqn.println(intx1+ " / "+intx2);
				break;
			default:
				break;
			}	
		return intAns;	
	}	
	public static int HighScore(int Score){
		TextOutputFile score = new TextOutputFile("ScoreRecord.txt",true);
		score.println(Score);
		score.close();
		
		TextInputFile read = new TextInputFile("ScoreRecord.txt");
		int i = 1;
		int i2 = 1;
		
		while(read.eof() == false){
			i2 = read.readInt();
			//con.println(i2);
			if(i < i2){
				i = i2;
			}
		}
		read.close();
		return i;
	}	
}			
