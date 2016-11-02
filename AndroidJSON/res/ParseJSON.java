import org.json.JSONArray;
import org.json.JSONObject;

String jsonString = readJsonObjectFromSomeWhere(); // <1>
try {
	JSONObject json = new JSONObject(jsonString);
	} catch (Exception e) {
		e.printStackTrace();
	}
