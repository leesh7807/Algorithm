import java.io.*;
public class j11444 {
    static int modStand =  1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {1, 0}};
        if(n == 1L) System.out.println(1);
        else System.out.println(matrixSqrt(A, n-1L)[0][0]);
    }
    public static long[][] matrixSqrt(long[][] A, long exp) {
        if(exp == 1) {
            return A;
        }
        if(exp % 2 == 0) {
            long[][] temp = matrixSqrt(A, exp/2);
            long[][] ret = new long[temp.length][temp.length];
            for(int i=0; i<ret.length; i++) {
                for(int j=0; j<ret.length; j++) {
                    for(int k=0; k<ret.length; k++) {
                        ret[i][j] += (temp[i][k] % modStand) * (temp[k][j] % modStand) % modStand;
                        ret[i][j] %= modStand;
                    }
                }
            }
            return ret;
        }
        else {
            long[][] temp = matrixSqrt(A, exp/2);
            long[][] ret = new long[temp.length][temp.length];
            for(int i=0; i<ret.length; i++) {
                for(int j=0; j<ret.length; j++) {
                    for(int k=0; k<ret.length; k++) {
                        ret[i][j] += (temp[i][k] % modStand) * (temp[k][j] % modStand) % modStand;
                        ret[i][j] %= modStand;
                    }
                }
            }
            long[][] ret2 = new long[temp.length][temp.length];
            for(int i=0; i<ret.length; i++) {
                for(int j=0; j<ret.length; j++) {
                    for(int k=0; k<ret.length; k++) {
                        ret2[i][j] += (ret[i][k] % modStand) * (A[k][j] % modStand) % modStand;
                        ret2[i][j] %= modStand;
                    }
                }
            }
            return ret2;
        }
    }
}
/* 피보나치 수는 행렬로 다음과 같이 표현될 수 있다.
 * [Fn + 1  = [1  1 ^n [1
 *    Fn  ]    1  0]    0]
 * 따라서 이 문제는 행렬의 제곱 문제로 바꿀 수 있다. => 10830번 문제
 * https://st-lab.tistory.com/252
 * https://www.acmicpc.net/blog/view/28
 */