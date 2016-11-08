public class Solution {
    public String addBinary(String a, String b) {
        int add1 = Integer.parseUnsignedInt(a,2);
        int add2 = Integer.parseUnsignedInt(b,2);
        int ans = add1+add2;
        return Integer.toBinaryString(ans);
    }
}