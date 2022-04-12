package p2156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;

	static Integer[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		arr = new Integer[n+1];
		
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			dp[i] = -1;
		}
		dp[0] = 0;
		dp[1] = arr[1];
		
		if(n > 1) {
			dp[2] = arr[1] + arr[2];
		}
		bWriter.write(recur(n)+"");
	    bWriter.flush();
	    bWriter.close();
	}
	static int recur(int n) {
		
		if(dp[n] == -1) {
			dp[n] = Math.max(Math.max(recur(n-2), recur(n-3) + arr[n-1])+ arr[n], recur(n-1));
		}
		return dp[n];
	}

}
