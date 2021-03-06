package org.sample.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.NewTeamForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.model.Team;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("signupForm", new SignupForm());  
    	ArrayList<Team> teams = new ArrayList<Team>();
    	Iterable<Team> teamsItr = sampleService.getTeamList();
    	
    	for (Team t: teamsItr){
    		teams.add(t);
    	}
    	model.addObject("teams", teams);
        return model;
    }

    
    
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@Valid SignupForm signupForm,
			BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView model;
		User user;
		if (!result.hasErrors()) {
			try {
				sampleService.saveFrom(signupForm);
				model = new ModelAndView("show");
				user = sampleService.getUser(signupForm.getId());
				model.addObject("user", user);
			} catch (InvalidUserException e) {
				model = new ModelAndView("index");
				model.addObject("page_error", e.getMessage());
			}
		} else {
			model = new ModelAndView("index");
		}
		return model;
	}




	private long getLastId() {
		// TODO Auto-generated method stub
		return 11;
	}
    

}


