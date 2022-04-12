package alogrithm;
import java.io.*;
import java.util.*;
public class d0322 {
	static int n;
	static int m;
	static int[] parent;
	static int[] rank;
	static int maxLength = Integer.MIN_VALUE;
	static int groupCount;

	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static int union(int a, int b) {
		int temp = 0;
		if(rank[a] < rank[b]) {
			temp = rank[a];
			rank[a] = rank[b];
			rank[b] = temp;
		}
		parent[b] = a;
		rank[a] += rank[b];
		groupCount-=1;
		return rank[a];
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		StringBuilder sbBuilder = new StringBuilder();
		parent = new int[n+1];
		rank = new int[n+1];
		groupCount = n;
		for(int i = 1; i < n+1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(bReader.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int parentX = find(x);
			int parentY = find(y);
			int nextRank = 0;
			if(parentX!=parentY) {
				nextRank = union(parentX, parentY);
			}
			maxLength = Integer.max(maxLength, nextRank);
			sbBuilder.append(groupCount + " " + maxLength + "\n");
		}
		bWriter.write(sbBuilder.toString());
		bWriter.flush();
		bWriter.close();
	}
}
