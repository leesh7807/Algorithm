import java.io.*;
import java.math.BigInteger;
public class j8437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());
        System.out.println(N.add(diff).divide(BigInteger.valueOf(2)));
        System.out.println(N.add(N.add(diff).divide(BigInteger.valueOf(2)).negate()));
    }
}
