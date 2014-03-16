package br.com.jsonxobj.main;

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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileSystemException;

import br.com.jsonxobj.abstracts.UtilsFiles;

/**
 * @author thiago.goncalves
 * 
 */
public class UtilFilesFromJson extends UtilsFiles {

	public boolean write(String pathAndNameFile, String txt)
			throws FileSystemException {
		try {

			File file = new File(pathAndNameFile);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			Writer w = new BufferedWriter(bw);
			w.write(txt + ";"); // ";" to split.
			w.close();

			return true;

		} catch (Exception e) {
			throw new FileSystemException("", "", e.getMessage());
		}
	}

	public String read(File file) throws FileSystemException {
		try {
			@SuppressWarnings("resource")
			BufferedReader bw = new BufferedReader(new FileReader(file));
			String line = bw.readLine();
			System.out.println(line); // TEST
			return line;
		} catch (FileNotFoundException e) {
			throw new FileSystemException(
					"",
					"", e.getMessage());
		} catch (IOException e) {
			throw new FileSystemException(
					"",
					"", e.getMessage());
		}
	}
}
