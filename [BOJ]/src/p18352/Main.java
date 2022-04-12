package p18352;
import java.io.*;
import java.util.*;


public class Main {

	static int N;
	static int M;
	static int K;
	static int X;
	static ArrayList<Node>[] list;
	static int[] dist;
	static PriorityQueue<Node> nodes = new PriorityQueue<Node>();
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int w;
		public Node(int from, int to, int w){
			this.from = from;
			this.to = to;
			this.w = w;
		}
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int from = Integer.parseInt(st.nextToken());
			 int to = Integer.parseInt(st.nextToken());
			 list[from].add(new Node(from, to, 1));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		nodes.add(new Node(X,0,0));
		
		while(!nodes.isEmpty()) {
			Node now = nodes.poll();
			for(Node next : list[now.from]) {
				if(dist[next.to] < now.w) {
					continue;
				}
				if(dist[next.to] > dist[now.from] + now.w) {
					dist[next.to] = dist[now.from] + next.w;
					nodes.add(new Node(next.to, 0, dist[next.to]));
				}
			}
		}
		boolean isHave = false;
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				bw.write(i+"\n");
				isHave = true;
			}
		}

		if(!isHave) {
			bw.write("-1");
		}
		
		bw.flush();
		bw.close();
		
	
	
	
	}
}
