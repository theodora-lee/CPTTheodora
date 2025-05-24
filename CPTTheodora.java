 import arc.*;

public class CPTTheodora{
	public static void main(String[] args){
		Console con = new Console();
		

	}
	
	/*	public static int Score(int intScore){
			TextOutputFile score = new TextOutputFile("ScoreRecord.txt",true);
			score.println(intScore);
			TextInputFile read = new TextInputFile("ScoreRecord.txt");
			int i = 1;
			int i2 = 1;
			while(read.eof() == false){
				i2 = read.readInt();
				if(i < i2){
					i2 = i;
				}
			}	
			return i2;
	}*/	
	
	public static int Math(int intMin, int intMax){	
		Console con = new Console();
		//actual gameplay
		int intOpSign;
		int intAns = 1;
		int setup;
		int intx1 = (int)(Math.random()*intMax+intMin);
		//con.println(intx1);
		int intx2 = (int)(Math.random()*intMax+intMin);
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
				con.println(intx1+ " + "+intx2);
				break;
			case 2:
				intAns = intx1 - intx2;
				con.println(intx1+ " - "+intx2);
				break;	
			case 3:
				intAns = intx1 * intx2;
				con.println(intx1+ " * "+intx2);
				break;
			case 4:	
				intAns = intx1 / intx2;
				con.println(intx1+ " / "+intx2);
				break;
			default:
				break;
		}		
		
		return intAns;		
	}
}		
