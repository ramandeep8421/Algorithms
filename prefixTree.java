public class Trie {

    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return true;
    }
}
