package p10775;
import java.io.*;
public class Main {

	static int g;
	static int p;
	static int[] parent;
	static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		parent[b] = a;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		g = Integer.parseInt(br.readLine());
		parent = new int[g+1];
		for(int i = 1; i <= g; i++) {
			parent[i] = i;
		}
		p = Integer.parseInt(br.readLine());
		int canDoking = -1;
		int count = 0;
		for(int i = 0; i < p; i++) {
			int arrive = Integer.parseInt(br.readLine());
			int parentArrive = find(arrive);
			if(parentArrive==0) {
				break;
			}
			count++;
			int parentPre = find(parentArrive-1);
			union(parentPre, parentArrive);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
