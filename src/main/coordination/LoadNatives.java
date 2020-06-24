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
	
	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
	
	public void loadLibs() throws IOException {
		
		String destPath;
		
		if(isWindows()) {
			destPath = System.getProperty("java.io.tmpdir") + "jarg" + GameSettings.SEP;
		} else {
			destPath = System.getProperty("java.io.tmpdir") + File.separator + "jarg" + File.separator;
		}
		
		
		try {
			String jarPath = "C:/Users/kryas/OneDrive/Desktop/jarg.jar";
	        String currPath = System.getProperty("user.dir") + GameSettings.SEP +"jarg.jar";
			
	        System.out.println("     "+currPath);
	        System.out.println("     "+destPath);
	        
	        
	        JarFile jarFile = new JarFile(currPath);
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
	        }
	        jarFile.close();
	    } catch (IOException ex) {
	    	System.out.println("Could not find file ");
	    }
		
		if(isWindows()) {
			System.load(new File(destPath + "libJars" + GameSettings.SEP + "lwjgl64.dll").getAbsolutePath());
			System.load(new File(destPath + "libJars" + GameSettings.SEP + "OpenAL64.dll").getAbsolutePath());
			System.load(new File(destPath + "libJars" + GameSettings.SEP + "jinput-dx8_64.dll").getAbsolutePath());
			System.load(new File(destPath + "libJars" + GameSettings.SEP + "jinput-raw_64.dll").getAbsolutePath());
		}
		
		if(isUnix()) {
			System.out.println(destPath + "libJars" + GameSettings.SEP + "liblwjgl64.so");
			System.load("/tmp/jarg/libJars/liblwjgl64.so");
			System.load(new File(destPath + "libJars" + GameSettings.SEP + "libjinput-linux64.so").getAbsolutePath());
			System.load(new File(destPath + "libJars" + GameSettings.SEP + "libopenal64.so").getAbsolutePath());
		}
		
		if(isMac()) {
			System.load(destPath + "libJars" + GameSettings.SEP + "libjinput-osx.dylib");
			System.load(destPath + "libJars" + GameSettings.SEP + "liblwjgl.dylib");
			System.load(destPath + "libJars" + GameSettings.SEP + "openal.dylib");
			System.load(destPath + "libJars" + GameSettings.SEP + "libjinput-osx.jnilib");
		}
	}
	
}
