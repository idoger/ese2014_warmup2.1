package org.sample.controller;

import org.sample.controller.pojos.NewTeamForm;
import org.sample.controller.service.NewTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewTeamController {

	@Autowired
	NewTeamServiceImpl newTeamService;

	@RequestMapping(value = "/new-team", method = RequestMethod.GET)
	public ModelAndView newTeam() {
		ModelAndView model = new ModelAndView("new-team");
		model.addObject("newTeamForm", new NewTeamForm());
		return model;
	}

	@RequestMapping(value = "/new-team/create")
	public ModelAndView createNewTeam(NewTeamForm newTeamForm) {
		ModelAndView model = new ModelAndView("new-team");
		newTeamService.saveFrom(newTeamForm);
		model.addObject("message", "New Team Created");
		
		return model;
	}
}
