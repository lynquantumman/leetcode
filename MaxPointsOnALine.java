
public class Solution {
    public int maxPoints(Point[] points) {
        HashMap<Integer,HashMap<Integer,Integer>> 
            map = new HashMap<Integer,HashMap<Integer,Integer>>();
            int x0 = 0;
            int y0 = 0;
            int x = 0;
            int y = 0;
            int overlap = 0;
            int gcd = 0;
            int maxPerPoint = 0;
            int result = 0;
        for (int i = 0;i<points.length ;i++ ) {
            overlap = 0;
            maxPerPoint = 0;
            map.clear();
            x0 = points[i].x;
            y0 = points[i].y;

            for (int j = i+1;j<points.length ;j++ ) {
                x = points[j].x-x0;
                y = points[j].y-y0; 
                //gradient x==0 || y==0||(x==0&&y==0) ||other

                if (x==0&&y==0) {
                    overlap++;
                    continue;
                }
                else if (0==x) {
                    y=1;
                }
                else if (0==y) {
                    x=1;
                }
                else {//x!=0&&y!=0
                    if ((x>0&&y<0) || (x<0&&y>0)) {
                        x = Math.abs(x);
                        y = Math.abs(y);
                        gcd = gcdRecursive(Math.min(x,y),Math.max(x,y));
                        x = x/gcd;
                        y = y/gcd;
                        y = -y;
                    }
                    else{
                        x = -x;
                        y = -y;
                        gcd = gcdRecursive(Math.min(x,y),Math.max(x,y));
                        x = x/gcd;
                        y = y/gcd;
                    }
                    

                }
                if(map.containsKey(x)){
                    map.get(x).put(y,map.get(x).getOrDefault(y,0)+1);
                }
                else {
                    HashMap<Integer,Integer> ele = new HashMap<Integer,Integer>();
                    ele.put(y,1);
                    map.put(x,ele);
                }

                maxPerPoint = Math.max(maxPerPoint,map.get(x).get(y));
            }
            result = Math.max(result,maxPerPoint+overlap+1);
        }
        return result;

    }
    //assuption is that x<=y
    private int gcdRecursive(int x,int y){
        if (0==x) {
            return y;
        }
        return gcdRecursive(y%x,x);
    }

}
