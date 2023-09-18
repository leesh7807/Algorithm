import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class j1082 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] priceOfNum = new int[n];
        for(int i=0; i<n; i++) {
            priceOfNum[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken());
        RoomNum roomNum = new RoomNum(priceOfNum, money);
        System.out.println(roomNum.getMaxNum());
    }   
    static class RoomNum {
        int[] priceOfNum;
        int money;
        public RoomNum(int[] priceOfNum, int money) {
            this.priceOfNum = priceOfNum;
            this.money = money;
        }
        public String getMaxNum() {
            int mostCheapNum = 0;
            for(int i=1; i<priceOfNum.length; i++) {
                if(priceOfNum[i] < priceOfNum[mostCheapNum]) mostCheapNum = i;
            }
            int length = money / priceOfNum[mostCheapNum];
            int restMoney = money - length * priceOfNum[mostCheapNum];
            StringBuilder tempMaxNum = new StringBuilder();
            for(int i=0; i<length; i++) {
                tempMaxNum.append(Long.toString(mostCheapNum));
            }
            char[] maxNum = tempMaxNum.toString().toCharArray();
            boolean changeFlag = false;
            for(int i=0; i<maxNum.length; i++) {
                for(int j=priceOfNum.length-1; j>0; j--) {
                    if(restMoney + priceOfNum[mostCheapNum] >= priceOfNum[j]) {
                        if(maxNum[i] < (char)(j + 48)) {
                            maxNum[i] = (char)(j + 48);
                            restMoney -= priceOfNum[j] - priceOfNum[mostCheapNum];
                            changeFlag = true;
                            break;
                        }
                    }
                }
                if(!changeFlag && mostCheapNum == 0) restMoney += priceOfNum[mostCheapNum];
            }
            BigInteger ret = new BigInteger(new String(maxNum));
            return ret.toString();
        }
    }
}
