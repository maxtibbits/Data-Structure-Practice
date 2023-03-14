package Chapter04Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author maxti
 * 
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects, 
 * where the second project is dependent on the first project). All of a project's dependencies must 
 * be built before the project is. Find a build order that will allow the projects to be built. If 
 * there is no valid build order, return an error.
 */

public class Q7 {

	Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	Stack<Project> orderProjects(ArrayList<Project> projects){
		Stack<Project> stack = new Stack<Project>();
		for(Project project : projects) {
			if (project.getState() == Project.State.BLANK) {
				if(!doDFS(project, stack)) {
					return null;
				}
			}
		}
		
		return stack;
	}
	
	boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == Project.State.PARTIAL) {
			return false; //cycle
		}
		if (project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}	
			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}
	
	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}
	
	public class Graph{
		private ArrayList<Project> nodes = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		
		public Project getOrCreateNode(String name) {
			if(!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			
			return map.get(name);
		}
		
		public void addEdge(String startName, String endName) {
			Project start = getOrCreateNode(startName);
			Project end = getOrCreateNode(endName);
			start.addNeighbor(end);
		}
		
		public ArrayList<Project> getNodes(){
			return nodes;
		}
		
	}
	
	public class Project{
		private ArrayList<Project> children = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private int dependencies = 0;
		public enum State {COMPLETE, PARTIAL, BLANK};
		private State state = State.BLANK;
		
		public Project(String n) {
			name = n;
		}
		
		public State getState() {
			return state;
		}
		public void setState(State st) {
			state = st;
		}
		
		public void addNeighbor(Project node) {
			if(!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
				node.incrementDependencies();
			}
		}
	
		public void incrementDependencies() {
			dependencies++;
		}
	
		public void decrementDependencies() {
			dependencies--;
		}
	
		public String getName() {
			return name;
		}
		
		public ArrayList<Project> getChildren(){
			return children;
		}
		
		public int getNumberDependencies() {
			return dependencies;
		}
	}
}
