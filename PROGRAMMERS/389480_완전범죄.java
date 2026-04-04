import java.util.*;

class Solution {    
    public int solution(int[][] info, int n, int m) {
        
        int answer = 1000;
        int[][] dp = new int[info.length+1][m];
        
        for(int i=0; i<=info.length; i++) {
            Arrays.fill(dp[i], 1000);
        }
        
        dp[0][0] = 0;
        
        for(int i=1; i<=info.length; i++) {
            for(int j=0; j<m; j++) {
                //a
                dp[i][j] = Integer.min(dp[i][j], dp[i-1][j]+info[i-1][0]);
                //b
                if(j+info[i-1][1]<m){
                    dp[i][j+info[i-1][1]] = Integer.min(dp[i][j+info[i-1][1]], dp[i-1][j]);               
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            if(dp[info.length][i]>=n) continue;
            answer = Integer.min(answer, dp[info.length][i]);
        }
        if (answer>=1000) answer = -1;
        
        return answer;
    }
}