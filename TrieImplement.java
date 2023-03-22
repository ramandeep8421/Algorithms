import java.util.Arrays;

class TrieNode {
    boolean isCompleteWord;
    TrieNode[] children;

    TrieNode() {
        isCompleteWord = false;
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
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isCompleteWord = true;
    }

    boolean search(String word) {
        return searchHelper(word, root);
    }

    boolean searchHelper(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchHelper(word.substring(i+1), child)) {
                        return true;
                    }
                }
                return false;
            }

            int idx = c - 'a';

            if (node.children[idx] == null) {
                return false;
            }

            node = node.children[idx];
        }

        return node.isCompleteWord;
    }
}

  

   

    
   
