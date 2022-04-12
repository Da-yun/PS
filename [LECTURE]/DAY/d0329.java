package alogrithm;
import java.io.*;
import java.util.*;


public class d0329 {
    static int n;
    static int m;
    static int [] a;
    static int[] b;

    // ��Ʈ�� �̿��� �˰���
    // ���� Ž��������, 2^9 * 2^9���� �ð��ʰ��� ���⶧���� ����ȭ�� �ʿ���.
    // ������ or������ �ϰԵǸ� ���� �ͳ��� or�� �ϸ� ���� ���� ���´ٴ� ���� �̿���.
    // �׸��� �ִ�� �� �� �ִ� ���� 512��. 1111 1111�̴ϱ�.
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
