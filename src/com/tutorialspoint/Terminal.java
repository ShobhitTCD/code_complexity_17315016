package com.tutorialspoint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;

		public class Terminal 
		{	public static void main(String args[]) throws IOException
			{
				ServerSocket soc = new ServerSocket(5555);
				Socket s = soc.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());			
				PrintWriter Out = new PrintWriter(os);			
				String msgin="";			
				while(!msgin.equals(null))
				{
					String path = br.readLine();
					System.out.println(path);
					
				 	 int codeComplexityOfFile = 0;
			    	  List<String> allLines = FileUtils.readLines(new File(path));
			    	  for(String eachLine :allLines  ) {
			    		 	    		  
			    		if(  !eachLine.contains("//")  && (eachLine.contains("method") ||  eachLine.contains("if") ||  eachLine.contains("else") ||  eachLine.contains("case")
			    				|| eachLine.contains("case") ||  eachLine.contains("default") ||  eachLine.contains("for") || 
			    				 eachLine.contains("while"))) {
			    			codeComplexityOfFile ++;
			    		}
			    		  
			    	  }
			    	  System.out.println("The code complexity of the file " + new File(path).getName() + " is " + codeComplexityOfFile );				
			        
					Out.println(codeComplexityOfFile);
					os.flush();	
					}
				s.close();
			}
			
		}