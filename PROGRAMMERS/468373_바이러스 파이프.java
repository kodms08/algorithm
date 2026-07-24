import java.util.*;

class Pipe {
    int e;
    int t;
    
    Pipe(int e, int t) { 
        this.e = e;
        this.t = t;
    }
}

class Solution {
    
    List<List<Pipe>> node;
    int[] visited;
    int answer = 0;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        node = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            node.add(new ArrayList<>());
        }
        
        for(int[] i: edges) {
            node.get(i[0]-1).add(new Pipe(i[1]-1, i[2]-1));
            node.get(i[1]-1).add(new Pipe(i[0]-1, i[2]-1));
        }
        
        visited = new int[n];
        visited[infection-1] = 1;
        
        dfs(infection-1, n, 1, k);        
        
        return answer;
    }
    
    void dfs(int s, int n, int cnt, int k) {
        
        if(cnt>k+1) return;
        
        if(cnt==k+1) {
            int sum = 0; 
            for(int v: visited) {
                if(v!=0) sum++;
            }

            answer = Integer.max(answer, sum);
        }
        
        for(int t=0; t<3; t++) {
            bfs(s, n, cnt, t);
            dfs(s, n, cnt+1, k);
            
            for(int i= 0; i<n; i++) {
                if(visited[i]>=cnt+1) visited[i]=0;
            }
        }
    }
    
    void bfs(int s, int n, int cnt, int t) {
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if( visited[i]>0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int c = queue.poll();
            
            for(Pipe p: node.get(c)) {   
                if(p.t==t && visited[p.e]==0) {
                    queue.add(p.e);
                    visited[p.e] = cnt+1;
                }
            }
        }
    }
}