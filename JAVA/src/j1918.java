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

/* 후위 표기식으로 바꾸는 법. 
 * 피연산자는 그대로 출력한다.
 * 스택이 비어있으면 연산자를 담는다.
 * 스택이 비어있지 않으면, 새로운 연산자보다 우선순위가 낮은 연산자를 만날 때 까지 스택에서 꺼내 출력하고 새 연산자를 담는다.
 * 여는 괄호는 스택에 담는다. 닫는 괄호를 만나면 여는 괄호가 스택에서 나올 때 까지 스택에서 꺼내 출력한다.
 */