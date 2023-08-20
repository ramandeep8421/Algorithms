class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isEnd = false;
    }
}

class MagicDictionary {
    TrieNode root;

    MagicDictionary() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    void buildDict(List<String> dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    boolean searchHelper(String word, TrieNode node, int index, boolean isReplaced) {
        if (index >= word.length()) {
            return node.isEnd && isReplaced;
        }

        TrieNode curr = node;
        int curIndex = word.charAt(index) - 'a';
        boolean res = false;

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                if (curIndex == i) {
                    res = searchHelper(word, curr.children[i], index + 1, isReplaced);
                } else if (!isReplaced) {
                    res = searchHelper(word, curr.children[i], index + 1, true);
                }
            }
            if (res) {
                return true;
            }
        }

        return res;
    }

    boolean search(String searchWord) {
        return searchHelper(searchWord, root, 0, false);
    }
}
