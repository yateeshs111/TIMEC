package genericUtility;


import io.restassured.response.Response;

public class RestAssuredUtlity 
{

	/**
	 * This method will accept the jsonpath and return the json data
	 * @param resp
	 * @param path
	 * @return
	 */
	public String getJSONData(Response resp, String path)
	{
		String jsonData = resp.jsonPath().get(path);
		return jsonData;
	}
}
