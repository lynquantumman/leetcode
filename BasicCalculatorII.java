//to transilate into the reverse polish expression to calculate
public class Solution {
 public int calculate(String s) {
 	char sign = '+';
 	int num = 0;
 	Stack<Integer> stk = new Stack<Integer>();
 	int i = 0;
 	s = s.trim();
 	while(i<s.length()){
 		while(i<s.length()&&Character.isDigit(s.charAt(i))){
 			num = num*10+s.codePointAt(i)-'0';
 			i++;
 		}

 		if (i==s.length()||!Character.isDigit(s.charAt(i))&&' '!=s.charAt(i)) {
 			switch(sign){
 				case '+':
 					stk.push(num);
 				break;
 				case '-':
 					stk.push(-num);
 				break;
 				case '*':
 					stk.push(stk.pop()*num);
 				break;
 				case '/':
 					stk.push(stk.pop()/num);
 				break;
 			}
 			num = 0;
 			if(i<s.length())
 				sign = s.charAt(i);
 		}


 		i++;
 	}

 	int sum = 0;
 	while(!stk.empty()){
 		sum+=stk.pop();
 	}
 	return sum;
 }
}