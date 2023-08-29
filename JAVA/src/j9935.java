import java.io.*;
import java.util.*;
public class j9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String e = br.readLine();
        ArrayList<Character> stack = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            stack.add(s.charAt(i));
            if(stack.size() >= e.length()) {
                boolean isExplosion = true;
                for(int j=0; j<e.length(); j++) {
                    if(stack.get(stack.size() - e.length() + j) != e.charAt(j)) {
                        isExplosion = false;
                        break;
                    }
                }
                if(isExplosion) {
                    for(int j=0; j<e.length(); j++) {
                        stack.remove(stack.size()-1);
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            for(Character c : stack) bw.write(c);
        }
        bw.close();
    }
}