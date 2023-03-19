package Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정점 개수
		int m = sc.nextInt(); // 간선 개수
		int v = sc.nextInt(); // 탐색 시작할 정점 번호
		
		boolean[] visited = new boolean[n+1]; // 방문했는지 검사하는 배열
		
		// 서로 이어졌는지 확인하는 행렬
		int[][] adjArray = new int[n+1][n+1];
		
		// 양방향 간선
		// 정점이 서로 이어지는 것을 표시한다.
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}
		
		System.out.println("BFS - 인접행렬");
		bfs_array(v, adjArray, visited);
	}
	
	// bfs 탐색
	public static void bfs_array(int v, int[][] adjArray, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int n = adjArray.length - 1;
		
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			
			for(int i=1;i<=n;i++) {
				if(adjArray[v][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
