package com.gzw.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Relax {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		int num1 = '中';
		int num2 = '国';
		System.out.println(num1);
		System.out.println(num2);
		String str = "中国";
		
		byte[] b = str.getBytes();
		System.out.println(Arrays.toString(b));
		System.out.println(b[0]);
		System.out.println(b[1]);
		
		String str2 = new String(b);
		System.out.println(str2);
		
		byte[] b2 = {-28,-72,-83};
		String str3 = new String(b2);
		System.out.println(str3);
		
		byte[] b3 = {-27,-101,-67};
		String str4 = new String(b3);
		System.out.println(str4);
		
	}
}
