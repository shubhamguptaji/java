import java.util.*;
class bag implements Iterable<Integer> {
    Node first;
    Node last;
    private class Node {
        private int data;
        Node next;
        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }
    public void enque(int i) {
        Node temp = new Node(i);
        if(last==null) {
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            last = temp;
        }

    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = first;
            
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Integer next() {
                int temp = current.data;
                current = current.next;
                return temp;
            }
            @Override
            public void remove() {
                
            }
        };
    }
}
public class graph {
    int v;
    bag[] adj;

    graph(int v) {
        this.v = v;
        adj =  new bag[v];
        for(int i=0;i<v;i++) {
            adj[i] = new bag();
        }
    }

    void addEdge(int v, int w) {
        adj[v].enque(w);
        if(v!=w)
            adj[w].enque(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    int degree(int v) {
        int count =0;
        for(int w: this.adj(v))
            count++;
        return count;
    }

    public static void main(String[] args) {
        graph g = new graph(14);
        g.addEdge(0,0);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(3,4);
        g.addEdge(4,6);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(11, 12);
        g.addEdge(7,8);
        // for(int i=0;i<g.adj[0];)
        System.out.println(g.degree(5));
    }
}