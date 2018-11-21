import java.util.*;
import java.lang.Math;
public class magician_and_chocolates {

    public static int func(int k, int[] a) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<a.length;i++)
            p.add(a[i]);
        int res = 0;
        for(int i=0;i<k;i++) {
            int temp = p.peek();
            res += temp;
            p.remove(p.peek());
            p.add(temp/2);
            res = res % 1000000007;
        }
        return res;


    }

    public static void main(String[] args) {
    int[] a = {2147483647, 2000000014, 2147483647};
    int k =10;
    int temp = func(k,a);
    System.out.println(temp);
    }
}