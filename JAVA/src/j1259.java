import java.io.*;
public class j1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = new String();
        while(!(s = br.readLine()).equals("0")) {
            String res = "yes";
            for(int i=0; i<s.length()/2; i++) {
                if(s.charAt(i) == s.charAt(s.length()-1-i)) {
                    continue;
                }
                else {
                    res = "no";
                }
            }
            System.out.println(res);
        }
    }
}
