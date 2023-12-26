import java.io.*;
import java.util.*;
public class j2166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 첫 좌표를 받는다
        st = new StringTokenizer(br.readLine());
        Pair p0 = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        // 두 번째 좌표부터 이전 좌표와 행렬식 계산
        long sum = 0;
        Pair prev = new Pair(p0.x, p0.y);
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Pair now = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            sum += prev.x * now.y - prev.y * now.x;
            prev = now;
        }
        // 마지막 좌표와 첫 좌표 행렬식 계산
        sum += prev.x * p0.y - prev.y * p0.x;
        // double로 변환. 절대값 취하고 1/2
        double ans = Double.valueOf(sum);
        ans = Math.abs(ans) / 2;
        // 둘째 자리에서 반올림
        ans = Math.round(ans * 10) / 10.0;
        System.out.printf("%.1f\n", ans);
    }
    static class Pair {
        long x, y;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

// 원리 https://gaussian37.github.io/math-algorithm-polygon_area/ 
/* (x1, y1), (x2, y2)
 * 두 좌표를 이은 선분을 y축에 사영시킨다 생각했을 때 생기는 사다리꼴
 * 이 사다리꼴을 계속해서 더해나가는 것으로 다각형의 면적을 구한다.
 * y3, y4... y좌표가 증가하다가 특정 시점에서 감소하면
 * 다음 사다리꼴의 높이가 음수가 되어 넓이에서 빠지게 된다.
 * 이러한 과정을 반복하면 다각형 내부의 넓이만 남게된다.
 */