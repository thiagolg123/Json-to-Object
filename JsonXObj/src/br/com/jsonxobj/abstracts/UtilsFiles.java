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

package br.com.jsonxobj.abstracts;

import java.io.File;
import java.io.PrintWriter;

/**
 * @author Thiago Gonçalves
 *
 */
public abstract class UtilsFiles {

	/**
	 * @param nameFile = path and name of the file
	 * @param txt = text to write in the file
	 * @return sucess or error
	 * @throws Exception 
	 */
	public abstract boolean write(String pathAndNameFile, String txt) throws Exception;
	
	/**
	 * @param file: path of the file to read
	 * @return string with json
	 */
	public abstract String read(File file) throws Exception;
	
	/** Clear a file
	 * @param file
	 * @throws Exception
	 */
	public void clearFile(String pathFile) throws Exception {
		PrintWriter file = new PrintWriter(pathFile);
		file.write("");
		file.close();
	}

}
