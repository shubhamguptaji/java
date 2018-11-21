import java.util.*;

public class merge_k_sorted_list {
    
    public static LinkedList<Integer> mergeLists(LinkedList[] list) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i=0;i<list.length;i++)  {
            for(int j=0;j<list[i].size();j++) {
                // System.out.println(list[i].get(j));
                p.add((int)(list[i].get(j)));
                // System.out.println(p.poll());
            }
        }
        LinkedList<Integer> l = new LinkedList<>();
        Object[] arr = p.toArray();
        Arrays.sort(arr);
        System.out.println(p.size());
        for(int i=0;i<arr.length;i++) {
            // System.out.println(i + " " + arr[i] + " " + p.poll());
            l.add((int)(arr[i]));
            // p.remove();
            // p.remove(p.peek());
        }
        return l;
        
    }

    public static void main(String[] args) {
        int k = 3;
        LinkedList<Integer>[] lists = new LinkedList[k];
        for(int i=0;i<k;i++)
            lists[i] = new LinkedList<>();
        lists[0].add(1);
        lists[0].add(10);
        lists[0].add(20);
        lists[1].add(4);
        lists[1].add(11);
        lists[1].add(13);
        lists[2].add(3);
        lists[2].add(8);
        lists[2].add(9);
        LinkedList<Integer> res = mergeLists(lists);
        System.out.println(res);

    }
}