package p2458;
import java.io.*;
import java.util.*;
public class Main {

	static int n;
	static int m;
	static int count = 0;
	static int Max = Integer.MAX_VALUE;
	static int[][] lank;
	static int[] up;
	static int[] down;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lank = new int[n+1][n+1];
		up = new int[n+1];
		down = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			Arrays.fill(lank[i],Max);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int aft = Integer.parseInt(st.nextToken());
			lank[pre][aft] = Integer.min(1, lank[pre][aft]);
			up[pre]++;
			down[aft]++;
		}
		
		for(int k = 1; k <= n; k++) { // 경유지
			for(int i = 1; i <= n; i++) { // 출잘지
				if(lank[k][i]==1) {
					for(int j = 1; j <=n; j++) { // 도착지
						if(lank[j][k]==1) {
							if(lank[j][i] != 1) {
								up[j]++;
								down[i]++;
								lank[j][i] = 1;
							}
						}
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++){
			int index = down[i] + up[i] + 1;
			if(index == n) {
				count++;
			}
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
		
	}

}
