import java.util.*;

class Solution {
     
     public int ladderLength(String beginWord, String endWord, List<String> wordList){
             //queue to hold the nodes 
             Queue<Pair<String,Integer>> qu = new LinkedList<>();
             
             qu.add(new Pair<>(beginWord, 1));

             //declare the hashmaps
             Map<String,Integer> mp = new HashMap<>();
             Map<String,Boolean> visited = new HashMap<>();

             //Iterate over the wordList and mark them in the mp
             for(String word : wordList) {
                mp.put(word, 1);
             }

             while(!qu.isEmpty()){
                 //Size of the queue
                int n = qu.size();

                //Iterate n times
                while(n--){

                     Pair<String,Integer> ptr = qu.remove();

                     //current word
                     String currWord = ptr.getKey();

                     if(currWord.equals(endWord)) {
                        return ptr.getValue();
                  }

                     visited.put(currWord, true);

                     for(int i = 0; i < currWord.length(); i++){
                         char org_char = currWord.charAt(i);

                         for(char c = 'a'; c <= 'z'; c++){
                               char[] arr = currWord.toCharArray();
                               arr[i] = c;
                               String newWord = new String(arr);
                               if(!visited.containsKey(newWord) && mp.containsKey(newWord)){
                                   qu.add(new Pair<>(newWord, ptr.getValue() + 1));
                                   visited.put(newWord, true);
                               }
                         }
                         arr[i] = org_char;
                     }
                }
             }

             return 0;
     }
}
