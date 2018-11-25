import java.util.*;

public class colourfulNumbers {
    public static boolean pair(int a) {
        int count =0;
        int temp = a;
        while(temp>0) {
            count++;
            temp /=10;
        }
        temp = a;
        System.out.println(count);
        int[] res =new int[count];
        int m=0;
        while(temp>0) {
            res[m++] = temp % 10; 
            temp /=10;
        }
        // for(int i=0;i<count;i++)
        //     System.out.println(res[i]);
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<count-1;i++) {
        //     int t=0;
        //     for(int j=0;j<count;j++) {
        //         t *= res[j];
        //     }
        //     System.out.println(t);
        //     if(map.get(t)!=null)
        //         return false;
        //     map.put(t, 1);
        // }
        // return true;
        for(int i=0;i<count-1;i++) {
            for(int j=0;j<=i+1;j++) {
                int t = 1;
                for(int k=i;k<=j;k++) 
                    t *= res[k];
                System.out.println(t);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // pair(3245);
        System.out.println(pair(3245));
    }
}