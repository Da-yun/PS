package p1664;
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static boolean isNotPrime[];
	static List<Integer> prime;
	static void findPrime() {
		prime = new ArrayList<>();
		for(int i = 2; i+i <= n; i++) {
			if(isNotPrime[i]) {
				continue;
			}
			for(int j = i+i; j <= n; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		for(int i = 2; i <= n; i++) {
			if(!isNotPrime[i]) {
				prime.add(i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		isNotPrime = new boolean[n+1];
		findPrime();
		
		int count = 0;
		int sum = 0;
		
		for(int left =0; left < prime.size(); left++) {
			sum = 0;
			int right = left;
			while(sum <= n && right < prime.size()) {
				sum += prime.get(right);
				right++;
				if(sum == n) {
					count++;
					break;
				}
			}
		}
		
		
		
		
		System.out.println(count);
		
	
	
	
	
	
	}
}
