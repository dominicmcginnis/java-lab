FFRankings is a demo app for learning Groovy, mongoDB and Maven.

Story:  An application showing rankings of fantasy football teams with the ability to update stats and run custom scripts upon the stats.

1.  Use maven to structure the project
2.  Run on Tomcat 7.
3.  A simple struts App for displaying the rankings pages
4.  The datamodel will be contained within mongoDB
5.  The DAO's will utilize morphia for integrating to mongoDB
6.  Deploy a groovy web console for allowing custom real-time queries of the stat data.


mongoDB Design

Use cases:
View an individual team's full scoreboard history.
	List of weekly matchups: oppenent, myscore, oppenent score, outcome, week played
View an individual team's record summary.
	Rank, Team, wins, losses, ties, win percentage, points scored, points against, win streak
View the summary of all team's records.
	List of all teams record summary.


*Simplest is embedd nothing*
team : { 
  id : int, 
  name : string
}
summary : {
  team : team.id,
  wins : int,
  losses : int,
  ties : int,
  winPercentage : double,
  pointsFor : double,
  pointsAgainst : double,
  winStreak : int,
  rank : int
}
matchup : {
  team : team.id,
  opponent : team.id,  
  weekPlayed : int,
  myScore : double,
  opponentScore : double,
  outcome : string
}

*Embed summary*
team : { 
  id : int, 
  name : string
  summary : {
  	wins : int,
  	losses : int,
  	ties : int,
  	winPercentage : double,
  	pointsFor : double,
  	pointsAgainst : double,
  	rank : int
  }
}
matchup : {
  team : team.id,
  opponent : team.id,  
  weekPlayed : int,
  myScore : double,
  opponentScore : double,
  outcome : string
}

We will use the embed summary option.