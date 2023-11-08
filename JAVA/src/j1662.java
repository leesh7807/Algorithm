import java.io.*;
import java.util.*;
public class j1662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> stack = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            String subString = Character.toString(s.charAt(i));
            if(subString.equals(")")) {
                long length = 0;
                while(!stack.get(stack.size()-1).equals("(")) {
                    long temp = Long.parseLong(stack.remove(stack.size()-1));
                    if(temp >= 10) {
                        length += temp-10;
                    } 
                    else {
                        length++;
                    }
                }
                stack.remove(stack.size()-1); // '(' 제거
                long repeat = Integer.parseInt(stack.remove(stack.size()-1));
                stack.add(Long.toString(repeat * length + 10));
            }
            else {
                stack.add(subString);
            }
        }
        int result = 0;
        while(!stack.isEmpty()) {
            long temp = Long.parseLong(stack.remove(stack.size()-1));
            if(temp >= 10) {
                result += temp-10;
            }
            else {
                result++;
            }
        }
        System.out.println(result);
    }
}
