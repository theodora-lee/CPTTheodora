 import arc.*;

public class CPTTheodora{
	public static void main(String[] args){
		Console con = new Console();
		
		//actual gameplay
		int intx1;
		int intx2;
		int intOpSign;
		int intAns;
		intx1 = (int)(Math.random()*10+1);
		//con.println(intx1);
		intx2 = (int)(Math.random()*10+1);
		//con.println(intx2);
		intOpSign = (int)(Math.random()*4+1);
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
				
			
	}
}		
