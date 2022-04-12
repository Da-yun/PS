package p1012;
import java.io.*;
import java.util.*;

public class Main {

	static int count;
	static int M;
	static int N;
	static int K;
	static int[] mx = {1, -1, 0, 0};
	static int[] my = {0, 0, 1, -1};
	static int[][] map;
	static Queue<Node> bachuNodes;
	static class Node{
		int x; 
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(bReader.readLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
			M = Integer.parseInt(stringTokenizer.nextToken());
			N = Integer.parseInt(stringTokenizer.nextToken());
			K = Integer.parseInt(stringTokenizer.nextToken());
			bachuNodes = new LinkedList<>();
			map = new int[N][M];
			count = 0 ;
			int  x, y = 0;
			for(int j = 0; j < K ; j++) {
				stringTokenizer = new StringTokenizer(bReader.readLine());
				x = Integer.parseInt(stringTokenizer.nextToken());
				y = Integer.parseInt(stringTokenizer.nextToken());
				bachuNodes.add(new Node(x, y));
				map[y][x] = 1;
			}
			bfs();
			bWriter.write(count+"\n");
		}
		bWriter.flush();
		bWriter.close();
	}
	static void bfs() {
		while(!bachuNodes.isEmpty()) {
			Node nowNode = bachuNodes.poll();
			int nowX = nowNode.x;
			int nowY = nowNode.y;
			if(map[nowY][nowX] != 1) {
				continue;
			}else {
				count++;
				map[nowY][nowX] = 0;
				Queue<Node> nextNodes = new LinkedList<>();
				nextNodes.add(nowNode);
				while(!nextNodes.isEmpty()) {
					// 1. 인접한 곳을 순회한다.
					Node now = nextNodes.poll();
					for(int i = 0; i < 4; i++) {
						int dx = mx[i] + now.x;
						int dy = my[i] + now.y;
						if(dx >= 0 && dx < M && dy >= 0 && dy < N) {
							if(map[dy][dx] == 1) {
								nextNodes.add(new Node(dx, dy));
								map[dy][dx] = 0;
							}
						}
					}
				}
			}
		}
	}
}
