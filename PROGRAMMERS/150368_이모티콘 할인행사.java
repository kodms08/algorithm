import java.util.*;

class Solution {
    
    int[][] price;
    int[] com;
    int[] answer = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        
        price = new int[emoticons.length][5];
        for(int i=0; i<emoticons.length; i++) {
            price[i][0] = emoticons[i];
        }
        calculatorPrice();
        
        com = new int[emoticons.length];
        combi(users, 0);

        return answer;
    }
    
    void sum(int[][] users) {
        int sub = 0;
        int sales = 0;
        for(int i=0; i<users.length; i++) {
            int sum = 0;
            for(int j=0; j<com.length; j++) {
                if(com[j]*10>=users[i][0]) {
                    sum+=price[j][com[j]];
                }

            }
            if(sum>=users[i][1]) sub ++;
            else sales += sum;
        }
        
        if(sub>answer[0]) {
            answer = new int[]{sub, sales};
        } else if(sub==answer[0]) {
            answer[1] = Integer.max(answer[1], sales);
        }
    }
    
    void combi(int[][] users, int cur) {     
        if(cur==com.length) {
            sum(users);
            return;
        }
        
        for(int i=1; i<5; i++) {
            com[cur] = i;
            combi(users, cur+1);
        }
    }
    
    void calculatorPrice() {
        for(int i=0; i<price.length; i++) {
            for(int j=1; j<price[i].length; j++) {
                price[i][j] = price[i][0]*(10-j)/10;
            }
        }          
    }
}