import java.util.*;
import java.io.*;
import java.lang.*;


class Solution{
    
    
    public static dfsCycle(int node, ArrayList<ArrayList<int>>adj, int vis[], int stackRec[]){
          
           vis[node] = 1;
           stackRec[node]=1;
           
           for(Integer neighbor: adj.get(node)){
                 if(vis[neighbor] == 0){
                       if(dfsCycle(neighbor, adj,vis,stackRec)){
                            return true;
                       }
                 }else if(stackRec[neighbor] == 1){
                      return true;
                 }
           }
           
           stackRec[node]=0;
           
           return false;
            
    }
    
    public static isCycle(int N, ArrayList<ArrayList<Integer>>adj){
         int vis[] = new int[N];
         int stackRec[] = new int[N];
         
         
         for(int i=0;i<N;i++){
              if(vis[i] == 0){
                    if(dfsCycle(i, adj, vis, stackRec)){
                        return true;
                    }
              }
         }
         
         return false;
    }
}
