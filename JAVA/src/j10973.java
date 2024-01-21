import java.io.*;
import java.util.*;
public class j10973 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int downEnd = 0;
        for(int i = 1; i < N; i++) {
            if(arr[i - 1] > arr[i]) {
                downEnd = i;
            }
        }
        if(downEnd == 0) {
            System.out.println(-1);
            return;
        }
        int temp = arr[downEnd - 1];
        int swapIdx = downEnd;
        for(int i = downEnd; i < N; i++) {
            if(temp > arr[i] && arr[i] > arr[swapIdx]) {
                swapIdx = i;
            }
        }
        arr[downEnd - 1] = arr[swapIdx];
        arr[swapIdx] = temp;
        ArrayList<Integer> reverseSorting = new ArrayList<>();
        for(int i = downEnd; i < N; i++) {
            reverseSorting.add(arr[i]);
        }
        reverseSorting.sort((a, b) -> {return Integer.compare(b, a);});
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < downEnd; i++) {
            sb.append(Long.toString(arr[i]) + " ");
        }
        for(Integer n : reverseSorting) {
            sb.append(Long.toString(n) + " ");
        }
        System.out.println(sb.toString());
    }    
}
