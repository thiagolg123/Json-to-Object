/*Copyright [2014] [Thiago de Lima Gonçalves - thiagodelimag@gmail.com]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package br.com.jsonxobj.main;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author thiago.goncalves
 * 
 */
public class UtilsJson {

	/**
	 * @param o --> object to json
	 * @return String with json
	 */
	public static String objToJson(Object o) {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(o);
		String jsonWithNameObj = o.getClass().getName() + ";" + json; // ";"  to split the name of the object
		
		return jsonWithNameObj;
	}

	/**
	 * @param pathOfClass
	 * @param json
	 * @return An object from json
	 */
	public static Object jsonToObj(String pathOfClass, String json) {
		Gson gson = new GsonBuilder().create();
		@SuppressWarnings("rawtypes")
		Class clazz = null;

		try {
			clazz = Class.forName(pathOfClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		@SuppressWarnings("unchecked")
		Object o = gson.fromJson(json, clazz);
		return o;
	}

	/**
	 * Split String with ";" Object and values
	 * for example br.com.a.b.Class ; values[...]
	 * 
	 * @param json to split
	 * @return String[] with this values
	 */
	public static String[] splitInJson(String json) {
		String[] jsonWithSplit = json.split(";");
	
		return jsonWithSplit;
	}

	/**
	 * @param jsonSplit
	 * @return List of objects from json;
	 */
	public static List<Object> objectsFromJson(String[] jsonSplit) {
		List<Object> objects = new ArrayList<Object>();
		
		for(int i=0; i<jsonSplit.length -1; i++){
			objects.add(jsonToObj(jsonSplit[i], jsonSplit[i+1]));
			i++;
		}
		return objects;
	}

}
