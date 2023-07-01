// Java program to print Euler tour of a
// tree.
import java.util.*;

class GFG{

static final int MAX = 1001;
static int index = 0;

// Adjacency list representation of tree
static ArrayList<
	ArrayList<Integer>> adj = new ArrayList<>();

// Visited array to keep track visited
// nodes on tour
static int vis[] = new int[MAX];

// Array to store Euler Tour
static int Euler[] = new int[2 * MAX];

// Function to add edges to tree
static void add_edge(int u, int v)
{
	adj.get(u).add(v);
	adj.get(v).add(u);
}

// Function to store Euler Tour of tree
static void eulerTree(int u)
{
	vis[u] = 1;
	Euler[index++] = u;
	
	for(int it : adj.get(u))
	{
		if (vis[it] == 0)
		{
			eulerTree(it);
			Euler[index++] = u;
		}
	}
}

// Function to print Euler Tour of tree
static void printEulerTour(int root, int N)
{
	eulerTree(root);
	for(int i = 0; i < (2 * N - 1); i++)
		System.out.print(Euler[i] + " ");
}

 
}

// This code is contributed by jrishabh99
