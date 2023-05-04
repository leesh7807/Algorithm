import java.io.*;
import java.util.*;

public class j4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        TreeMap<String, Double> map = new TreeMap<>();
        String temp;
        while((temp = br.readLine()) != null) {
            st = new StringTokenizer(temp, "\n");
            String key = st.nextToken();
            if(map.get(key) != null) {
                map.put(key, map.get(key) + 1.0);
            }
            else {
                map.put(key, 1.0);
            }
        }
        double sum = 0;
        for(Double value : map.values()) {
            sum += value;
        }
        for(Map.Entry<String, Double> entry : map.entrySet()) {
            bw.write(entry.getKey() + " " + String.format("%.4f", Math.round(entry.getValue() / sum * 100.0 * 10000.0) / 10000.0) + '\n');
        }
        bw.close();
    }
}
