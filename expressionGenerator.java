import arc.*;

public class expressionGenerator{
	public static void Qgen(Console con, TextOutputFile eqn){
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
		String strQuestion = "";
		String[] answers = new String[3];
		
		switch(intOpSign){
			case 1:
				intAns = intx1 + intx2;
				eqn.println(intx1+ " + "+intx2);
				con.println(intx1+ " + "+intx2);
				break;
			case 2:
				intAns = intx1 - intx2;
				eqn.println(intx1+ " - "+intx2);
				con.println(intx1+ " - "+intx2);
				break;	
			case 3:
				intAns = intx1 * intx2;
				eqn.println(intx1+ " * "+intx2);
				con.println(intx1+ " * "+intx2);
				break;
			case 4:	
				intAns = intx1 / intx2;
				eqn.println(intx1+ " / "+intx2);
				con.println(intx1+ " / "+intx2);
				break;
			default:
				break;
			}	
			
			// Generate the three answer formats
			answers[0] = String.valueOf(intAns);
			answers[1] = convertToWords(intAns);
			answers[2] = describeSign(intAns);

			// Output to console and file
			con.print(strQuestion);
			eqn.print(strQuestion);
			for (String ans : answers) {
				con.println(ans);
				eqn.println(ans);
			}
		}
		
		// Convert integers to words (limited scope)
		public static String convertToWords(int num) {
			switch (num) {
				case -10: return "negative ten";
				case -9: return "negative nine";
				case -8: return "negative eight";
				case -7: return "negative seven";
				case -6: return "negative six";
				case -5: return "negative five";
				case -4: return "negative four";
				case -3: return "negative three";
				case -2: return "negative two";
				case -1: return "negative one";
				case 0: return "zero";
				case 1: return "one";
				case 2: return "two";
				case 3: return "three";
				case 4: return "four";
				case 5: return "five";
				case 6: return "six";
				case 7: return "seven";
				case 8: return "eight";
				case 9: return "nine";
				case 10: return "ten";
				default: return Integer.toString(num);
			}
		}

		// Describe the sign
		public static String describeSign(int num) {
			if (num > 0) {
				return "positive " + convertToWords(num);
			} else if (num < 0) {
				return "negative " + convertToWords(Math.abs(num));
			} else {
				return "zero";
			}
		}
	}	
	
