import java.io.*;
import java.util.*;
public class j2493 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        arr[0] = Integer.MAX_VALUE;
        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[n+1];
        ArrayList<Pair> stack = new ArrayList<>();
        for(int i=1; i<n+1; i++) {
            if(arr[i-1] > arr[i]) {
                stack.add(new Pair(arr[i-1], i-1));
                result[i] = i-1;
            }
            else {
                while(arr[i] > stack.get(stack.size()-1).height) {
                    stack.remove(stack.size()-1);
                }
                result[i] = stack.get(stack.size()-1).pos;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++) {
            sb.append(Long.toString(result[i]) + " ");
        }
        System.out.println(sb.toString());
    }
    static class Pair {
        int height, pos;
        public Pair(int height, int pos) {
            this.height = height;
            this.pos = pos;
        }
    }
}
