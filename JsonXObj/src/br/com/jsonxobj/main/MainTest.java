package br.com.jsonxobj.main;

import java.io.File;
import java.util.List;

import br.com.jsonxobj.abstracts.UtilsFiles;

public class MainTest {


	public static void main(String[] args) throws Exception{
		ObjTeste o = new ObjTeste();
		o.setNome("batman");
		o.setNumero(24);
		
		
		UtilsFiles utilfiles = new UtilFilesFromJson();
		File file = new File(FileDefs.PATHOFFILE);
		
		// Object to json
		String ObjJson = UtilsJson.objToJson(o);
		
		
		
		//Write this json in a file
		utilfiles.write(FileDefs.PATHOFFILE, ObjJson);
		
		// Read file with the json, and put this in a String
		String json = utilfiles.read(file);
		
		// split this json in object and values
		String[] jsons = UtilsJson.splitInJson(json);
		
		// Transform this json(s) in a List of Objects... and... enjoy it! :D
		@SuppressWarnings("unused")
		List<Object> objts = UtilsJson.objectsFromJson(jsons);
		
		// here use reflection to use your object(s) "beans in mean" ;)
	}
}
