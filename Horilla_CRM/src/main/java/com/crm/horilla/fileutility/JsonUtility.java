package com.crm.horilla.fileutility;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJSON(String key) throws Throwable
	{
        JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./ConfigAppData/jsondata.json"));
		JSONObject map=(JSONObject)obj;
		String data=map.get(key).toString();
		return data;
	}

}
