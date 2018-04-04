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
		return peopleMapper.insertPeople(people);
	}

	public List<People> getPeopleList() {
		return peopleMapper.getPeopleList();
	}

	public int updatePeople(People people) {
		return peopleMapper.updatePeople(people);
	}

	public int deletePeople(String id) {
		return peopleMapper.deletePeople(id);
	}

	public People getPeopleById(String id) {
		return peopleMapper.getPeopleById(id);
	}

}
