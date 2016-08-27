/**
Given an integer, convert it to a roman numeral.
 Input is guaranteed to be within the range from 1 to 3999.
@author Cradle Lee
@method to replace Arabic numbers from left to right
 */

package integerToRoman;

public class I2R{
	static String[][] roman = {{"","M","MM","MMM"},
								{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
								{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
								{"","I","II","III","IV","V","VI","VII","VIII","IX"}};



		

		public static String convert(String number){
			//complete the number
			int n = 4 - number.length();
			for(int i=0;i<n;i++){
				number = "0"+number;
			}

			String ans="";
			int i;
			for(i=0;i<=3;i++){
				ans= ans + roman[i][number.codePointAt(i)-'0'];
			}
			return ans;
		}
		
}
