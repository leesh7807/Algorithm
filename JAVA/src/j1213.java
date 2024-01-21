import java.io.*;
public class j1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length; i++) {
            alphabet[s[i] - 'A']++;
        }
        boolean one = false;
        char mid = '%';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] % 2 == 1) {
                if(one) {
                    System.out.println("I\'m Sorry Hansoo");
                    return;
                }
                else {
                    one = true;
                    mid = (char)(i + 'A');
                    alphabet[i]--;
                }
            }
            if(alphabet[i] > 0 && alphabet[i] % 2 == 0){
                for(int j = 0; j < alphabet[i] / 2; j++) {
                    sb.append((char)(i + 'A'));
                }
            }
        }
        if(mid == '%') System.out.println(sb.toString() + sb.reverse().toString());
        else System.out.println(sb.toString() + String.valueOf(mid) + sb.reverse().toString());
    }
}
