/**
 * @describe this is a demo to show how to use the I2R and R2I
 * @author Cradle Lee
 */

package integerToRoman;

public class Demo {
	public static void main(String[] args){
		sop(I2R.convert("3999"));
		sop(R2I.convert("MMMCMXCIX"));
		
	}
	public static void sop(Object ob){
		System.out.println(ob);
	}
}

