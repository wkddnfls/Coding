package graph_path;

import java.util.PriorityQueue; 
import java.util.Scanner;
import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;


public class Graph_path {
	private static int INF = 10000000;
	static StringBuilder sb = new StringBuilder();
	static int[] dist;    // ���۳�忡�� �� ������ �ִ� �Ÿ� ���
	static boolean[] check;  // �湮�ߴ��� Ȯ��
	
	private static class Node implements Comparable<Node> { 
		int index; 
		int weight; 
		 
		Node(int index, int weight) { 
			this.index = index;
			this.weight = weight; 
		} 
		@Override 
		public int compareTo(Node o) { 
			return this.weight - o.weight;  
		} 
	}

	private static int djikstra(int[][] graph, int V, int startNode, int endNode) { 
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		
		dist = new int[V+1];
		check = new boolean[V+1];
		
		for (int i=1;i<=V;i++) {
			dist[i] = INF; 
			check[i] = false;
		}
		dist[startNode] = 0;

		
		for (int i = 1; i <= V; i++) {  // ����Ǿ� ���� ��츸 ����.
			if (startNode != i && graph[startNode][i] < INF) { 
				pq.offer(new Node(i, graph[startNode][i])); 
			} 
		} 
		
	    while (!pq.isEmpty()) { 
	    	Node next = pq.poll();   // ť�� ����ִ� ���� �� ���� ����ġ�� ���� �� ã��.
	    	//System.out.println(next.index + ", " + next.weight);
	    	int index = next.index;
	    	int w = next.weight;
	
	    	for (int i = 1; i <= V; i++) { 
	    		if (!check[i] && graph[index][i] != INF && graph[startNode][i] > w + graph[index][i]) { 
	    			graph[startNode][i] = w + graph[index][i]; 
	    			pq.offer(new Node(i, graph[startNode][i]));  
	    			dist[i] = index;
	    		} 
	    	}
	    	check[index] = true;
	    } 
	    
	    // �ִܰŸ� ��� ���ϱ� 
	    BacktrackPath(dist, startNode, endNode);

	    return graph[startNode][endNode];
	}

	private static void BacktrackPath(int[] dist, int startNode, int endNode) {
		Stack<Integer> s = new Stack<Integer>();
		int temp = endNode;
		
		while(temp != INF) {
			s.push(temp);
			temp = dist[temp];
		}
		s.push(startNode);
		
		while(!s.empty()) {
			sb.append(s.pop() + " ");
		}
		
	}
	
	public static void main(String[] args) throws IOException { 
		Scanner sc = new Scanner(System.in); 
		File input_file = new File("D:\\DSEM\\programming_semina_test\\input.txt");     
        File output_file = new File("D:\\DSEM\\programming_semina_test\\output.txt");        
        BufferedReader rb = new BufferedReader(new FileReader(input_file));
        BufferedWriter wb = new BufferedWriter(new FileWriter(output_file));  
        StringTokenizer st = new StringTokenizer(rb.readLine());
		
        System.out.print("������ >> ");
        int startNode = sc.nextInt();  // ������ : 2, ���� : 5
        System.out.print("���� >> ");
		int endNode = sc.nextInt();   
        
        int V = Integer.parseInt(st.nextToken());  // ��� ��
        int E = Integer.parseInt(st.nextToken());  // ���� ��
        
		int[][] graph = new int[V+1][V+1]; 
		
		for (int i = 0; i < V+1; i++) { 
			for (int j = 0; j < V+1; j++) { 
				graph[i][j] = INF; 
			}
		} 
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(rb.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = w;
		} 
		 
		int len = djikstra(graph, V, startNode, endNode);
		
		System.out.println("�ִܰ�� : " + len);
		wb.write(Integer.toString(len));
		
		System.out.println("��� : " + sb.toString());
		wb.write("\n" + sb.toString());
		
		wb.flush(); wb.close();
		rb.close();
	}
}

