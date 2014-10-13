package org.sample.controller.service;

import java.util.Date;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.NewTeamForm;
import org.sample.model.Team;
import org.sample.model.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class NewTeamServiceImpl {

	@Autowired
	TeamDao teamDao;

	@Transactional
	public NewTeamForm saveFrom(NewTeamForm newTeamForm)
			throws InvalidUserException {

		String team = newTeamForm.getTeam();

		if (StringUtils.isEmpty(team))				
			throw new InvalidUserException("you must give a team name!"); // throw
																				// exception
				
		Team newTeam = new Team();
		
		newTeam.setTeam(newTeamForm.getTeam());
		newTeam.setDate(new Date());

		newTeam = teamDao.save(newTeam); // save object to DB

		// Iterable<Address> addresses = addDao.findAll(); // find all
		// Address anAddress = addDao.findOne((long)3); // find by ID

		newTeamForm.setId(newTeam.getId());

		return newTeamForm;

	}
}
