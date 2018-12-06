package com.gzw.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import com.gzw.annotation.XmlElement;

public class JavaToXml {
	
	public static <T> String objToXml(List<T> list) throws IllegalArgumentException, IllegalAccessException{
		
		
		StringBuffer xml = new StringBuffer("<rows>");
		for (T obj : list) {
			Field [] fields = obj.getClass().getDeclaredFields();
			xml.append("<row>");
			for (Field field : fields) {
				boolean isAnnotation = field.isAnnotationPresent(XmlElement.class);
				field.setAccessible(true);
				if(isAnnotation){
					XmlElement annotation = field.getAnnotation(XmlElement.class);
					String fieldName = "";
					if("".equals(annotation.name())){
						fieldName = field.getName();
					}else{
						fieldName = annotation.name();
					}
					Object value = field.get(obj);
					if(null == value){
						value = annotation.value();
					}
					if(value instanceof Date){
						value = DateUtils.format((Date)value, "yyyyMMddHHmmss");
					}
					
					xml.append("<"+fieldName+">"+value+"</"+fieldName+">");
				}
			}
			xml.append("</row>") ;
		}
		xml.append("</rows>");
		return xml.toString();
	}
	
}
