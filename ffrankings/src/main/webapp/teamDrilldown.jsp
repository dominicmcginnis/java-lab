<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
 <head>
	<title>Team Drilldown</title>
 </head>
 <body>
	<c:set var="team" value="${requestScope.TEAM}" />

	<p>${team.name}'s team standing</p>
	 <table border=1>
		 <tr>
			 <th>Name</th>
			 <th>Rank</th>
			 <th>Wins</th>
			 <th>Losses</th>
			 <th>Ties</th>
			 <th>Win Percentage</th>
			 <th>Points For</th>
			 <th>Points Against</th>
		 </tr>
	<tr>
		<td>${team.name}</td>
		<td>${team.rank}</td>
		<td>${team.wins}</td>
		<td>${team.losses}</td>
		<td>${team.ties}</td>
		<td>${team.winPercentage}</td>
		<td>${team.pointsFor}</td>
		<td>${team.pointsAgainst}</td>
	</tr>
	</table>
	</br>
	<p>Matchups</p>
	<table border=1>
		 <tr>
			 <th>Opponent</th>
			 <th>Week Played</th>
			 <th>Score</th>
			 <th>Outcome</th>
		 </tr>
		<c:forEach var="match" items="${requestScope.MATCHES}">
	<tr>
		<td>${match.opponentName}</td>
		<td>${match.weekPlayed}</td>
		<td>${match.myScore} - ${match.opponentScore}</td>
		<td>${match.outcome}</td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>
