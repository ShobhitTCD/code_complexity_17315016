package com.tutorialspoint;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;

  

@Path("/UserService") 

public class UserService  {  
   
   @GET 
   @Produces(MediaType.APPLICATION_XML) 
   @Path("{parameter}")
   public String sayHelloXMl(@PathParam("parameter") String parameterValue) throws IOException{
	   
       
   	   Git result = Git.cloneRepository()
                  .setURI("https://github.com/postmanlabs/newman.git")
                  .setDirectory(new File("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\GitCloneRepository"))
                  .call() ;
	   
   	java.nio.file.Path start = FileSystems.getDefault().getPath("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\GitCloneRepository");
   	Files.walk(start)
    .filter( path -> path.toFile().isFile())
    .filter( path -> path.toString().endsWith(".java"))
    .forEach(path -> {
		try {
			listFilesForFolder(path.toString()   );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} );

	   return "Code complexity calculation";   
   }
	  
   public void listFilesForFolder(String path) throws UnknownHostException, IOException {
	   
	   
	   System.out.println(path);
	   Socket s = new Socket("127.0.0.1",5555);
	   OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter Out = new PrintWriter(os);
		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
		String msgin="";//,msgout="";
		while(!msgin.equals("end"))
		{	
			Out.println(path);
			os.flush();
			
			String complexity = br.readLine();
			
			System.out.println(" Filelocation : " + path+"/n"+" complexity   : "+ complexity);

			if (path==null)
			break;
		}
	   /*
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
	   }*/
  
   }
   
	    

}
