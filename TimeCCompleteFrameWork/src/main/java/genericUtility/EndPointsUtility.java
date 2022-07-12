package genericUtility;

public interface EndPointsUtility 
{
	/**
	 * This interface constins all the endpoints
	 * @author Yateesh 
	 *
	 */
		
		String CreateProject = "/addProject";
		String GetProjects = "/projects";
		String UpdateProject = "/projects/";
		String DeleteProject = "/projects/";
		String GetSingleProject = "/projects/{pid}";
}
