import java.io.*;
import java.util.*;
public class j1759 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int listLength = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        char[] list = new char[listLength];
        for(int i=0; i<listLength; i++) {
            list[i] = st.nextToken().charAt(0);
        }
        Crypt crypt = new Crypt(length, list);
        String ans = crypt.createCrypt();
        System.out.println(ans);
    }
    static class Crypt {
        int length;
        char[] list;
        StringBuilder sb;
        ArrayList<Character> stack;
        public Crypt(int length, char[] list) {
            this.length = length;
            this.list = list;
            Arrays.sort(list);
            sb = new StringBuilder();
            stack = new ArrayList<>();
        }
        public String createCrypt() {
            dfs(0, 0, 0);
            return sb.toString();
        }
        private void dfs(int idx, int vowels, int consonants) {
            if(stack.size() >= length) {
                if(vowels >= 1 && consonants >= 2) {
                    for(char c : stack) {
                        sb.append(c);
                    }
                    sb.append('\n');
                    return;
                }
                else return;
            }
            for(int i=idx; i<list.length; i++) {
                stack.add(list[i]);
                if(list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u') {
                    dfs(i+1, vowels+1, consonants);
                }                
                else {
                    dfs(i+1, vowels, consonants+1);
                }
                stack.remove(stack.size()-1);
            }
        }
    }
}
