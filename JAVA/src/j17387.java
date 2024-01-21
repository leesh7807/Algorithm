import java.io.*;
import java.util.*;
public class j17387 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());
        long outer1 = x1*y2 + x2*y3 + x3*y1 - (x2*y1 + x3*y2 + x1*y3);
        long outer2 = x1*y2 + x2*y4 + x4*y1 - (x2*y1 + x4*y2 + x1*y4);
        long outer3 = x3*y4 + x4*y1 + x1*y3 - (x4*y3 + x1*y4 + x3*y1);
        long outer4 = x3*y4 + x4*y2 + x2*y3 - (x4*y3 + x2*y4 + x3*y2);
        outer1 = outer1 < 0 ? -1 : (outer1 == 0 ? 0 : 1);
        outer2 = outer2 < 0 ? -1 : (outer2 == 0 ? 0 : 1);
        outer3 = outer3 < 0 ? -1 : (outer3 == 0 ? 0 : 1);
        outer4 = outer4 < 0 ? -1 : (outer4 == 0 ? 0 : 1);
        // 선분이 임의의 직선 위에 겹쳐있음
        if(outer1 == 0 && outer2 == 0) {
            boolean c1 = Math.min(x1, x2) <= Math.max(x3, x4);
            boolean c2 = Math.max(x1, x2) >= Math.min(x3, x4);
            boolean c3 = Math.min(y1, y2) <= Math.max(y3, y4);
            boolean c4 = Math.max(y1, y2) >= Math.min(y3, y4);
            if(c1 && c2 && c3 && c4) System.out.println(1);
            else System.out.println(0);
            return;
        }
        if(outer1 * outer2 > 0 || outer3 * outer4 > 0) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }
}

/* CCW
 * 두 벡터에 대한 외적이 양의 값이면 반시계
 * 음의 값이면 시계 방향
 * 0이면 평행
 * 선분이 교차한다 -> 각각의 선분 벡터에 대한 나머지 두점의 외적 결과가 반대 부호로 나와야 한다.
 * & 둘 다 평행한 상태로 맞닿는 경우
 */