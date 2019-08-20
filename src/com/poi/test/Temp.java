package com.poi.test;
/**
 * 
 * ¡Ÿ ±¿‡
 * @author thin
 *
 */
public class Temp {
	private  String  name;		//name
	private	 Integer age;		//age
	private	Integer  phone;		//phone
	private	String  sex;		//sex
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Temp [name=" + name + ", age=" + age + ", phone=" + phone + ", sex=" + sex + "]";
	}
}
