package alogrithm;
import java.io.*;
import java.util.*;


public class d0329 {
    static int n;
    static int m;
    static int [] a;
    static int[] b;

    // 비트를 이용한 알고리즘
    // 완전 탐색이지만, 2^9 * 2^9승은 시간초과가 나기때문에 최적화가 필요함.
    // 마지막 or연산을 하게되면 같은 것끼리 or를 하면 같은 수가 나온다는 것을 이용함.
    // 그리고 최대로 될 수 있는 수는 512다. 1111 1111이니까.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		b = new int[m];
		st = new StringTokenizer(bReader.readLine());

		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bReader.readLine());
		for(int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int k = 0; k < 512; k++) {
			int count = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if((k | (a[i] & b[j])) == k) {
						count++;
						break;
					}
				}
			}
			
			if(count == n) {
				bWriter.write(String.valueOf(k));
				break;
			}
		}
		
		bWriter.flush();
		bWriter.close();
			
		
	}

}
