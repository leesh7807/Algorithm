import java.io.*;
import java.util.*;
public class j12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> dis = new ArrayList<>(); // LIS 길이를 구하기 위한 배열
        dis.add(arr[1]);
        for(int i=2; i<=n; i++) {
            if(arr[i] <= dis.get(dis.size()-1)) { // 마지막 입력보다 더 작은 값이 수열에 있으면
                int index = lowerBound(dis, arr[i]); // 작은 값보다 큰 것중에 제일 가까운 놈을 이분탐색으로 찾고,
                dis.set(index, arr[i]); // 작은 값으로 교체. 배열 중간이 바뀌어도 LIS 길이에는 영향 X. 끝이 바뀌면 거기서 이어가면됨.
                // 실제 LIS와는 다를 수 있지만 길이는 동일하게 구해진다. 
            }
            else {
                dis.add(arr[i]);
            }
        }
        int ans = dis.size();
        bw.write(Long.toString(ans));
        bw.close();
    }
    public static int lowerBound(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size()-1;
        while(start < end) {
            int mid = (start + end)/2;
            if(arr.get(mid) < target) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
} 
