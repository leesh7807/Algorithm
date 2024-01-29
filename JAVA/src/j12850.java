import java.io.*;
class j12850 {
    static long MOD = 10_0000_0007L;
    static long[][] mat = {
        {0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 1},
        {0, 1, 0, 1, 0, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 1, 1, 0, 1, 0, 1},
        {1, 1, 1, 0, 0, 0, 1, 0}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        long[][] ans = pow(D);
        System.out.println(ans[0][0]);
    }
    static long[][] pow(int n) {
        if(n == 1) {
            return mat;
        }
        long[][] temp = pow(n / 2);
        temp = matMult(temp, temp);
        if(n % 2 == 1) {
            temp = matMult(temp, mat);
        }
        return temp;
    }
    static long[][] matMult(long[][] mat1, long[][] mat2) {
        long[][] ret = new long[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat2[0].length; j++) {
                for(int k = 0; k < mat1[0].length; k++) {
                    ret[i][j] = (ret[i][j] + mat1[i][k] * mat2[k][j]) % MOD;
                }
            }
        }
        return ret;
    }
}

/* AA AB
 * BA BB
 * 2 x 2 인접행렬을 제곱하면
 * AAAA+ABBA AAAB+ABBB
 * BAAA+BBBA BAAB+BBBB
 * i에서 다른 곳을 경유해 j로 가는 모든 경우의 수가 된다.
 * 즉, 인접행렬의 지수는 경유하는 곳의 개수
 */