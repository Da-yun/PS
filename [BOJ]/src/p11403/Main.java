package p11403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bReader.readLine());
		map = new int[N][N];
		StringTokenizer stringTokenizer;
		for(int i =0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bReader.readLine());
			for(int j =0; j < N; j++) {
				int path = Integer.parseInt(stringTokenizer.nextToken());
				if(path==1) {
					map[i][j] = 1;
				}
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i <N; i++) {
				if(k==i) {
					continue;
				}
				for(int j = 0; j < N; j++) {
					if(map[i][j]==1) {
						continue;
					}
					if(map[i][k]==1 && map[k][j]==1) {
						map[i][j] =1;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bWriter.write(map[i][j] + " ");
			}
			bWriter.write("\n");
		}
		bWriter.flush();
		bWriter.close();
	}

}
