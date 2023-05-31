import java.util.*;
import java.awt.Point;
public class SortTest {
    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(1, 2));
        list.add(new Point(2, 3));
        list.add(new Point(2, 1));
        list.add(new Point(0, 1));
        list.sort(new Comparator<Point>(){
            public int compare(Point a, Point b) {
                if(a.x == b.x) {
                    return Integer.valueOf(a.y).compareTo(Integer.valueOf(b.y));
                }
                return Integer.valueOf(a.x).compareTo(Integer.valueOf(b.x));
            }
        });
        System.out.println(list);

        ArrayList<Pair> list2 = new ArrayList<>();
        list2.add(new Pair(1, 2));
        list2.add(new Pair(2, 3));
        list2.add(new Pair(2, 1));
        list2.add(new Pair(0, 1));
        list2.sort(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                if(a.getX() == b.getX()) {
                    return Integer.valueOf(a.getY()).compareTo(Integer.valueOf(b.getY()));
                }
                return Integer.valueOf(a.getX()).compareTo(Integer.valueOf(b.getX()));
            }
        });
        System.out.println(list2);
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x;}
        public int getY() { return y;}

        @Override
        public String toString() {
            return String.format("Pair[%d, %d]", this.x, this.y);
        }
    }
}