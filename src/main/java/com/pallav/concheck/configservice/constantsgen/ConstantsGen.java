package com.pallav.concheck.configservice.constantsgen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

public class ConstantsGen {
	
	public void generateConstants(Map<Object, Object> configs) throws IOException
	{
	
		createTargetDir();
		FileOutputStream fs = new FileOutputStream("target/constants/ConfigConstats.java");
		OutputStreamWriter osw = new OutputStreamWriter(fs);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter out = new PrintWriter(bw);
		
		out.append("class ConfigConstats{");
		out.append("public static void hello(){System.out.println(\"Hello this is constant class\");}");
		out.append("}");
		
		out.close();
		bw.close();
		osw.close();
		fs.close();
		
		
		
		
		
	}
	
	private void createTargetDir()
	{
		File dir = new File("target/constants");
		if(!dir.exists())
		{
			System.out.println("Creating constants directory in target...");
			dir.mkdirs();
		}
		else{
			// this part is not working now because delete have some issue.
			System.out.println("target\\constants Directort already exists...");
			if(dir.delete())
				dir.mkdirs();
			else
				System.out.println("Failed to deleted generated files. May already in use.");
			
		}
		
	}
	

}
