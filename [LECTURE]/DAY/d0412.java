package d0412;
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int[] colors;
	static boolean check;
	static ArrayList<Integer> list[];

	static final int Red = 1;
	static final int Blue = -1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bReader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		colors = new int[n+1];
		for(int i =0; i < n+1; i++) {
			list[i]= new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++) {
			 st = new StringTokenizer(bReader.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 list[a].add(b);
			 list[b].add(a);
			 // 인접한 노드 저장
		}
		check = true;
		for(int i= 1; i < n+1; i++) {
			if(!check) {
				// 이분그래프가 아니면 두개로 나누기가 불가능
				bWriter.write("IMPOSSIBLE");
				bWriter.flush();
				System.exit(0);
				break;
			}
			if(colors[i]==0) {
				// 방문하지 않았으면 dfs실행
				dfs(i,Red);
			}
		}
		for(int i = 1; i <= n; i++) {
			// 시작 노드이면 1
			if(colors[i]==1) {
				bWriter.write(1+" ");
			}else {
				// 인접노드이면 2
				bWriter.write(2+" ");
			}
		}
		bWriter.flush();
		bWriter.close();
		
		
	}
	static void dfs(int start, int color) {
		colors[start] = color;
		// 시작 컬러를 저자하고
		for(int adj : list[start]) {
			if(colors[adj]==color) {
				// 시작노드랑 같으면안
				check = false;
				return;
			}
			if(colors[adj]==0) {
				dfs(adj, -color);
			}
		}
	}

}
