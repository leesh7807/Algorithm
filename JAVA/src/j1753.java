import java.util.*;
import java.io.*;
public class j1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vSize = Integer.parseInt(st.nextToken());
        int eSize = Integer.parseInt(st.nextToken());
        int[][] arr = new int[vSize+1][vSize+1]; // 간선 저장
        for(int i=0; i<vSize+1; i++) {
            for(int j=0; j<vSize+1; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] d = new int[vSize+1]; // 최소 거리 저장
        for(int i=0; i<vSize; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        d[start] = 0;
        for(int i=0; i<eSize; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        boolean[] isVisited = new boolean[vSize+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        
    }   
    static class Pair implements Comparable<Pair> {
        int n, w;
        Pair(int n, int w) {
            this.n = n;
            this.w = w;
        }
        @Override
        public int compareTo(Pair p) {
            return Integer.valueOf(this.w).compareTo(Integer.valueOf(p.w));
        }
    }
}
