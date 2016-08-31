package leetcode;
/**
 * @author Cradle Lee
 * @howToUse new NQueen(N).NQueenList
 * @outputFormat NQueenList is a ArrayList<ArrayList<Integer>>
 * and it has all the N Queens satisfied permutation.
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class NQueen {
	ArrayList<ArrayList<Integer>> NQueenList;
	public NQueen(int N){
		//===the part of permutation creator
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		LinkedList<Integer> input = new LinkedList<Integer>();
		for(int i=0;i<N;i++){
			input.add(i);
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		Permutation.Creator(prefix, input, N, result);
		//=========================================
		long total = factorial(N);
		NQueenList = new ArrayList<ArrayList<Integer>>();
		for(int th=0;th<total;th++){//这里面的每一次处理是对一次排列的处理
			ArrayList<Integer> permu = result.get(th);
			if(check(permu))
				NQueenList.add(permu);
		}
	}
	
	long factorial(int n){
		long prod=1;
		for(int i=1;i<=n;i++){
			prod*=i;
		}
		return prod;
	}
	
	boolean check(ArrayList<Integer> permu){//检查该排列是否满足N皇后规则
		int N=permu.size();
		for(int m=0,n=0;m<N;m++){
			int sum=0;
			for(int i=m,j=n;i<N&&j<N;i++,j++){//一次斜线检查
				if(j==permu.get(i))
					sum+=1;
			}
			if(sum>1)
				return false;
		}
		
		for(int m=1,n=0;n<N;n++){
			int sum=0;
			for(int i=m,j=n;i<N&&j<N;i++,j++){//一次斜线检查
				if(j==permu.get(i))
					sum+=1;
			}
			if(sum>1)
				return false;
		}
		return true;
	}
}
