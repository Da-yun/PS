package P1103;
import java.io.*;
import java.util.*;
public class Main {

	
	static int N;
	static int K;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[N+1][K+1];
		dp = new int[N+1][K+1];
		visited = new boolean[N][K];
		String string = "";
		for(int i = 0; i < N; i++) {
			string = bReader.readLine();
			for(int j = 0; j < K; j++) {
				char ch = string.charAt(j);
				if(ch != 'H') {
					int num = Integer.parseInt(String.valueOf(ch));
					map[i][j] = num;
				}else {
					map[i][j] = -1;
				}
			}
	   }
	  
	   dfs(0,0);
	   bufferedWriter.write(String.valueOf(max));
	   bufferedWriter.flush();
	   bufferedWriter.close();
	}
	
	static void dfs(int x, int y) throws IOException {
		//1. ������ �ΰ�?
		// 1.1 ���� ���ΰ�?
		if(x == K && y == N) {
			max = Integer.max(max, dp[y][x]);
			return;
		}
		// 1.2 �����ΰ�?
		if(map[y][x] == -1) {
			max = Integer.max(max, dp[y][x]);
			return;
		}
		// 1.3 �̹� �湮�� ���ΰ�?
		if(visited[y][x]) {
			bufferedWriter.write("-1");
			bufferedWriter.flush();
			bufferedWriter.close();
			System.exit(0);;
		}
		
		// 2. üũ��
		visited[y][x] = true;
		
		// 3. ����� ���� ��ȸ
		int[] mx = {map[y][x], -1 * map[y][x], 0, 0};
		int[] my = {0, 0, map[y][x], -1 * map[y][x]};
		
		for(int i = 0; i < 4; i++) {
			int dx = mx[i] + x;
			int dy = my[i] + y;
			// 4. �� �� �ִ� ��?
			// 4.1 ���� ���� ������
			if(dx >= 0 && dx < K && dy >= 0 && dy < N) {
				if(dp[dy][dx] < dp[y][x] + 1) {
					dp[dy][dx] = dp[y][x] + 1;
					dfs(dx, dy);
					// 5. ����
				}
			}else {
				if(dp[N][K] <dp[y][x] + 1) {
					dp[N][K] = dp[y][x] + 1;
					dfs(K, N);
				}
			}
		}
		
		//6. üũ�ƿ�
		visited[y][x] = false;
		
		
		
		
	}

}
