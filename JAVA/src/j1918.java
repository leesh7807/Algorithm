import java.io.*;
import java.util.*;
public class j1918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-*/()", true);
        ArrayList<String> stack = new ArrayList<>();
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if(s.equals("(")) {
                stack.add(s);
                continue;
            }
            if(s.equals(")")) {
                while(!stack.get(stack.size()-1).equals("(")) {
                    bw.write(stack.remove(stack.size()-1));
                }
                stack.remove(stack.size()-1);
                continue;
            }
            if(s.equals("+") || s.equals("-")) {
                if(stack.isEmpty()) {
                    stack.add(s);
                    continue;
                }
                while(!stack.isEmpty() && (stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals("/") ||
                stack.get(stack.size()-1).equals("+") || stack.get(stack.size()-1).equals("-"))) {
                    bw.write(stack.remove(stack.size()-1));
                }
                stack.add(s);
                continue;
            }
            else if(s.equals("*") || s.equals("/")) {
                if(stack.isEmpty()) {
                    stack.add(s);
                    continue;
                }
                while(!stack.isEmpty() && (stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals("/"))) {
                    bw.write(stack.remove(stack.size()-1));
                }
                stack.add(s);
                continue;
            }
            bw.write(s);
        }
        while(!stack.isEmpty()) {
            bw.write(stack.remove(stack.size()-1));
        }
        bw.close();
    }
}

/* 풀이
 * 
 */