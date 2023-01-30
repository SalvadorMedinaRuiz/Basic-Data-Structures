import java.util.*;
import java.io.*;

public class StackWithMax {
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

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        
        Stack<Integer> maxValue = new Stack<Integer>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
                //////////////////////// Method 1
                /*
                if (maxValue.pop() < value) {
                	maxValue.push(value);
                }
                else {
                	maxValue.push(value);
                }
                */
                //////////////////////// Method 2
                if (stack.size() == 1) {
                	maxValue.push(value);
                }
                
                if (value > maxValue.peek()) {
                	maxValue.push(value);
                }
                else {
                	maxValue.push(maxValue.peek());
                }
                ////////////////////////
                
                //////////////////////// Method 3
                /*
                maxValue.push(value);
                for (int i = 0; i < maxValue.size(); i++) {
                	if (maxValue.pop() < value) {
                		maxValue.push(value);
                	}
                }
                */
                ////////////////////////
            } else if ("pop".equals(operation)) {
            	maxValue.pop();
            	stack.pop();
            	/*
                stack.pop();
                ///////////////
                maxValue.pop();
                ///////////////
                */
            } else if ("max".equals(operation)) {
            	//code here
                System.out.println(maxValue.peek());
                
                //create a stack to keep track of max. after each  pop and push. Collections.max(maxValue)
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
