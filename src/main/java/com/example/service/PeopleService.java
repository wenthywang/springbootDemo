package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.People;
import com.example.mapper.PeopleMapper;

@Service
public class PeopleService {
	@Autowired
	private PeopleMapper peopleMapper;

	public int insertPeople(People people) {

		return 	peopleMapper.getSQLManager().insert(people);
	}

	public List<People> getPeopleList()

	{
		return peopleMapper.getSQLManager().all(People.class);
	}

	public int updatePeople(People people) {

		return  	peopleMapper.getSQLManager().updateById(people);
	}

	public int deletePeople(String id) {
		return peopleMapper.getSQLManager().deleteById(People.class,id);
	}

	public People getPeopleById(String id) {
		return peopleMapper.getSQLManager().unique(People.class,id);
	}

}
