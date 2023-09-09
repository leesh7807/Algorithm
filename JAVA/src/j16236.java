import java.io.*;
import java.util.*;
public class j16236 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int time = 0;
        int[][] map = new int[N][N];
        Pair sharkPos = new Pair(-1, -1);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val == 9) {
                    sharkPos = new Pair(i, j);
                    map[i][j] = 0;
                }
            }
        }
        Shark shark = new Shark(sharkPos, map);
        int timeTemp;
        while((timeTemp = shark.getTimeForFindingFish()) != -1) {
            time += timeTemp;
        }
        System.out.println(time);
    }
    static class Shark {
        int[][] map;
        int size = 2;
        int eaten = 0;
        Pair coord;
        public Shark(Pair coord, int[][] map) {
            this.coord = coord;
            this.map = map;
        }
        public int getTimeForFindingFish() {
            int time = bfs();            
            return time;
        }
        private int bfs() {
            int time = 1;
            LinkedList<Pair> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[map.length][map.length];
            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, -1, 1, 0};
            queue.add(coord);
            isVisited[coord.row][coord.col] = true;
            while(!queue.isEmpty()) {
                LinkedList<Pair> now = new LinkedList<>();
                while(!queue.isEmpty()) {
                    now.add(queue.poll());
                }
                PriorityQueue<Pair> retQueue = new PriorityQueue<>((Pair a, Pair b) -> {
                    if(a.row == b.row) return Integer.compare(a.col, b.col);
                    else return Integer.compare(a.row, b.row);
                });
                while(!now.isEmpty()) {
                    Pair nowCoord = now.poll();
                    for(int d=0; d<4; d++) {
                        int nextRow = nowCoord.row + dr[d];
                        int nextCol = nowCoord.col + dc[d];
                        if(nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map.length || isVisited[nextRow][nextCol]) continue;
                        int next = map[nextRow][nextCol];
                        if(next == 0 || next == this.size) {
                            queue.add(new Pair(nextRow, nextCol));
                            isVisited[nextRow][nextCol] = true;
                        }
                        else if(next < this.size && next != 0) {
                            retQueue.add(new Pair(nextRow, nextCol));
                        }
                    }
                }
                if(!retQueue.isEmpty()) {
                    Pair ret = retQueue.poll();
                    setCoord(ret);
                    eat(ret.row, ret.col);
                    return time;
                }
                time++;
            }
            return -1;
        }
        private void setCoord(Pair coord) {
            this.coord = coord;
        }
        private void eat(int row, int col) {
            this.map[row][col] = 0;
            eaten++;
            if(eaten == size) {
                eaten = 0;
                size++;
            }   
        }
        
    }
    static class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}