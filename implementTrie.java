public class Trie {
    private int[][] trie;
    private boolean[] isEnd;
    private int root;
    private int counter;

    public Trie() {
        root = 0;
        counter = 0;
        trie = new int[200002][26];
        isEnd = new boolean[200002];
        for (int[] row : trie) {
            Arrays.fill(row, 0);
        }
        Arrays.fill(isEnd, false);
    }

    public void insert(String word) {
        int node = root;
        for (char c : word.toCharArray()) {
            if (trie[node][c - 'a'] == 0) {
                trie[node][c - 'a'] = ++counter;
            }
            node = trie[node][c - 'a'];
        }
        isEnd[node] = true;
    }

    public boolean search(String word) {
        int node = root;
        for (char c : word.toCharArray()) {
            if (trie[node][c - 'a'] == 0) {
                return false;
            }
            node = trie[node][c - 'a'];
        }
        return isEnd[node];
    }

    public boolean startsWith(String prefix) {
        int node = root;
        for (char c : prefix.toCharArray()) {
            if (trie[node][c - 'a'] == 0) {
                return false;
            }
            node = trie[node][c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
    }
}
