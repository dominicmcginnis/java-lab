package org.irishhombre.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.irishhombre.documents.Teams;
import org.irishhombre.documents.Teams.Team;
import org.irishhombre.documents.Matchups.Matchup;
import org.irishhombre.documents.Matchups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeamDrilldownAction extends Action {

    Logger logger = LoggerFactory.getLogger("org.irishhombre.actions.TeamDrilldownAction");

    public static String SUCCESS = "success";

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
	

	String teamName = request.getParameter("teamName");
	
	if(teamName != null) {
		Teams teams = new Teams();
		Team team = teams.getTeam(teamName);
	
		logger.info("Setting the team attribute to: " + team);

		request.setAttribute("TEAM", team);

		if(team != null) {
			Matchups m = new Matchups();
			List<Matchup> matches = m.getMatchups(team.getName());

			request.setAttribute("MATCHES", matches);
		}
	}
       	return mapping.findForward(SUCCESS);

    }

}

