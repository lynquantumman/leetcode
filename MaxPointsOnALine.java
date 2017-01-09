/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
import java.util.ArrayList;
public class Solution {
    public int maxPoints(Point[] points) {
    	ArrayList<Double> tanArray = new ArrayList<Double>();
    	int orginDot = 0;
    	int xAxis = 0;
    	for (Point point:points) {
    		if(0==point.x && 0==point.y)
	        	orginDot++;
	        else {
	        	if (0==point.x) {
	        		xAxis++;
	        	}
	        	else
	        		tanArray.add(tangent(point));
	        }
    	}
        
    	Collections.sort(tanArray);
    	int max = 0;
    	max = maximunCount(tanArray);
    	max = max>xAxis?max:xAxis;

		return max+orginDot;

    }

    public double tangent(Point point){

    	return (double)point.y/(double)point.x;
    }

    int maximunCount(ArrayList<Double> input){
    	if (0==input.size()) {
    		return 0;
    	}
    	int temp = 1;
    	int max = 1;
    	for (int i = 0;i+1<input.size();i++) {
    		if(input.get(i)==input.get(i+1))
    			temp++;
    		else temp = 1;
    		max = temp>max?temp:max;
    	}
    	return max;
    }
}