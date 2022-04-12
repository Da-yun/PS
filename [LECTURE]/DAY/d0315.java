package d0315;
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] score;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(bReader.readLine());
		score = new int[n+1];
		StringTokenizer st = new StringTokenizer(bReader.readLine());
		for(int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);
		
		for(int i = 1; i <= n-1; i+=2) {
			int now = score[i];
			int next = score[i+1];
			count+= (next-now);
		}
		
		bWriter.write(count+"");
		bWriter.flush();
		bWriter.close();
	
	}

}
