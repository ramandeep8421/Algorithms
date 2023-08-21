import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    
    TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

public class Solution {
    TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c) && Character.isUpperCase(c)) {
                return false;
            }

            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            }
        }
        return cur.isEnd;
    }
    
    public List<Boolean> camelMatch(List<String> queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        insert(pattern);
        
        for (String query : queries) {
            res.add(search(query));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> queries = new ArrayList<>(Arrays.asList("FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"));
        String pattern = "FB";
        List<Boolean> result = solution.camelMatch(queries, pattern);
        
        for (boolean val : result) {
            System.out.println(val);
        }
    }
}
