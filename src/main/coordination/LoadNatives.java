package main.coordination;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import main.worldModel.utilities.GameSettings;

public class LoadNatives {
	
	public void loadJarDll(String name) throws IOException {
		
		String destPath = System.getProperty("java.io.tmpdir") + "jarg" + File.separator;
        
		
		try {
			String jarPath = "C:/Users/kryas/OneDrive/Desktop/test.jar";
	        
	        JarFile jarFile = new JarFile(jarPath);
	        Enumeration<JarEntry> enums = jarFile.entries();
	        while (enums.hasMoreElements()) {
	        	JarEntry entry = enums.nextElement();
	            if (entry.getName().startsWith("natives") || entry.getName().startsWith("libJars") || entry.getName().startsWith("res")) {
	            	System.out.println(entry.getName());
	                File toWrite = new File(destPath + entry.getName());
	                if (entry.isDirectory()) {
	                    toWrite.mkdirs();
	                    continue;
	                }
	                InputStream in = new BufferedInputStream(jarFile.getInputStream(entry));
	                OutputStream out = new BufferedOutputStream(new FileOutputStream(toWrite));
	                byte[] buffer = new byte[2048];
	                while(true) {
	                    int nBytes = in.read(buffer);
	                    if (nBytes <= 0) {
	                        break;
	                    }
	                    out.write(buffer, 0, nBytes);
	                }
	                out.flush();
	                out.close();
	                in.close();
	            }
//	            System.out.println(entry.getName());
	        }
	        jarFile.close();
	    } catch (IOException ex) {
	    	System.out.println("Could not find file ");
	    }
		
		
		
		System.load(destPath + "libJars" + GameSettings.SEP + "OpenAL64.dll");
		System.load(destPath + "libJars" + GameSettings.SEP + "jinput-dx8_64.dll");
		System.load(destPath + "libJars" + GameSettings.SEP + "jinput-raw_64.dll");
		System.load(destPath + "libJars" + GameSettings.SEP + "lwjgl64.dll");
		
		
		
		
		
		
		
//		String path = "C:"+ GameSettings.SEP +"Users"+ GameSettings.SEP +"kryas"+ GameSettings.SEP +"OneDrive"+ GameSettings.SEP +"Desktop"+ GameSettings.SEP;
//		
//		java.util.jar.JarFile jar = new java.util.jar.JarFile(path + "test.jar");
//		java.util.Enumeration<java.util.jar.JarEntry> enumEntries = jar.entries();
//		new File(System.getProperty("java.io.tmpdir") + GameSettings.SEP + "jarg").mkdir();
//		while (enumEntries.hasMoreElements()) {
//			String destdir = System.getProperty("java.io.tmpdir") + GameSettings.SEP + "jarg" + GameSettings.SEP;     //abc is my destination directory
//	        java.util.jar.JarEntry je = enumEntries.nextElement();
//
//	        System.out.println(je.getName());
//
//	        java.io.File fl = new java.io.File(destdir, je.getName());
//	        if(!fl.exists())
//	        {
//	            fl.getParentFile().mkdirs();
//	            fl = new java.io.File(destdir, je.getName());
//	        }
//	        if(je.isDirectory())
//	        {
//	            continue;
//	        }
//	        java.io.InputStream is = jar.getInputStream(je);
//	        java.io.FileOutputStream fo = new java.io.FileOutputStream(fl);
//	        while(is.available()>0)
//	        {
//	            fo.write(is.read());
//	        }
//	        fo.close();
//	        is.close();
//		}
//		jar.close();
		
		
//		String path = GameSettings.SEP + "lib" + GameSettings.SEP + "natives" + GameSettings.SEP + name;
//		
//		Path dst = Paths.get(System.getProperty("java.io.tmpdir") + GameSettings.SEP + name);
//		
//		Path src = Paths.get(System.getProperty("user.dir") + GameSettings.SEP + "test.jar" + GameSettings.SEP + "loadNatives" + GameSettings.SEP + name);
//		
//	    InputStream in = LoadNatives.class.getResourceAsStream(GameSettings.SEP + name);
//	    
//	    System.out.println(GameSettings.SEP + name);
//	    Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
//		
//	    byte[] buffer = new byte[1024];
//	    int read = -1;
//	    File temp = new File(new File(System.getProperty("java.io.tmpdir")), name);
		
//		InputStream in = new URL().openStream();
//				LoadNatives.class.getResourceAsStream(GameSettings.SEP + name);
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(in == null);
//		System.out.println(GameSettings.SEP + name);
	    
//		byte[] buffer = new byte[1024];
//	    int read = -1;
//	    System.out.println(System.getProperty("java.io.tmpdir") + name);
//	    File temp = new File(new File(System.getProperty("java.io.tmpdir")), name);
//	    FileOutputStream fos = new FileOutputStream(temp);
//
//	    while((read = in.read(buffer)) != -1) {
//	        fos.write(buffer, 0, read);
//	    }
//	    fos.close();
//	    in.close();

//	    System.load(System.getProperty("java.io.tmpdir") + GameSettings.SEP + name);
	}
	
}
