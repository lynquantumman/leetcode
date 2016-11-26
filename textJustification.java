
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> ans =  new ArrayList<String>();

    	String line = new String();
        for(String each:words){
        	if (each.length()>maxWidth) {
        		System.out.println("there's a wrong word bc of its length ");
        	}

        	// to add the word to the line
        	line+=(each+" ");
// to add the line to the ans;
        	if (line.length()>maxWidth+1) {
        	
        		//to get the line to the back and remove the space
        		line = line.substring(0,line.length()-2-each.length());
        		line = spaceInsert(line,maxWidth);
        		ans.add(line);

        		line = new String(each+" ");
        	}

        	


        }
        line = line.substring(0,line.length()-1);
        line = spaceInsertForLastLine(line,maxWidth);
        ans.add(line);
        return ans;
    }
// not used for the last sentence
    private int nextSpacePosition(CharSequence input, int position){
    	boolean flag = false;
    	if (' '==input.charAt(position)) {
    		int i = 0;
    		for (i = position;i<input.length();i=(i+1)%input.length()) {
//    			System.out.println("nextSpacePosition  1");
    			if(' ' != input.charAt(i))
    				flag=true;
    			if(true==flag && ' ' == input.charAt(i))
    				break;
    		}
    		return i;
    	}

    	else{
    		int i = 0;
    		int times = 0;
    		for (i = position;i<input.length();i=(i+1)%input.length()) {
    			times++;
    			if(times>input.length()+1){
    				return -1;
    			}
    			if(' ' == input.charAt(i))
    				break;
    		}
    		return i;
    	}
    	
    }

    

    private String spaceInsert(String line, int maxWidth){
    	
        StringBuilder lineBuilder = new StringBuilder(line);
        int spacePosition = 0;
        for (int i=line.length();i<maxWidth;i++ ) {
        	spacePosition = nextSpacePosition(lineBuilder, spacePosition);
        	if(-1==spacePosition){
        		return spaceInsertForLastLine(line, maxWidth);
        	}
        	else lineBuilder = lineBuilder.insert(spacePosition, ' ');
        }
        return new String(lineBuilder);
        
    }
    
    private String spaceInsertForLastLine(String line, int maxWidth){
    	StringBuilder lineBuilder = new StringBuilder(line);
        
        for (int i=line.length();i<maxWidth;i++ ) {
        	lineBuilder = lineBuilder.insert(line.length(), ' ');
        }
        return new String(lineBuilder);
    }
}