package Chapter04Questions;
import java.util.*;


/**
 * @author maxti
 *
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

@SuppressWarnings("unchecked")


public class Q1 {
	
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		DirectedGraph test = new DirectedGraph();
		test.add(0, 1);
		test.add(0, 2);
		test.add(1,3);
		test.add(2,3);
		test.add(2,4);
		test.add(3,5);
		test.add(3,6);
		test.add(5,6);
		test.add(4, 1);
		test.add(6, 3);
		
		System.out.println(test.toString());
	//	System.out.println(test.edgesToString());
		
		System.out.println("Is there a path from 0 to 6? " + test.findRoute(test.findVertex(0), test.findVertex(6)));
		System.out.println("Is there a path from 6 to 0? " + test.findRoute(test.findVertex(6), test.findVertex(0)));
	}
	
	
	public static class DirectedGraph<T extends Comparable<T>> {
		
		public enum State {UNVISITED, VISITED, COMPLETE};	
		
		private ArrayList<Vertex> vertexList;
		private ArrayList<Edge> edgeList;
		
		//constructor for graph
		public DirectedGraph()
		{
			vertexList = new ArrayList<>();
			edgeList = new ArrayList<>();
		}

		
		//Creates Edge
		public void add (T x, T y)
		{
			Edge tmp = findEdge(x, y);
			if (tmp != null) {
				System.out.println("Edge " + x + "," + y + " already exists.");
			}
			else {
				Edge e = new Edge(x, y);
				edgeList.add(e);				
			}
			
		}
		
		//Searches for vertex with a specific value
		public Vertex findVertex(T v) {
			for (Vertex each : vertexList) {
				if(each.getValue().compareTo(v) == 0) {
					return each;
				}
			}
			return null;
		}
		
		//Find edge by the vertices on it, direction matters
//		private Edge findEdge(Vertex v1, Vertex v2) {
//			for (Edge each : edgeList)
//			{
//				if (each.x.equals(v1) && each.y.equals(v2))
//				{
//					return each;
//				}
//			}
//			return null;
//		}
		
		private Edge findEdge(T x, T y)
		{
			for (Edge each : edgeList)
			{
				if (each.x.value.equals(x) && each.y.value.equals(y))
				{
					return each;
				}
			}
			return null;
		}
		
		public boolean isConnected()
		{
			for (Vertex each : vertexList)
			{
				if (each.state != State.COMPLETE)
					return false;
			}
			return true;
		}
		
		private void clearStates()
		{
			for (Vertex each : vertexList)
			{
				each.state = State.UNVISITED;
			}
		}
		
		public String toString(){
			String retval = "";
			for (Vertex each : vertexList)
			{
				retval += each.toString() + "\n";
			}
			return retval;
		}

		
		public String edgesToString() {
			String retval = "";
			for (Edge each : edgeList) {
				retval += each;
			}
			return retval;
		}
		
		//Breadth first search implementation
		public boolean findRoute(Vertex original, Vertex destination) {
			
			if (vertexList.isEmpty()) {
				return false;
			}
			
			clearStates();
			
			if (original == null) {
				return false;
			}
			
			boolean output = false;
			Queue<Vertex> queue = new LinkedList<>();
			
			queue.add(original);
			original.state = State.COMPLETE;
			
			while (!queue.isEmpty()) {
				original = queue.peek();
				for (Vertex each : original.outgoing) {
					if (each.state == State.UNVISITED) {
						if (each == destination) {
							output = true;
							return output;
						}
						each.state = State.COMPLETE;
						queue.add(each);
					}
				}
				
				queue.remove();
			}
			
			return output;
		}
		
		class Vertex {
			T value;
			State state;
			
			List<Vertex> incoming;
			List<Vertex> outgoing;
			
			//constructor
			public Vertex(T v) {
				this.value = v;
				incoming = new ArrayList<>();
				outgoing = new ArrayList<>();
				state = State.UNVISITED;
			}
			
			public void addIncoming(Vertex vert)
			{
				incoming.add(vert);
			}
			public void addOutgoing(Vertex vert)
			{
				outgoing.add(vert);
			}

			
			public State getState() {
				return state;
			}

			public void setState(State s) {
				state = s;
			}

			public T getValue(){
				return value;
			}

			@Override
			public String toString()
			{
				String retval = "";
				retval += "Vertex: " + value + " : ";
				retval += " In: ";
				for (Vertex each : incoming) retval+= each.value + " ";
				retval += "Out: ";
				for (Vertex each : outgoing) retval += each.value + " ";
				return retval;
			}
			
		}
		
		class Edge{
			
			Vertex x;
			Vertex y;
						
			public Edge (T v1, T v2) {
				x = findVertex(v1);
				if (x == null) {
					x = new Vertex(v1);
					vertexList.add(x);
				}
				
				y = findVertex(v2);
				if (y == null) {
					y = new Vertex(v2);
					vertexList.add(y);
				}
				
				x.addOutgoing(y);
				y.addIncoming(x);				
			}

			public String toString()
			{
				return "Edge X:" + x.getValue() + " Y:" + y.getValue() + "\n";
			}
			
		}
		
		
	}
}
