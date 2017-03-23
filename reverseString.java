public class Solution {
    public String reverseString(String s) {
        StringBuilder temp = new StringBuilder(s);
        temp = temp.reverse();
        return new String(temp);
    }
}