import java.util.*;

public class List {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(10);
        arr.add(1);
        arr.add(2);
        System.out.println(arr);
        arr.add(2);
        // arr.remove(2);
        System.out.println(arr);
        Iterator i = arr.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}