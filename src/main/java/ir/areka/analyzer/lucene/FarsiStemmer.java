package ir.areka.analyzer.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

public class FarsiStemmer {
	
	String perlFile = new File(getClass().getResource("./perstem.pl").getFile()).getAbsolutePath();
	
	public String stem(String term) {
		try {
			Process p = Runtime.getRuntime().exec("echo \""+ term +"\" | perl "+ perlFile +" -s");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        StringBuilder out = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
	        System.out.println(out.toString());   //Prints the string content read from input stream
	        reader.close();
			System.out.println(IOUtils.toString(p.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
