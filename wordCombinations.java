import java.util.*;

class WordCombinations{
   
    static int[][] trie = new int[5000005][27];
    static boolean[] isEnd = new boolean[5000005];
    static int counter = 0;
    static int[] dp = new int[5000005];
    int MOD = 100000007;

    static String s;
  
     //Function to insert a word in trie
     void insert(String str){
         int curr = 0;
         System.out.println("Hello");
         int n = str.length();
         for(int i=0;i<n;i++){
           if(trie[curr][str.charAt(i)-'a'] == 0)trie[curr][str.charAt(i)-'a'] = ++counter;
           curr = trie[curr][str.charAt(i)-'a'];
         }
         isEnd[curr]=true;
    }

//Function to search for a word in a trie
    int wordCombinations(int index){
         if(index == s.length()){
           System.out.println(s.length());
           return dp[s.length()]=1;
         }

         int node = 0;
         int ans=0;

         for(int i=index;i<s.length();i++){
              if(trie[node][s.charAt(i)-'a']==0)return dp[index]=ans;
              node = trie[node][s.charAt(i)-'a'];
              if(isEnd[node]){
                   if(dp[i+1] != -1)ans = (ans + dp[i+1])%MOD;
                   else ans = (ans + search(i+1))%MOD;
              }
         }

         return dp[index] = ans;
    }
   
  
   

     //Driver code
     public static void main(String args[]){
             Scanner myObj = new Scanner(System.in);
           
       int k;
             s = myObj.nextLine();
             k = myObj.nextInt();
       WordCombinations wc = new WordCombinations();
       System.out.println(k);
       for(int i=0;i<=k;i++){
            String str = myObj.nextLine();

            wc.insert(str);
       }
       Arrays.fill(dp, -1);
       Arrays.fill(isEnd,false);
       dp[0] = wc.search(0);

             System.out.println(wc.search(0));
     }
}
