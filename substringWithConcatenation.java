import java.util.*;

public class SubstringWithConcactenation {
    // Declare a global hashmap for <word, int> pair
    HashMap<String, Integer> mp;

    // Declare the word length, substringSize and length of each word in given words dictionary
    int wordLength, substringSize, k;

    // Function to check if the substring starting at i is a valid substring or not
    boolean check(int i, String s) {
        // First copy the given hashmap into the temporary map
        HashMap<String, Integer> dict = new HashMap<String, Integer>(mp);

        // It represents the number of words used in the given concatenation of words
        int wordsUsed = 0;

        // Start from index i and check for the substrings of length substringSize
        for (int j = i; j < i + substringSize; j += wordLength) {
            // Find the first substring starting from i with length of wordLength
            String sub = s.substring(j, j + wordLength);

            if (dict.containsKey(sub) && dict.get(sub) > 0) {
                dict.put(sub, dict.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }

        return wordsUsed == k;
    }

    int[] findSubstring(String s, String[] words) {
        // Size of the string
        int n = s.length();

        // Size of the words array
        k = words.length;

        // Find the length of the word in the dictionary
        wordLength = words[0].length();

        // Find the substring size
        substringSize = wordLength * k;

        // Build the hashmap for the given global map mp;
        mp = new HashMap<String, Integer>();
        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        // Declare an answer array
        List<Integer> answerList = new ArrayList<Integer>();

        // Iterate over all the indices of the given string
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                answerList.add(i);
            }
        }

        // Convert List to array
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
