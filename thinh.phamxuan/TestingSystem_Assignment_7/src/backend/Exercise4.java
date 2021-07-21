package backend;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import constant.Constant;
import entity.Employee;

public class Exercise4 {
	private Exercise3 exercise3=new Exercise3() ;
	public String readFile(String pathFile) throws Exception{
		if(!exercise3.isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
		else {
		    String content = null;
		    File file = new File(pathFile); 
		    FileReader reader = null;
		    try {
		        reader = new FileReader(file);
		        char[] chars = new char[(int) file.length()];
		        reader.read(chars);
		        content = new String(chars);
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if(reader != null){
		            reader.close();
		        }
		    }
		    return content;
		}
		
	
	}
	public void writeFile(String pathFile,boolean isContinuing,String content) throws Exception	 {
		if(!exercise3.isFileExists(pathFile)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
		else {
			FileOutputStream fos=null;
			BufferedOutputStream bos=null;
			try {
				fos=new FileOutputStream(pathFile);
				bos=new BufferedOutputStream(fos);
				if(isContinuing==false) {
					exercise3.deleteFile(pathFile);
					exercise3.createNewFile(pathFile);
				}
				byte b[]=content.getBytes();
				bos.write(b);
				bos.flush();
		
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				bos.close();
				fos.close();
			}
		}

	}
	
	public void writeObject(Object object,String path,String fileName) throws Exception {
		if(object==null) {
			throw new Exception(Constant.OBJECT_IS_NULL);
		}
		else {
			if(!exercise3.isFileExists(path)) {
				exercise3.createNewFolder(fileName); ;
			}
			FileOutputStream fos=null;
			ObjectOutputStream oos=null;
			try {
				fos=new FileOutputStream(path);
				oos=new ObjectOutputStream(fos);

				oos.writeObject(object);
				
		
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				oos.close();
				fos.close();
			}
		}

	}
	public Object readObject(String filePath) throws Exception {
		if(!exercise3.isFileExists(filePath)) {
			throw new Exception(Constant.FILE_NOT_EXISTS);
		}
		else {
			Employee employee=null;	
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			try {
				fis=new FileInputStream(filePath);
				ois=new ObjectInputStream(fis);
				employee=(Employee) ois.readObject();

				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				ois.close();
				fis.close();
			}
			return employee;
		}

		
	}
}
