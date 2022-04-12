package p1922;
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int M;
	static int connect = 0;
	static Node[] nodes;
	static int ans = 0;
	static int[] parent;
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int w;
		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		public int compareTo(Node o) {
			return this.w - o.w;
		}	
	}
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		parent[a] = b;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		nodes = new Node[M];
		parent = new int[N+1];
		for(int i = 1; i <=N; i++) {
			parent[i] = i;
		}
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(from, to, w);
		}
		Arrays.sort(nodes);
		int index = 0;
		while(connect != N-1 && index < M) {
			Node nowNode = nodes[index];
			int parentA = find(nowNode.from);
			int parentB = find(nowNode.to);
			if(parentA != parentB) {
				connect++;
				ans+= nowNode.w;
				union(parentA, parentB);
			}
			index++;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}
