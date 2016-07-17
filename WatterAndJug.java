/*
watter and jug problem
You are given two jugs with capacities x and y litres. 
There is an infinite amount of water supply available. 
You need to determine whether it is possible to measure exactly z litres using these two jugs.
If z liters of water is measurable, 
you must have z liters of water contained within one or both buckets by the end.
Operations allowed:

    Fill any of the jugs completely with water.
    Empty any of the jugs.
    Pour water from one jug into another till the 
    other jug is completely full or the first jug itself is empty.
@author Cradle Lee
*/
class WatterAndJug{
	public static void main(String[] args){
		//use Bezout lemma
		//0<=z<=(x+y)
		//z must be a multiple of gcd(x,y)
		int x=6;
		int y=2;
		int z=3;
		//==============above is the input phase
		int big = Math.max(x,y);
		int small = Math.min(x,y);
		if(z>=0&&z<big+small)
			if(z%gcd(big, small)==0)
				sop("That's okay.");
			else
				sop("That's impossible.");
		else
			sop("That's impossible.");
	}

	public static void sop(Object obj){
		System.out.println(obj);
	}

	public static int gcd(int big, int small){
		int rest = big%small;
		if(rest==0)
			return small;
		else{
			big = small;
			small = rest; 
			return gcd(big,small);
		}
		
	}
}