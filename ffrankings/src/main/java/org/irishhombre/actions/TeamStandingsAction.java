package org.irishhombre.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.irishhombre.documents.Teams;
import org.irishhombre.documents.Teams.Team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TeamStandingsAction extends Action {

    Logger logger = LoggerFactory.getLogger("org.irishhombre.actions.TeamStandingsAction");

    public static String SUCCESS = "success";

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
	

	Teams teams = new Teams();
	List<Team> allTeams = teams.getAllTeams();

	logger.info("Setting the teams attribute to: " + allTeams);
	request.setAttribute("TEAMS", allTeams);
	
        return mapping.findForward(SUCCESS);

    }

}

