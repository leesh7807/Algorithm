import java.io.*;
import java.util.*;
public class j1106 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goalCustomer = Integer.parseInt(st.nextToken());
        int countOfCities = Integer.parseInt(st.nextToken());
        int[][] costAndCustomer = new int[countOfCities][2];
        for(int i=0; i<countOfCities; i++) {
            st = new StringTokenizer(br.readLine());
            costAndCustomer[i][0] = Integer.parseInt(st.nextToken());
            costAndCustomer[i][1] = Integer.parseInt(st.nextToken());
        }
        Hotel hotel = new Hotel(goalCustomer, costAndCustomer);
        System.out.println(hotel.minimizeCost());
    }
    static class Hotel {
        int goalCustomer;
        int[][] costAndCustomer;
        int[] minCostAtSpecificCustomer;
        public Hotel(int goalCustomer, int[][] costAndCustomer) {
            this.goalCustomer = goalCustomer;
            this.costAndCustomer = costAndCustomer;
            minCostAtSpecificCustomer = new int[goalCustomer+1];
        }
        public int minimizeCost() {
            for(int i=1; i<=goalCustomer; i++) {
                int minAtI = Integer.MAX_VALUE;
                for(int j=0; j<costAndCustomer.length; j++) {
                    int cost = costAndCustomer[j][0];
                    int gettingCustomer = costAndCustomer[j][1];
                    if(i-gettingCustomer < 0) minAtI = Math.min(minAtI, cost); 
                    else {
                        minAtI = Math.min(minCostAtSpecificCustomer[i-gettingCustomer] + cost, minAtI);
                    }
                }
                minCostAtSpecificCustomer[i] = minAtI;
            }
            return minCostAtSpecificCustomer[goalCustomer];
        }
    }
}
