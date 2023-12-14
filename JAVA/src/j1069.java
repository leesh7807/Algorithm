import java.io.*;
import java.util.*;
public class j1069 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    
        int X, Y, D, T;
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        double dist = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)); 
        if(dist <= T || D <= T) {
            System.out.println(dist);
            return;
        }
        double ans = 0;
        int jumpCnt = 1;
        while(jumpCnt * D < dist) {
            jumpCnt++;
        }
        if(jumpCnt * D == dist) {
            ans = jumpCnt * T;
        }
        else {
            if(jumpCnt == 1) { // 한 번만 뛰어도 목표 지점을 넘는 경우
                ans = Math.min((jumpCnt + 1) * T, T + Math.abs(dist - D)); // 점프 2번 vs 점프 1번 + 남은 거리
                ans = Math.min(dist, ans); // vs 걸어가기
            }
            else 
                ans = Math.min(jumpCnt * T, (jumpCnt - 1) * T + Math.abs(dist - D * (jumpCnt - 1))); // 점프로만 이동하기 vs 부족하게 뛰고 걸어가기
        }
        System.out.println(ans);
    }
}