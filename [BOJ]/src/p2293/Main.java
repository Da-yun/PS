package p2293;
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int k;
	static int[] coin;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
		n= Integer.parseInt(stringTokenizer.nextToken());
		k= Integer.parseInt(stringTokenizer.nextToken());
		coin = new int[n];
		dp = new int[k+1];
		
		dp[0] = 1;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(bReader.readLine());
			coin[i] = num;
			for(int j = num; j <= k; j++) {
				dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		
		
		bufferedWriter.write(String.valueOf(dp[k]));
		bufferedWriter.flush();
		bufferedWriter.close();
		
		
	}

}
