package P2211;
import java.io.*;
import java.util.*;
public class Main {
	static int dist[];
	static int from[];
	static ArrayList<Node> nodeMap[];
	static int N;
	static int M;
	static class Node implements Comparable<Node>{
		int node;
		int w;
		
		public Node(int node, int w) {
			this.node = node;
			this.w = w;
		}
		
		public int compareTo(Node O) {
			return this.w - O.w;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sTokenizer = new StringTokenizer(bReader.readLine());
		N = Integer.parseInt(sTokenizer.nextToken());
		M = Integer.parseInt(sTokenizer.nextToken());
		dist = new int[N+1];
		from = new int[N+1];
		nodeMap = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			nodeMap[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			sTokenizer = new StringTokenizer(bReader.readLine());
			int from = Integer.parseInt(sTokenizer.nextToken());
			int to = Integer.parseInt(sTokenizer.nextToken());
			int w = Integer.parseInt(sTokenizer.nextToken());
			nodeMap[from].add(new Node(to, w));
			nodeMap[to].add(new Node(from, w));
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		dist[1] = 0;
		queue.add(new Node(1, 0));
		
		while(!queue.isEmpty()) {
			Node nowNode = queue.poll();
			
		
			for(Node nextNode : nodeMap[nowNode.node]) {
				
				if(dist[nextNode.node] < nowNode.w) {
					continue;
				}
				
				int newDist = nowNode.w + nextNode.w;
				
				if(dist[nextNode.node] > newDist) {
					dist[nextNode.node] = newDist;
					from[nextNode.node] = nowNode.node;
					queue.add(new Node(nextNode.node, newDist));
				}
			}
			
		}
		bWriter.write(N-1 + "\n");
		for(int i = 2; i<=N; i++) {
			bWriter.write(from[i] + " " + i + "\n");
		}
		
		bWriter.flush();
		bWriter.close();
		
	}

}
