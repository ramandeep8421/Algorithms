class Pair{
     int distance, node;
     
     Pair(int distance, int node){
          this.distance = distance;
          this.node = node;
     }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
     static int[] dijkstra(int N, ArrayList<ArrayList<ArrayList<Integer>>>adj, int src){
            
               int [] distance  = new int[N];
               
               int INF = 1000000000;
               for(int i=0;i<N;i++)distance[i] = INF;
               
               distance[src] = 0;
               
              PriorityQueue<Pair>pq = new PriorityQueue<>((x,y) -> x.distance -  y.distance);
              
              pq.add(new Pair(0,src));
              
              while(!pq.isEmpty()){
                    
                    int dist = pq.peek().distance;
                    int node = pq.peek().node;
                    
                    pq.remove();
                    
                    if(distance[node] < dist)continue;
                    
                    
                    for(int i=0; i < adj.get(node).size(); i++){
                          int edgeWeight = adj.get(node).get(i).get(1);
                          int adjNode = adj.get(node).get(i).get(0);
                          
                          if(distance[adjNode] > dist + edgeWeight){
                                distance[adjNode] = dist + edgeWeight;
                                pq.add(new Pair(distance[adjNode], adjNode));
                          }
                    }
              }
              
              return distance;
               
            
        }
};
