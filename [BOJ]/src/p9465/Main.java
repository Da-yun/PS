package p9465;
import java.io.*;
import java.util.*;
public class Main {

	
	static int t;
	static int[][] arr;
	static int[][] dp;
	static int row;

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		StringTokenizer stringTokenizer;
		for(int i = 0; i < t; i++) {
			row = Integer.parseInt(br.readLine());
			arr = new int[2][row+1];
			dp = new int[2][row+1];
			for(int col = 0; col < 2; col++) {
				stringTokenizer = new StringTokenizer(br.readLine());
				for(int r = 1; r <= row; r++) {
					arr[col][r] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			dp[0][1]= arr[0][1];
			dp[1][1]= arr[1][1];
			for(int k = 2; k <= row; k++) {
				dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + arr[0][k];
				dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + arr[1][k];
			}
			bWriter.write(Math.max(dp[0][row], dp[1][row])+"\n");
		}
		bWriter.flush();
		bWriter.close();
	
	}
}
