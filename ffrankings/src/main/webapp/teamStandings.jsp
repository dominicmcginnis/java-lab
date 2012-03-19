<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
 <head>
	<title>Fantasy Team Standings</title>
 </head>
 <body>
	 <p>Fantasy Footbal Team standings</p>
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
		<c:forEach var="team" items="${requestScope.TEAMS}">
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
	</c:forEach>
	</table>

</body>
</html>
