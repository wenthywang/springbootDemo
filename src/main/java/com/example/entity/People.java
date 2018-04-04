package com.example.entity;

import java.io.Serializable;

public class People implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6579135614470274295L;
	/**
	 * id主键
	 */
	private String id;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 插入时间
	 */
	private Long insertTime;

	/**
	 * 更新时间
	 */
	private Long updateTime;

	private String insertTime_format;
	private String updateTime_format;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Long insertTime) {
		this.insertTime = insertTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getInsertTime_format() {
		return insertTime_format;
	}

	public void setInsertTime_format(String insertTime_format) {
		this.insertTime_format = insertTime_format;
	}

	public String getUpdateTime_format() {
		return updateTime_format;
	}

	public void setUpdateTime_format(String updateTime_format) {
		this.updateTime_format = updateTime_format;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + ", insertTime=" + insertTime + ", updateTime="
				+ updateTime + ", insertTime_format=" + insertTime_format + ", updateTime_format=" + updateTime_format
				+ "]";
	}

}
