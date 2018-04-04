package com.example.mapper;

import java.util.List;

import com.example.entity.People;

public interface PeopleMapper {

	public List<People> getPeopleList();

	public int insertPeople(People people);

	public int updatePeople(People people);

	public int deletePeople(String id);

	public People getPeopleById(String id);
}
