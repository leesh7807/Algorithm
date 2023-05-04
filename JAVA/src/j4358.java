import java.io.*;
import java.util.*;

public class j4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<String, Double> map = new TreeMap<>();
        String tree;
        while((tree = br.readLine()) != null) {
            map.put(tree, map.getOrDefault(tree, 0.0) + 1.0);
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