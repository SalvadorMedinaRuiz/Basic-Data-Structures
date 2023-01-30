import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {//creating an array of integers. 
				parent[i] = in.nextInt();
			}
		}
		// Replace this code with a faster implementation
		int computeHeight() { //VERY SLOW FIX THIS MEHTOD. Method works but needs fixes, maybe add another method to help this one?
			//computes maxheight
			int maxHeight = 0;
			//computes height
			for (int vertex = 0; vertex < n; vertex++) { //The vertex is just the Node position. 
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i]) //calculates the height of a node. For example, node 1 has -1, which is the root, s height is 0 (or 1 idk)
					height++;
				//computes height
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}
	}
	
	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start(); //stack size???
	}
	public void run() throws IOException { //A tree is created. The tree is read then the height is computed.
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
	
	/*///////////////////////NOTES////////////////////////////
	 * The code is multithreading. 
	 * 4, -1, 4, 1, 1.
	 * ^ Every number is a node. The negative in 1 is the root. Index is from 0 to 4, which means 5 nodes!
	 * Node one is the root. Node 4 is the parent of node 0.Node 2's parent is 4, Node's 3 parent is 1 and so is Node 4's parent is also 1.
	 * 
	 * 0 1 2 3 4  [NODES]
	 * 4 -1 4 1 1 [Values]
	*/
	
	/////////////////////////TOO COMPLICATED????//////////////////////////////
	
	static class MyTree{
		
		class FastScanner {
			StringTokenizer tok = new StringTokenizer("");
			BufferedReader in;

			FastScanner() {
				in = new BufferedReader(new InputStreamReader(System.in));
			}

			String next() throws IOException {
				while (!tok.hasMoreElements())
					tok = new StringTokenizer(in.readLine());
				return tok.nextToken();
			}
			int nextInt() throws IOException {
				return Integer.parseInt(next());
			}
		}
		
		MyNode root;
		ArrayList<MyNode> nodes;
		
		static class MyNode{
			int value; //index
			ArrayList<MyNode> children;
		}
		
		//compute height of this tree
		int computeHeight() {
			return computeHeight_inner(root);
		}
		
		//recursive method
		int computeHeight_inner(MyNode node) {
			return 0;
		}
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			int n = in.nextInt();
			//parent = new int[n];
			for (int i = 0; i < n; i++) {//creating an array of integers. 
				//parent[i] = in.nextInt();
				int parentIndex = in.nextInt();
				//figure out how to create a node with i and in.next()
				MyNode node = new MyNode();
				this.nodes.add(node);
				
				if (parentIndex == -1) {
					this.root = node;
				}
			}
		}
	}
	
	public void runFast() throws IOException{
		MyTree tree = new MyTree();
		tree.read();
	}
}
