import java.io.*;
import java.util.*;
class j1111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        if(arr.size() == 1) { // 원소 1개 -> A
            System.out.println("A");
            return;
        }
        boolean isAllSame = true; 
        int sameCheck = arr.get(0);
        for(int i = 1; i < n; i++) { // 1개 초과인데 원소가 모두 같은 경우 -> sameNum
            if(sameCheck != arr.get(i)) {
                isAllSame = false;
                break;
            }
        }        
        if(isAllSame) {
            System.out.println(sameCheck);
            return;
        }
        if(arr.size() < 3) { // 같지 않은 원소 2개 -> A
            System.out.println("A");
            return;
        }
        // 원소가 3개 이상
        int divBy = arr.get(2) - arr.get(1);
        int div = arr.get(1) - arr.get(0);
        if(div == 0) { // 1항과 2항이 같으면 모든 원소가 같아야하는데 이는 위에서 처리함 -> 불가능
            System.out.println("B");
            return;
        }
        if(divBy%div != 0) { // a가 정수가 아닌 경우 -> 불가능
            System.out.println("B");
            return;
        }
        int a = divBy/div;
        int b = arr.get(1) - arr.get(0)*a;
        for(int i = 3; i < n; i++) {
            int expectNum = arr.get(i-1)*a + b;
            int actualNum = arr.get(i);
            if(expectNum != actualNum) {
                System.out.println("B");
                return;
            }
        }
        System.out.println(arr.get(n-1)*a + b);
    }
}

// 1항 = x
// 2항 = xa + b
// 3항 = xa^2 + ba + b
// xa^2 + (2항 - xa)a + 2항 - xa = 3항
// xa^2 + 2항a - xa^2 + 2항 - xa = 3항
// 2항a + 2항 - xa = 3항
// a(2항 - x) = 3항 - 2항
// a = (3항 - 2항)/(2항 - 1항)
// b = 2항 - 1항*a
// a와 b는 정수여야 한다.