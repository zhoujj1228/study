package com.ownclassreload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * �����ؼ��ص��������
 * ����ع��̲鿴loadClass����
 * ��Ҫ��дfindClass�������鿴URLClassLoader��
 * @author Jay
 * @date 2018��3��20��
 */
public class MyClassLoader extends ClassLoader {
	public MyClassLoader(){
	}
	public Class<?> findClass(String name) throws ClassNotFoundException{
		String classPath = MyClassLoader.class.getResource("/").getPath();
		String fileName = name.replace(".", "/") + ".class";
		File classFile = new File(classPath, fileName);
		if(!classFile.exists()){
			throw new ClassNotFoundException(classFile.getPath() + "������");
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteBuffer bf = ByteBuffer.allocate(1024);
		FileInputStream fis = null;
		FileChannel fc = null;
		try {
			fis = new FileInputStream(classFile);
			fc = fis.getChannel();
			
			while(fc.read(bf) > 0){
				bf.flip();
				bos.write(bf.array(), 0, bf.limit());
				bf.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fis != null){
					fis.close();
				}
				if(fc != null){
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.defineClass(name, bos.toByteArray(), 0, bos.toByteArray().length);
	}
}
