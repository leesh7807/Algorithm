import java.util.*;
import java.io.*;
public class j7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        LinkedList<Pair> tomato = new LinkedList<>();
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    tomato.add(new Pair(i, j));
                }
            }
        }
        int day = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!tomato.isEmpty()) {
            day++;
            LinkedList<Pair> nextDay = new LinkedList<>(); // 하루 동안 익는 토마토를 계산하기 위해 다른 큐로 가져온다.
            while(!tomato.isEmpty()) {
                nextDay.add(tomato.poll());                
            }
            for(Pair p : nextDay) {
                for(int i=0; i<4; i++) {
                    int newX = p.x+dx[i];
                    int newY = p.y+dy[i];
                    if(newX >= 0 && newX < row && newY >= 0 && newY < col && arr[newX][newY] == 0) { 
                        arr[newX][newY] = 1;
                        tomato.add(new Pair(newX, newY)); // 새롭게 익는 토마토를 집어 넣는다.
                    }
                }
            }
        }
        if(isRiped(row, col, arr)) {
            bw.write(Long.toString(day-1)); // 마지막으로 익은 토마토가 큐에 들어갔다 나오기 때문에 1을 빼준다.
        }
        else {
            bw.write("-1");
        }
        bw.close();
    }

    public static boolean isRiped(int row, int col, int[][] arr) { // 다 익었으면 true 아님 flase
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(arr[i][j] == -1) {
                    continue;
                }
                else if(arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
