package org.irishhombre.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.irishhombre.documents.Teams;
import org.irishhombre.documents.Teams.Team;

import java.util.List;

public class TeamStandingsAction extends Action {

    public static String SUCCESS = "success";

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
	

	Teams teams = new Teams();
	List<Team> allTeams = teams.getAllTeams();

	System.out.println("Setting the teams attribute to: " + allTeams);
	request.setAttribute("TEAMS", allTeams);
	
        return mapping.findForward(SUCCESS);

    }

}

