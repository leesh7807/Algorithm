import java.io.*;
import java.util.*;
public class j1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> crain = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            crain.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        crain.sort((a, b) -> {return Integer.compare(a, b);});
        box.sort((a, b) -> {return Integer.compare(a, b);});
        int cnt = 0;
        if(crain.get(crain.size()-1) < box.get(box.size()-1)) {
            System.out.println(-1);
            return;
        }
        while(!box.isEmpty()) {
            for(int i=0; i<crain.size(); i++) {
                int canLift = crain.get(i);
                if(box.isEmpty()) break;
                if(canLift < box.get(0)) continue;
                int lo = 0;
                int hi = box.size()-1;
                while(lo+1 < hi) {
                    int mid = (lo + hi) / 2;
                    int weight = box.get(mid);
                    if(weight <= canLift) {
                        lo = mid;
                    }
                    else {
                        hi = mid;
                    }
                }
                box.remove(lo);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
