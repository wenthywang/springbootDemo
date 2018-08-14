package com.example.entity;

import lombok.Data;

import java.io.Serializable;

@Data
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

}
