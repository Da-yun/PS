package p1339;

import java.util.*;

import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[26];
		
		
		for(int i = 0; i < 26; i++) {
			arr[i] = 0;
		}
		for(int i = 0; i < n; i++) {
			String string = br.readLine();
			int mul = 0;
			for(int j = string.length()-1; j >= 0 ; j--) {
				char ch = string.charAt(j);
				arr[ch - 'A'] += (int)Math.pow(10, mul);
				mul++;
			}
		}
		
		
		Arrays.sort(arr, (a, b) -> b-a);
		
		long rst = 0;
		int val = 9;
		int index = 0;
		while(arr[index] != 0) {
			rst += arr[index] * val;
			index++;
			val--;
		}
		
		bw.write(rst+"");
		bw.flush();
		bw.close();
		
	
		
		
	}

}