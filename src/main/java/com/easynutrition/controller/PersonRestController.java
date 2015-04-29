package com.easynutrition.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynutrition.dao.PersonDao;
import com.easynutrition.entity.Person;

@Controller
public class PersonRestController {
	@Autowired
	private PersonDao personDao;

	@RequestMapping(value = "/rest/people", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Person> listAllPeople() {
		return personDao.findAllOrderedByName();
	}

	@RequestMapping(value = "/rest/person/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Person lookupPersonById(@PathVariable("id") Long id) {
		return personDao.findById(id);
	}
}
