//1,3,5
//8,3,4
//1,5,9

//1,2,5
//3,1,4
//1,2,3
//每一个矩阵由若干棵树构成，当遍历完一棵树后，将除叶子节点以外的节点都disable掉，
//因为叶子节点是树与树之间的连接，能够被二次使用
//问题就转化为，分离出这若干个树，并且找出每个树的最长枝干
//构件二叉树
//将树中的非叶子节点都装载一个哈希表里面，这样就可以快速判定节点是否被判断过
public class Solution {
int height;
int width;
int[][] matrix;
int[][] cache;
public int longestIncreasingPath(int[][] matrix) {
 this.height = matrix.length;
 if (this.height==0) {
     return 0;
 }
 this.width = matrix[0].length;
 this.matrix = matrix;
 this.cache = new int[height][width];
 
 int max = 0;
 
 for (int i = 0;i<matrix.length ;i++ ) {
     for (int j = 0;j<matrix[0].length ;j++ ) {
         //here we need to find the root node, which is not smaller than others
         //use the root node to find the longest path based on that root node
             if (0==cache[i][j]) {
                 this.cache[i][j] = findLongestBranch(i,j);
             }
     }
 }
 for (int i = 0;i<matrix.length ;i++ ) {
     for (int j = 0;j<matrix[0].length ;j++ ) {
         max = Math.max(max,cache[i][j]);
                 
             
     }
 }

 return max;
 
}

//return the len of the max branch of the tree
//the sequence is right,top,left,bottom
private int findLongestBranch(int row, int col){
 int val = this.matrix[row][col];
 
 int max = 0;

 
 if((col+1)<this.width&&this.matrix[row][col+1]<val){
      if (cache[row][col+1]==0) {
          cache[row][col+1] = findLongestBranch(row,col+1);
      }
      max = Math.max(max,cache[row][col+1]);
 }
 
 if((row-1)>=0&&this.matrix[row-1][col]<val){
     if (cache[row-1][col]==0) {
          cache[row-1][col] = findLongestBranch(row-1,col);
      }
      max = Math.max(max,cache[row-1][col]);
 }
 
 if((col-1)>=0&&this.matrix[row][col-1]<val){
     if (cache[row][col-1]==0) {
          cache[row][col-1] = findLongestBranch(row,col-1);
      }
      max = Math.max(max,cache[row][col-1]);
 }
 if((row+1)<this.height&&this.matrix[row+1][col]<val){
     if (cache[row+1][col]==0) {
          cache[row+1][col] = findLongestBranch(row+1,col);
      }
      max = Math.max(max,cache[row+1][col]);
 }
 
 return max+1;
}

}