import java.util.*;

class findingBorders{
   
    //Preprocess the LPS table
    void preprocessLPSTable(String pat, int lps[]){
         int len=0;
         int i=1;
         lps[0]=0;
         int m = pat.length();
         while(i < m){
             if(pat.charAt(i) == pat.charAt(len)){
                  len++;
                  lps[i]=len;
                  i++;
             }else{
                 if(len == 0){
                     lps[i]=len;
                     i++;
                 }else{
                     len = lps[len-1];
                 }
             }
         }
    }
   

     //Driver code
     public static void main(String args[]){
             Scanner myObj = new Scanner(System.in);

             String pat = myObj.nextLine();

             int m = pat.length();

             int pi[] = new int[m];
            
             
             new findingBorders().preprocessLPSTable(pat,pi);


             int j = pi[m-1];
            
             ArrayList<Integer> result=new ArrayList<>();


             while(j > 0){
                 result.add(j);
                 j = pi[j-1];
             }

             Collections.sort(result);

             int n = result.size();

             for(int i=0;i<n;i++)
                  System.out.println(result.get(i) + " ");

     }
}
