import java.util.Arrays;
import java.util.Comparator;

// package ADI;

class struct {
    int count;
    int index;

    struct(int i) {
        count = 0;
        index = i;
    }

    public String toString() {
        return "\ncount: " + count + "index: " + index;
    }
}

class CompareCount implements Comparator<struct> {
    public int compare(struct a, struct b) {
        if (a.count == b.count)
            return 0;
        else if (a.count > b.count)
            return -1;
        else
            return 1;
    }
}

class Trie {
    Trie[] arr;
    boolean isEndOfWord;
    int count;

    Trie() {
        this.arr = new Trie[26];
        for (int i = 0; i < 26; i++)
            this.arr[i] = null;
        this.isEndOfWord = false;
        this.count = 1;
    }

    void insert(String str) {
        Trie root = this;
        for (int i = 0; i < str.length(); i++) {
            int j = str.charAt(i) - 'a';
            if (root.arr[j] == null)
                root.arr[j] = new Trie();
            else
                root.arr[j].count +=1;
            root = root.arr[j];
        }
        root.isEndOfWord = true;
    }

    void search(String str, int index, String res) {
        Trie root = this;
        if(index>= str.length())
            return;
        int j = str.charAt(index) - 'a';
        if(root.arr[j].count==1)
        {
            res += str.charAt(index);
            System.out.print(str.charAt(index));            
            return;
        }
        else {
            res += str.charAt(index);
            System.out.print(str.charAt(index));
            root.arr[j].search(str, index + 1, res);
        }
    }

    int prefix(String str) {
        Trie root = this;
        for(int i=0;i<str.length();i++) {
            int j = str.charAt(i) - 'a';
            if(root.arr[j].count == 1 || root.arr[j]==null)
                return i;
            root = root.arr[j];
        }
        return -1;
    }

    boolean delete(String str, int index) {
        if (index == str.length()) {
            if (!this.isEndOfWord)
                return false;
            this.isEndOfWord = true;
            for (int i = 0; i < 26; i++)
                if (this.arr[i] != null)
                    return false;
            return true;
        }
        int j = str.charAt(index) - 'a';
        if (this.arr[j] == null)
            return false;
        boolean var = this.arr[j].delete(str, index + 1);
        if (var) {
            this.arr[j] = null;
            if (this.isEndOfWord)
                return false;
            else {
                for (int i = 0; i < 26; i++)
                    if (this.arr[i] != null)
                        return false;
                return true;
            }
        }
        return true;
    }

    static void solution(String a, String[] b) {
        String[] res = a.split("_");
        Trie o = new Trie();
        for (String i : res)
            o.insert(i);
        struct[] st = new struct[b.length];
        for (int j = 0; j < b.length; j++) {
            String sp[] = b[j].split("_");
            st[j] = new struct(j);
            for (String p : sp) {
                if (o.search(p, 0))
                    st[j].count++;
            }
        }

        Arrays.sort(st, new CompareCount());

        for (struct i : st)
            System.out.println(i.count + " " + i.index);
        // System.out.println(st[2].count);
    }

    public static void main(String[] args) {
        String a = "cool_ice_wifi";
        String[] b = new String[] { "water_is_cool", "wifi", "cold_ice_drink", "cool_wifi_speed", "cool_ice_wifi_jaihind_cool" };
        // solution(a, b);
        Trie o = new Trie();
        String[] str = {"zebra", "dog", "dove", "duck"};
        o.insert("zebra");
        o.insert("dog");
        o.insert("dove");
        o.insert("duck");
        for(int j=0; j<str.length;j++) {
            int z = o.prefix(str[j]);
            for(int i=0;i<=z;i++)
                System.out.print(str[j].charAt(i));
            System.out.println();
        }
        // String str = "";
        // o.search("hell", 0, str);
        // System.out.println(str);
    }
}