package com.ssafy.problem.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_D4_키순서_DFS {
	
	static int N,M,adj[][],cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][M+1]; //자신보다 키가 큰 관계를 표현
			
			StringTokenizer st = null;
			int a,b;
			
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; // 유향(a보다 b가 큼)
			}
			int ans=0; 
			for(int k=1; k<=N;k++) {
				cnt=0;
				gtDfs(k, new boolean[N+1]);
				ltDfs(k, new boolean[N+1]);
				if(cnt==N-1) ans++; //자신의 키 순서를 알 수 있는 애

			}
			System.out.println("#"+t+" "+ans);
			
		}
	}
	
	static void gtDfs(int cur,boolean[] visited) {
		//cur 정점 기준으로 자기보다 큰 정점 탐색
		visited[cur]=true;
		for(int i=1; i<=N; i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				cnt++; //자신을 세면 안 되니까 호출 전에 cnt++
				gtDfs(i,visited);
			}
		}
	}
	static void ltDfs(int cur,boolean[] visited) {
		//cur 정점 기준으로 자기보다 작은 정점 탐색
		visited[cur]=true;
		for(int i=1; i<=N; i++) {
			if(adj[i][cur]==1 && !visited[i]) {
				cnt++; //자신을 세면 안 되니까 호출 전에 cnt++
				ltDfs(i,visited);
			}
		}
	}
	

}
