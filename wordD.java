class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
        Arrays.fill(children, null);
    }
}

class WordDictionary {
    TrieNode root;

    WordDictionary() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isEnd = true;
    }

    boolean search(String word) {
        return searchHelper(word, root);
    }

    boolean searchHelper(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchHelper(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }

            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }

        return node.isEnd;
    }
}
