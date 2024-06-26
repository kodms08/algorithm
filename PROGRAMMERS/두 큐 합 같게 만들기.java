import java.util.*;
​
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1+=queue1[i];
            sum2+=queue2[i];
        }
        
        
        while(sum1!=sum2) {
            if(answer>(queue1.length + queue2.length)*2) return -1;
            if(sum1>sum2) {
                int n = q1.poll();
                q2.add(n);
                sum1-=n;
                sum2+=n;
            }else{
                int n = q2.poll();
                q1.add(n);
                sum1+=n;
                sum2-=n;
            }
            answer++;
        }
        
        return answer;
    }
}