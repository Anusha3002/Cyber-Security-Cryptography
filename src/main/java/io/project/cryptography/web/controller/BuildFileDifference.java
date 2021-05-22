package io.project.cryptography.web.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class BuildFileDifference {

	public static void main (String r[]) {
		System.out.println("Working out manifest");
		
		//URLClassLoader cl = (URLClassLoader) App.class.getClassLoader();
		//URL url = cl.findResource("META-INF/MANIFEST.MF");
		URL url;
		try {
			url = new URL("file:///D:/source/12.2.1.5.0/webcentersites/sites-manifest-classpath/sites-manifest-cas/MANIFEST.MF");
			Manifest manifest = new Manifest(url.openStream());
			Attributes attr = manifest.getMainAttributes();
			String classPath = manifest.getMainAttributes().getValue("Class-Path");
			String paths[] = classPath.split(" ");
			List<String> names = new ArrayList<>();
			for(String p: paths) {
				String s = p.substring(p.lastIndexOf("/")+1);
				names.add(s);
			}
			
			for (String file: names) {
				Path target = Paths.get("D:/temp/manifest-dir/"+file);
				Path source = Paths.get("D:/builds/12.2.1.4.0/JSK-12.2.1.4.0-2019-10-15/apache-tomcat-7.0.65-sites/webapps/cas/WEB-INF/lib/"+file);
				if (!file.contains("osgi-resource-locator-1.0.1"))
				Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
				
			}
			System.out.println(" Files deployed ");
	        // Creates a new File instance by converting the given pathname string
	        // into an abstract pathname
	        File f = new File("D:/builds/12.2.1.4.0/JSK-12.2.1.4.0-2019-10-15/apache-tomcat-7.0.65-sites/webapps/cas/WEB-INF/lib");

	        // Populates the array with names of files and directories
	        String[] pathnames = f.list();
	    	List<String> extranames = new ArrayList<>();
	        // For each pathname in the pathnames array
	        for (String pathname : pathnames) {
	            // Print the names of files and directories
	        	if (names.contains(pathname)) {
	        		names.remove(pathname);
	        	} else {
	        		extranames.add(pathname);
	        	}
  
	        }
	        
	        // extra jars to be exclusted
	        System.out.println(" Fix manifest ");
	        for (String n: names) {
	        	System.out.println(n);
	        }
	        System.out.println(" May need these jars ");	
	        for (String n: extranames) {
	        	System.out.println(n);
	        }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
