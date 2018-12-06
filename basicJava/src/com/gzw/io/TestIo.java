package com.gzw.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.gzw.po.Student;

public class TestIo {
	
	public static void main(String[] args) {
		testFileInputStream("D:\\scroll.rar","D:\\aaa.rar");
		System.out.println("asfsdfsdfddfsdfdsfsdfsdfdsfffffffffffffff");
//		testFileReader("D:\\scroll.rar","D:\\aaa.rar");
//		readObject("D:\\log\\writeObject.txt");
		
	}
	
	//文件字节输入流
	public static void testFileInputStream(String path1,String path2){
		FileInputStream fin = null;
		FileOutputStream fos = null;
		try {
			 fin = new FileInputStream(path1);
			 //创建输出流
			 fos = new FileOutputStream(path2);
			 byte[] b = new byte[1024];//管道长度
			 int hasRead = 0; //保存的实际字节数
			 int i = 0;
			 while((hasRead = fin.read(b))>0){
				 i++;
				 System.out.println(new String(b, 0, hasRead) + "..."+hasRead+"..."+i);
				 fos.write(b, 0, hasRead);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fin.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//文件字符输入流
	public static void testFileReader(String path1,String path2){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(path1);
			fw = new FileWriter(path2);
			char[] c = new char[1024];
			int hasRead = 0;
			int i = 0;
			while((hasRead = fr.read(c)) > 0){
				i++;
				System.out.println(new String(c, 0, hasRead)+"..."+hasRead+"..."+i);
				fw.write(c, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeObject(String path){
		OutputStream out = null;
		BufferedOutputStream bo = null;
		ObjectOutputStream oou = null;
		try {
			out = new FileOutputStream(path);
			bo = new BufferedOutputStream(out);
			oou = new ObjectOutputStream(bo);
			oou.writeObject(new Student("张三",18));
			oou.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				oou.close();
				bo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readObject(String path){
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream(path);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			try {
				Student s = (Student) oin.readObject();
				System.out.println(s);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
