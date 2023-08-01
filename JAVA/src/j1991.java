import java.io.*;
import java.util.*;
public class j1991 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Child>> tree = new ArrayList<>();
        for(int n=0; n<N; n++) {
            tree.add(new ArrayList<Child>());
        }
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int mid = (int)st.nextToken().toCharArray()[0] - 65;
            int left = (int)st.nextToken().toCharArray()[0] - 65;
            int right = (int)st.nextToken().toCharArray()[0] - 65;
            tree.get(mid).add(new Child(left, right));
        }
        String preorder = preorder(0, "", tree);
        String inorder = inorder(0, "", tree);
        String postorder = postorder(0, "", tree);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
    public static String preorder(int node, String ret, ArrayList<ArrayList<Child>> tree) {
        Child c = tree.get(node).get(0);
        ret += (char)(node + 65);
        if(c.left >= 0) {
            ret = preorder(c.left, ret, tree);
        }
        if(c.right >= 0) {
            ret = preorder(c.right, ret, tree);
        }
        return ret;
    }
    public static String inorder(int node, String ret, ArrayList<ArrayList<Child>> tree) {
        Child c = tree.get(node).get(0);
        if(c.left >= 0) {
            ret = inorder(c.left, ret, tree);
        }
        ret += (char)(node + 65);
        if(c.right >= 0) {
            ret = inorder(c.right, ret, tree);
        }
        return ret;
    }
    public static String postorder(int node, String ret, ArrayList<ArrayList<Child>> tree) {
        Child c = tree.get(node).get(0);
        if(c.left >= 0) {
            ret = postorder(c.left, ret, tree);
        }
        if(c.right >= 0) {
            ret = postorder(c.right, ret, tree);
        }
        ret += (char)(node + 65);
        return ret;
    }
    static class Child {
        int left, right;
        public Child (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
