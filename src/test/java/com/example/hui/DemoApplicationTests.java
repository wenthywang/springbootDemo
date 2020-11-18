package com.example.hui;

import cn.hutool.json.JSONUtil;
import com.example.entity.People;
import com.example.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;


@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private PeopleService peopleService;


	@Test
	public void testGetList() {
		List<People> plist = peopleService.getPeopleList();
		System.out.println(JSONUtil.toJsonStr(plist));
	}

	@Test
	public void testInsert() {
		People p = new People();
		p.setId(UUID.randomUUID().toString());
		p.setAge(15);
		p.setName("api test");
		p.setInsertTime(System.currentTimeMillis());
		p.setUpdateTime(System.currentTimeMillis());
		peopleService.insertPeople(p);
	}

	@Test
	public void testUpdate() {
		People p = new People();
		p.setId("045cc9bd-81ba-49cd-8a96-1afa997c2f4c");
		p.setAge(16);
		p.setName("api test update");
		p.setUpdateTime(System.currentTimeMillis());
		peopleService.updatePeople(p);
		testGetList();
	}

	@Test
	public void testDelete() {
		String id = "c388b9ba-049c-4ebd-b751-a113a83e3007";
		peopleService.deletePeople(id);
		testGetList();
	}

}
