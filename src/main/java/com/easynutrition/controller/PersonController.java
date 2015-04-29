package com.easynutrition.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.dao.PersonDao;
import com.easynutrition.entity.Person;

@Controller
@RequestMapping(value = "/")
public class PersonController {
	@Autowired
	private PersonDao personDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedPeople(Model model) {
		model.addAttribute("newPerson", new Person());
		model.addAttribute("people", personDao.findAllOrderedByName());
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewPerson(
			@Valid @ModelAttribute("newPerson") Person newPerson,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			personDao.register(newPerson);
			return "redirect:/";
		} else {
			model.addAttribute("people", personDao.findAllOrderedByName());
			return "index";
		}
	}
}
