import java.io.*;
public class j2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String(br.readLine()).split(" ");
        boolean asc = true;
        boolean des = true;
        for(int i=0; i<8; i++) {
            if(Integer.parseInt(s[i]) != i+1) {
                asc = false;
            }
            if(Integer.parseInt(s[i]) != 8-i) {
                des = false;
            }
        }
        if(asc) {
            System.out.print("ascending");
        }
        else if(des) {
            System.out.print("descending");
        }
        else {
            System.out.print("mixed");
        }
    }
}
