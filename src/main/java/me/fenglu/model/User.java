package me.fenglu.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="User")
@Table(name="TBL_USER")
public class User {
	
	private String id;
	
	private int version;
	private int age;
	private int sex;
	private Date birthday;
	private String transientField;
	private char[] clobField;
	private byte[] blobField;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Version
	@Column(name="OPTLOCK")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Basic(fetch=FetchType.LAZY)
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Transient
	public String getTransientField() {
		return transientField;
	}
	public void setTransientField(String transientField) {
		this.transientField = transientField;
	}
	
	@Lob
	public char[] getClobField() {
		return clobField;
	}
	public void setClobField(char[] clobField) {
		this.clobField = clobField;
	}
	@Lob
	public byte[] getBlobField() {
		return blobField;
	}
	public void setBlobField(byte[] blobField) {
		this.blobField = blobField;
	}
	
}
