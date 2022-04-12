package p11728;
import java.io.*;
import java.util.*;
public class Main {
	
	static int n;
	static int m;
	static int[] a;
	static int[] b;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		b = new int[m];
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		int leftIndex = 0;
		int rightIndex = 0;
		while(leftIndex < n && rightIndex < m) {
			if(a[leftIndex] > b[rightIndex]) {
				sb.append(b[rightIndex] + " ");
				rightIndex++;
			}else if(a[leftIndex] < b[rightIndex]) {
				sb.append(a[leftIndex] + " ");
				leftIndex++;
			}else {
				sb.append(b[rightIndex] + " ");
				rightIndex++;
				sb.append(a[leftIndex] + " ");
				leftIndex++;
			}
		}
		
		if(leftIndex < n) {
			for(int i = leftIndex; i< n; i++) {
				sb.append(a[i] + " ");
			}
		}else if(rightIndex < m) {
			for(int i = rightIndex; i< m; i++) {
				sb.append(b[i] + " ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
