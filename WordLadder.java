// 单源最短路径算法
public class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> q = null;
        LinkedList<String> needToTransfer = null;
        String needToCheck = null;
        int dist = 2;
        q = onediff(beginWord,wordList);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0;i<len ;i++ ) {
                needToCheck = q.poll();
                if(needToCheck.equals(endWord))
                    return dist;
                needToTransfer = onediff(needToCheck,wordList);
                q.addAll(needToTransfer);
                wordList.removeAll(needToTransfer);
            }
            dist++;
        }

        return 0;
    }

    private LinkedList<String> onediff(String from,List<String> wordList){
        LinkedList<String> q = new LinkedList<String>();
        String needToCheck = null;
        int diff = 0;
        for (int i = 0;i<wordList.size() ;i++ ) {
            needToCheck = wordList.get(i);
            diff = 0;
            for (int j = 0;j<from.length() ;j++ ) {
                if(needToCheck.codePointAt(j)!=from.codePointAt(j)){
                    diff++;
                }

                if (diff>1) {
                    break;
                }
            }
            if (1==diff) {
                q.offer(needToCheck);
            }
        }
        return q;
    }

}