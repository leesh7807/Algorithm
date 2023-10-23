import java.io.*;
import java.util.*;
public class j1041 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        ArrayList<Long> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        long oneFaceMin = INF;
        for(int i=0; i<6; i++) {
            long temp = Long.parseLong(st.nextToken());
            arr.add(temp);
            oneFaceMin = Math.min(oneFaceMin, temp);
        }
        // 6면으로만 이루어졌을 경우
        if(n==1L) {
            arr.sort(null);
            int res = 0;
            for(int i=0; i<5; i++) {
                res += arr.get(i);
            }
            System.out.println(res);
            return;
        }
        int[][] twoFaceCase = {{0,1}, {0,2}, {0,3}, {0,4}, {1,2}, {1,3}, {1,5}, {2,4}, {2,5}, {3,4}, {3,5}, {4,5}};
        long twoFaceMin = INF;
        for(int i=0; i<12; i++) {
            twoFaceMin = Math.min(arr.get(twoFaceCase[i][0]) + arr.get(twoFaceCase[i][1]), twoFaceMin);
        }
        int[][] threeFaceCase = {{0,1,2}, {0,1,3}, {0,2,4}, {0,3,4}, {1,3,5}, {1,2,5}, {2,4,5}, {3,4,5}};
        long threeFaceMin = INF;
        for(int i=0; i<8; i++) {
            threeFaceMin = Math.min(arr.get(threeFaceCase[i][0]) + arr.get(threeFaceCase[i][1]) + arr.get(threeFaceCase[i][2]), threeFaceMin);
        }
        long ans = (n-2L) * (n-2L) * 5L * oneFaceMin; // 5면
        ans += (n-2L) * 4L * oneFaceMin; // 아래 4모서리
        ans += (n-2L) * 8L * twoFaceMin; // 나머지 모서리
        ans += 4L * twoFaceMin; // 아래 4꼭짓점
        ans += 4L * threeFaceMin; // 나머지 꼭짓점
        System.out.println(ans);
    }
}
