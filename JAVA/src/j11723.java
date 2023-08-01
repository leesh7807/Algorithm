import java.io.*;
import java.util.*;
public class j11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            String req = st.nextToken();
            switch(req) {
                case "add" :
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove" :
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check" :
                    if(set.contains(Integer.parseInt(st.nextToken()))) {
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle" :
                    int x = Integer.parseInt(st.nextToken());
                    if(!set.remove(x)) {
                        set.add(x);
                    }
                    break;
                case "all" :
                    set = new HashSet<>();
                    for(int i=1; i<=20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty" :
                    set = new HashSet<>();
                    break;
            }
        }
        bw.close();
    }
}
