package p1260;
import java.io.*;
import java.util.*;
public class Main {
	
	static int n;
	static int m;
	static int v;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer>[] adjList1;
	static PriorityQueue<Integer>[] adjList2;
	static boolean[] visited;
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		adjList1 = new PriorityQueue[n+1];
		adjList2 = new PriorityQueue[n+1];
		for(int i = 0; i < n+1; i++) {
			adjList1[i] = new PriorityQueue<Integer>();
			adjList2[i] = new PriorityQueue<Integer>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList1[a].add(b);
			adjList1[b].add(a);
			adjList2[a].add(b);
			adjList2[b].add(a);
		}
		
		dfs(v);
		bw.write(sb.toString()+"\n");
		sb = new StringBuilder();
		visited = new boolean[n+1];
		bfs(v);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	static void dfs(int start) {
	
		// 1. 목적지 인가?
		if(visited[start]) {
			return;
		}
		// 2. 체크인
		visited[start] = true;
		sb.append(start+" ");
		// 3. 연결된 곳을 순회
		PriorityQueue<Integer> qu = adjList1[start];
		while(!qu.isEmpty()) {
			int next = qu.poll();
			dfs(next);
		}
	}
	static void bfs(int start) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		
		while(!qu.isEmpty()) {
			int next = qu.poll();
			if(visited[next]) {
				continue;
			}
			sb.append(next+ " ");
			visited[next] = true;
			PriorityQueue<Integer> nextNode = adjList2[next];
			while(!nextNode.isEmpty()) {
				qu.add(nextNode.poll());
			}
		}
	}

}
