import java.io.*;
public class j5639 {
    static int[] arr = new int[10000];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        String sNode = new String();
        while((sNode = br.readLine()) != null) {
            arr[idx] = Integer.parseInt(sNode);     
            idx++;
        }
        postOrder(0, idx - 1);
    }
    public static void postOrder (int root, int end) {
        if(root > end) return;
        // 왼쪽 트리와 오른쪽 트리를 구분하는 과정
        int start = root+1;
        int mid = start;
        while(mid <= end && arr[mid] < arr[root]) {
            mid++;
        }
        // 후위 탐색
        postOrder(start, mid-1);
        postOrder(mid, end);
        System.out.println(arr[root]);
    }
}
/* 첫 노드는 루트
 * 전위 탐색한 결과이므로, 루트보다 큰 노드가 들어오기 까지는 왼쪽 서브트리
 * 루트보다 큰 노드부터는 오른쪽 서브트리
 * 서브트리를 재귀적으로 탐색하면 후위탐색의 결과를 출력할 수 있다.
 */