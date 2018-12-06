package com.gzw.po;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="ROWS")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlSeeAlso(Teacher.class)
public class Rows<T> {
	
//	@XmlElement(name="ROW")
	@XmlElementRef
	private List<Row> rows = new ArrayList<Row>();

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	} 
	

}
