public class TrieTree {
    TrieTree[] tree;
    boolean endOfWord;
    TrieTree() {
        this.tree = new TrieTree[26];
        for(int i=0;i<26;i++)
            this.tree[i] = null;
        this.endOfWord = false;
    }

    void insert(String str) {
        TrieTree root  = this;
        for(int i=0;i<str.length();i++) {
            int j = str.charAt(i) - 'a';
            if(root.tree[j] == null)
                root.tree[j] = new TrieTree();
            root = root.tree[j];
        }
        root.endOfWord = true;
    }

    boolean search(String str) {
        TrieTree root = this;
        for(int i=0;i<str.length();i++) {
            int j = str.charAt(i) - 'a';
            if(root.tree[j]==null)
                return false;
            root = root.tree[j];
        }
        return root!= null && root.endOfWord;
    }

    boolean delete(String str, int index) {
        if(index == str.length())
        {
            if(this.endOfWord==false)
                return false;
            this.endOfWord = true;
            for(int i=0;i<26;i++)
                if(this.tree[i] != null)
                    return false;
            return true;
        }
        int j = str.charAt(index) - 'a';
        if(this.tree[j]==null)
            return false;
        boolean temp = this.tree[j].delete(str, index+1);
        if(temp==true) {
            this.tree[j] = null;
            if(this.endOfWord == true)
                return false;
            else {
                for(int i=0;i<26;i++)
                    if(this.tree[i] != null)
                        return false;
                return true;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {
        TrieTree root = new TrieTree();
        root.insert("hello");
        root.insert("world");
        System.out.println(root.search("hello"));
        root.delete("hello", 0);
        // System.out.println(root.delete("world", 0));
    }
}