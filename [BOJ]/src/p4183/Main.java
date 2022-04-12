package p4183;
import java.io.*;
import java.util.*;
public class Main {
	static int t;
	static int n;
	static Map<Integer, Integer> map;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			int count = 0;
			int num;
			int index = 0;
			max = 0;
			for(int j = 1; j <= n; j++) {
				num = Integer.parseInt(br.readLine());
				if(map.containsKey(num)) {
					index = Integer.max(index, map.get(num));
					count = j - index -1;
				}
				map.put(num, j);
				count++;
				max = Integer.max(max,count);	
			}
			bw.write(max+"\n");
		}
		bw.flush();
		bw.close();
	
	
	
	
	}
}
