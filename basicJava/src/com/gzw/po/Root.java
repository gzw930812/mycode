package com.gzw.po;

import java.util.Base64;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.gzw.util.XmlAndJavaObjectConvert;

@XmlRootElement(name="ROOT")
@XmlAccessorType(XmlAccessType.NONE)
public class Root {
	
	@XmlElement(name="VERSION")
	private String version;
	@XmlElement(name="DATAID")
	private String dataId;
	@XmlElement(name="USERID")
	private String userId;
	@XmlElement(name="TIME")
	private String time;
	@XmlElement(name="TYPE")
	private String type;
	@XmlElement(name="SEC")
	private String sec;
	//@XmlElement(name="BUSINESSCONENT")
	private String businessContent;
	@XmlElement(name="HMAC")
	private String hmac;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	@XmlElement(name="BUSINESSCONENT")
	public String getBusinessContent() {
		return new String(Base64.getEncoder().encode(businessContent.getBytes()));
	}
	public void setBusinessContent(String businessContent) {
		this.businessContent = businessContent;
	}
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	
	public static void main(String[] args) {
		String rows = "<rows><row><id>123</id></row></row>";
		Root r = new Root();
		r.setVersion("V1.1");
		r.setDataId("000001");
		r.setTime("20181024164532");
		r.setType("01");
		r.setUserId("1201120061");
		r.setSec("01");
		r.setBusinessContent(rows);
		System.out.println(XmlAndJavaObjectConvert.convertToXml(r, false));
		
		Teacher t1 = new Teacher("lisi", 25);
		Teacher t2 = new Teacher();
		t2.setAge(12);
		Rows<Row> rows2 = new Rows<Row>();
		rows2.getRows().add(t1);
		rows2.getRows().add(t2);
		String xml = XmlAndJavaObjectConvert.convertToXml(rows2, false);
		String ss = " xsi:type=\"xs:string\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
		xml = xml.replaceAll(ss, "");
		System.out.println(xml);
		
	}
	
	
}
