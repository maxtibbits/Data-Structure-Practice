package Chapter04Questions;

/**
 * @author maxti
 * 
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects, 
 * where the second project is dependent on the first project). All of a project's dependencies must 
 * be built before the project is. Find a build order that will allow the projects to be built. If 
 * there is no valid build order, return an error.
 */

public class Q7 {

	private static class Project{
		Project[] deps;
		boolean built = false;
		
		private void buildDeps() {
			for (int i = 0; i < deps.length; i++) {
				if(deps[i].built == false) {
					deps[i].buildDeps();
				}
			}

		}
	}
}
