<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
 <head>
	<title>Fantasy Team Standings</title>
 </head>
 <body>
	 <p>Fantasy Footbal Team standings</p>
	 <table>
		 <th>
			 <td>Name</td>
			 <td>Rank<td>
			 <td>Wins</td>
			 <td>Losses</td>
			 <td>Ties</td>
			 <td>Win Percentage</td>
			 <td>points For</td>
			 <td>Points Against</td>
		 </th>
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
