public class Solution {
	class Building{
		int left;
		int right;
		int height;
		public Building(int l,int r, int h){
			left = l;
			right = r;
			height = h;
		}
	}
    public List<int[]> getSkyline(int[][] buildings) {
    	if (0==buildings.length) {
    		return new ArrayList<int[]>();
    	}

        Comparator<Building> cmpRight = new Comparator<Building>(){
        	@Override
        	public int compare(Building a, Building b){
        		return a.right-b.right;
        	}
        };


        Comparator<Building> cmpHeight = new Comparator<Building>(){
        	@Override
        	public int compare(Building a, Building b){
        		return a.height-b.height;
        	}
        };

        // PriorityQueue<Building> leftHeap = new PriorityQueue<Building>(cmpLeft);
        PriorityQueue<Building> heightHeap = new PriorityQueue<Building>(cmpHeight.reversed());
        PriorityQueue<Building> rightHeap = new PriorityQueue<Building>(cmpRight);
        Building base = new Building(0,Integer.MAX_VALUE,0);
        heightHeap.add(base);
        rightHeap.add(base);

        
        List<int[]> ans = new ArrayList<int[]>();
        Building temp = null;
        int i = 0;
        while (i<buildings.length) {
        	//=====================================
        	
    		
    		
			
			if(rightHeap.peek().right<buildings[i][0]) {
    			// 如果高度产生变化时，把新高度的左侧与刚结束楼的右边产生的交点添加进答案
				int previousHeight = heightHeap.peek().height;
    			int previousRight = rightHeap.peek().right;
    			//跳出过程
    			while(previousRight==rightHeap.peek().right){
    				heightHeap.remove(temp = rightHeap.poll());
    			}
    				
    			if (!(previousHeight==heightHeap.peek().height)) {
    			    int[] ansEle = new int[2];
    			    ansEle[0] = temp.right;
    			    ansEle[1] = heightHeap.peek().height;
    				ans.add(ansEle);
    			}
    		}
    		else{
    			int lastLeft = buildings[i][0];
	    		int previousHeight = heightHeap.peek().height;
	    		while(i<buildings.length&& lastLeft==buildings[i][0]){
	    			Building building2Added = new Building(buildings[i][0],buildings[i][1],buildings[i][2]);
	    			rightHeap.add(building2Added);
	    			heightHeap.add(building2Added);
	    			i++;
	    		}
	    		if (!(previousHeight==heightHeap.peek().height)) {
	    			int[] ansEle = new int[2];
			    	ansEle[0] = heightHeap.peek().left;
			    	ansEle[1] = heightHeap.peek().height;
					ans.add(ansEle);
	    		}
	    		
    		}
			
		    
        	//=======================================
    		
        	
        	
        }

        while(rightHeap.size()>1){
//        	System.out.println("size"+rightHeap.size());
        	int previousHeight = heightHeap.peek().height;
			int previousRight = rightHeap.peek().right;
			//跳出过程
			while(!rightHeap.isEmpty()&&previousRight==rightHeap.peek().right){
				heightHeap.remove(temp = rightHeap.poll());
			}
				
			if (!rightHeap.isEmpty()&&!(previousHeight==heightHeap.peek().height)) {
			    int[] ansEle = new int[2];
			    ansEle[0] = temp.right;
			    ansEle[1] = heightHeap.peek().height;
				ans.add(ansEle);
			}
        }

        if (rightHeap.size()==0) {
        	int[] ansEle = new int[2];
		    ansEle[0] = Integer.MAX_VALUE;
		    ansEle[1] = 0;
			ans.add(ansEle);
        }
//        else if(rightHeap.size()==2){
//        	//把基准去掉
//        	System.out.println();
//	        rightHeap.remove(base);
//	        heightHeap.remove(base);
//	        // 最后一个楼的右下端点加入
//	        int[] ansEle = new int[2];
//		    ansEle[0] = rightHeap.peek().right;
//		    ansEle[1] = 0;
//			ans.add(ansEle);
//        }
        
        

        return ans;
    }
}



//下一个楼还没来，这个楼已经要结束了
    		

    		

    		
				
			