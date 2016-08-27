/**
Given an Roman numeral, convert it to a Arabic number.
 Input is guaranteed to be within the range from 1 to 3999.
@author Cradle Lee
@method to replace Roman numbers with Arabic numbers from right to left
 */
package integerToRoman;

public class R2I {
	//Arabic numbers are just to fulfill this table;
	static String[][] roman = {{"M","MM","MMM","4","5","6","7","8","9"},
							{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
							{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
							{"I","II","III","IV","V","VI","VII","VIII","IX"}};
				
	
	static public String convert(String romanNum){
		String ans="";
		String temp = romanNum;
		for(int i=3;i>=0;i--){
			boolean flag=false;
			for(int j=8;j>=0;j--){
				if(temp.endsWith(roman[i][j])){
					ans=String.valueOf(j+1)+ans;
					flag = true;
					temp = temp.replace(roman[i][j],"");
				}
				
			}
			if(flag==false)
				ans = ans+"0";
		}
		
		return ans;
	}
}
