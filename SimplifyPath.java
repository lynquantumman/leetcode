// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.

// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".

public class Solution {
    public String simplifyPath(String path) {
        String[] fragments = path.split("/",0);
        LinkedList<String> stk = new LinkedList<String>();
        for (String each:fragments) {
        	if ("".equals(each)||".".equals(each)) {
        		continue;
        	}
        	else if ("..".equals(each)) {
        		if (!stk.isEmpty()) {
        			stk.pop();
        		}
        		
        	}
        	else {
        		stk.push(each);
        	}
        }

        StringBuilder sb = new StringBuilder();
        for (int i = stk.size()-1;i>=0;i--) {
        	sb.append("/");
        	sb.append(stk.get(i));
        }
        if (sb.length()==0) {
        	sb.append("/");
        }
        String ans = new String(sb);
        return ans;
    }
}