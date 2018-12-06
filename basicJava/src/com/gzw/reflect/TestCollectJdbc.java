package com.gzw.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class TestCollectJdbc {
	
	
	public static void main(String[] args) {
		String driverClassName = getValue("datasource.driverClassName");
		System.out.println(driverClassName);
		String url = getValue("datasource.url");
		String userName = getValue("datasource.username");
		String password = getValue("datasource.password");
		try {
			Class.forName(driverClassName);
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("select * from sys_user s where s.id = ?");
			ps.setString(1, "1");
			ResultSet result = ps.executeQuery();
			while(result.next()){
				System.out.println(result.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public static String getValue(String key){
		Properties p = new Properties(); 
		FileReader in = null;
		try {
			in = new FileReader("static/test.properties");
			p.load(in);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p.getProperty(key);
		
	}

}
