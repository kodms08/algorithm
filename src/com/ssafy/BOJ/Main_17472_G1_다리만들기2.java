package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_G1_다리만들기2 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	static int[][] map, bridge;
	static boolean[][] visited;
	static int num=0;
	
	static class Number{
		int x;
		int y;
		int d;
		int c;
		public Number(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		bridge = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]==1) {
					num++;
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.offer(i);
					queue.offer(j);
					map[i][j]=num;
					visited[i][j]=false;
					while(!queue.isEmpty()) {
						int x=queue.poll();
						int y=queue.poll();
						for(int d=0; d<4; d++) {
							int nx=x+dx[d];
							int ny=y+dy[d];
							if(nx<0|| ny<0|| nx>=N|| ny>=M) continue;
							if(visited[nx][ny]) continue;
							if(map[nx][ny]==0) continue;
							queue.offer(nx);
							queue.offer(ny);
							visited[nx][ny]=true;
							map[nx][ny]=num;
						}
					}
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited = new boolean[N][M];
				if(map[i][j]!=0) {
					int number = map[i][j]; // 섬 번호
					for(int d=0; d<4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx<0|| ny<0|| nx>=N|| ny>=M) continue;
						if(map[nx][ny]==1) continue;
						
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		
	}


}
