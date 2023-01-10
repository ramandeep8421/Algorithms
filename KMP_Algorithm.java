import java.util.*;

class KMP{
   
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
   
    //Search for the pattern pat in the text txt
    int KMPSearch(String txt, String pat){
         int n = txt.length();
         int m = pat.length();

         int lps[] = new int[m];
         int j=0;

         preprocessLPSTable(pat,lps);
         int cnt=0;
         int i=0;

         while((n-i) >= (m-j)){
         	  if(pat.charAt(j) == txt.charAt(i)){
         	  	 i++;
         	  	 j++;
         	  }
         	  if(j == m){
         	  	 System.out.println("Pattern found at " + (i-j));
         	  	 cnt++;
         	  	 j = lps[j-1];
         	  }else if(i < n && pat.charAt(j) != txt.charAt(i)){
         	  	   if(j == 0){
         	  	      i++;
         	  	   }else{
         	  	       j = lps[j-1];
         	  	   }
         	  }
         }
         
         return cnt;
    }

   

	//Driver code
	public static void main(String args[]){
		   Scanner myObj = new Scanner(System.in);
		   String text, pattern;
		   text = myObj.nextLine();
		   pattern = myObj.nextLine();
		   System.out.println(new KMP().KMPSearch(text,pattern));
	}
}
