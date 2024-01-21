import java.io.*;
import java.util.*;
class j2263 {
    static int N;
    static int[] inorder;
    static int[] postorder;
    static ArrayList<Pair> tree = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        inorder = new int[N];
        postorder = new int[N];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { 
            inorder[i] = Integer.parseInt(st.nextToken());
            postorder[i] = Integer.parseInt(st2.nextToken());
        }
        for(int i = 0; i <= N; i++) {
            tree.add(new Pair(-1, -1));
        }
        int root = search(0, N - 1, 0, N - 1);
        printPreorder(root);
        bw.close();
    }
    static int search(int in, int inEnd, int post, int postEnd) {
        if(inEnd < in) { // 서브 트리 존재 x
            return -1;
        }
        if(inEnd - in == 0) { // 혼자 있음.
            return inorder[in];
        }
        else if(inEnd - in == 1) { // 부모와 노드 하나
            if(inorder[in] == postorder[post]) { // 왼 -> 중, 왼 -> 중
                tree.get(inorder[inEnd]).left = inorder[in];
                return inorder[inEnd];
            }
            else { // 중 -> 오, 오 -> 중
                tree.get(inorder[in]).right = postorder[post];
                return inorder[in];
            }
        }
        else { // 그 외 서브 트리
            ArrayList<Integer> parents = new ArrayList<>(); //  서브트리 제일 왼쪽 라인의 부모노드를 스택
            int p1 = in;
            int p2 = post;
            int length = 0; // 트리 탐색 길이
            while(p1 + length <= inEnd) { // 서브트리 찾기
                if(inorder[p1] == postorder[p2 + length]) {
                    parents.add(inorder[p1]);
                    tree.get(inorder[p1]).right = search(p1 + 1, p1 + length, p2, p2 + length - 1); // 왼쪽 부모노드에서 오른쪽으로 파생되는 서브트리 탐색.
                    p1 = p1 + length + 1;
                    p2 = p2 + length + 1;
                    length = -1;
                }
                length++;
            }
            int rootParent = parents.remove(parents.size() - 1);
            int prevParent = rootParent;
            while(!parents.isEmpty()) {
                int childParent = parents.remove(parents.size() - 1);
                tree.get(prevParent).left = childParent;
                prevParent = childParent;
            }
            return rootParent;
        }
    }
    static class Pair {
        int left, right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static void printPreorder(int root) throws IOException {
        bw.write(Long.toString(root) + " ");
        int left = tree.get(root).left;
        int right = tree.get(root).right;
        if(left != -1) {
            printPreorder(left);
        }
        if(right != -1) {
            printPreorder(right);
        }
    }
}

// inorder 4 2 5 1 6 3 7
// postorder 4 5 2 6 7 3 1
// preorder 1 2 4 5 3 6 7