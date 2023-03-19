package Study;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 
		
		boolean[] visited = new boolean[n+1];
		
		LinkedList<Integer>[] adjList =	new LinkedList[n + 1];
		
		for(int i=0;i<=n;i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		
		for(int i=1;i<=n;i++) {
			Collections.sort(adjList[i]);
		}
		
		System.out.println("BFS - 인접리스트");
		bfs_list(v, adjList, visited);
		
		sc.close();
	}
	
	public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.add(v);
		
		while(queue.size() != 0) {
			v = queue.poll();
			System.out.print(v + " ");
			
			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) {
				int w = iter.next();
				if(!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	}
}
