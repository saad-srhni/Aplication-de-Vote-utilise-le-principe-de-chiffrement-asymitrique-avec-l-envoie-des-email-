package openpgp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFile {
	public String readfile(String file) {
		try {
			InputStream flux = new FileInputStream(file);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String line;
			String msg = "";
			while ((line = buff.readLine()) != null) {
				msg += line + "\n";
			}
			System.out.println(msg);
			buff.close();
			return msg;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
		
	}
}
