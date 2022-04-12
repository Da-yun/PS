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
			 // ������ ��� ����
		}
		check = true;
		for(int i= 1; i < n+1; i++) {
			if(!check) {
				// �̺б׷����� �ƴϸ� �ΰ��� �����Ⱑ �Ұ���
				bWriter.write("IMPOSSIBLE");
				bWriter.flush();
				System.exit(0);
				break;
			}
			if(colors[i]==0) {
				// �湮���� �ʾ����� dfs����
				dfs(i,Red);
			}
		}
		for(int i = 1; i <= n; i++) {
			// ���� ����̸� 1
			if(colors[i]==1) {
				bWriter.write(1+" ");
			}else {
				// ��������̸� 2
				bWriter.write(2+" ");
			}
		}
		bWriter.flush();
		bWriter.close();
		
		
	}
	static void dfs(int start, int color) {
		colors[start] = color;
		// ���� �÷��� �����ϰ�
		for(int adj : list[start]) {
			if(colors[adj]==color) {
				// ���۳��� �������
				check = false;
				return;
			}
			if(colors[adj]==0) {
				dfs(adj, -color);
			}
		}
	}

}
