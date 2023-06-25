import java.io.*;
import java.util.*;
public class j4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = new String();
        while(!(s = br.readLine()).equals(".")) {
            StringTokenizer st = new StringTokenizer(s, "()[]", true);
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()) {
                String temp = st.nextToken();
                if(temp.equals("(") || temp.equals(")") || temp.equals("[") || temp.equals("]")) {
                    list.add(temp);
                }
            }
            while(!list.isEmpty()) {
                boolean stopFlag = true;
                for(int i=0; i<list.size()-1; i++) {
                    if(list.get(i).equals("(") && list.get(i+1).equals(")") 
                    || list.get(i).equals("[") && list.get(i+1).equals("]")) {
                        list.remove(i);
                        list.remove(i);
                        stopFlag = false;
                    }
                }
                if(stopFlag) {
                    break;
                }
            }
            if(list.isEmpty()) {
                bw.write("yes\n");
            }
            else {
                bw.write("no\n");
            }
        }
        bw.close();
    }
}
