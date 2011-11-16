package org.irishhombre.documents;

import org.irishhombre.ds.mongo.MongoDAO;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;

import java.util.List;
import java.util.ArrayList;

public class Teams {
	private static String COLLECTION_NAME = "teams";
	
	public List<Team> getAllTeams() {
		MongoDAO mongo = new MongoDAO();

		List<Team> teams = new ArrayList<Team>();
		System.out.println("Calling mongo for getting all for collection: " + COLLECTION_NAME);
		DBCursor cursor = mongo.queryCollection(COLLECTION_NAME, null);
		System.out.println("Returned the following collection size: " + cursor.count());
		while(cursor.hasNext()) {
			DBObject team = cursor.next();
			teams.add(populateTeam(team));
		}
		return teams;		
	}

	public Team getTeam(String teamName) {
		MongoDAO mongo = new MongoDAO();

		BasicDBObject query = new BasicDBObject();
		query.put("name", teamName);
		
		Team t = null;
		DBCursor cursor = mongo.queryCollection(COLLECTION_NAME, query);
		while(cursor.hasNext()) {
			DBObject team = cursor.next();
			t = populateTeam(team);
		}
		return t;
	}
	
	private Team populateTeam(DBObject team) {
		Team t = new Team();

		t.setName((String)team.get("name"));

		DBObject summary = (DBObject)team.get("summary");
		t.setWins(((Integer)summary.get("wins")).intValue());
		t.setLosses(((Integer)summary.get("losses")).intValue());
		t.setTies(((Integer)summary.get("ties")).intValue());
		t.setWinPercentage(((Double)summary.get("winPercentage")).doubleValue());
		t.setPointsFor(((Double)summary.get("pointsFor")).doubleValue());
		t.setPointsAgainst(((Double)summary.get("pointsAgainst")).doubleValue());
		t.setRank(((Integer)summary.get("rank")).intValue());
		
		return t;
	}

	public class Team {
		private String name;
		private int wins;
		private int losses;
		private int ties;
		private double winPercentage;
		private double pointsFor;
		private double pointsAgainst;
		private int rank;

		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getWins() {
			return this.wins;
		}
		public void setWins(int wins) {
			this.wins = wins;
		}
		public int getLosses() {
			return this.losses;
		}
		public void setLosses(int losses) {
			this.losses = losses;
		}
		public int getTies() {
			return this.ties;
		}
		public void setTies(int ties) {
			this.ties = ties;
		}
		public double getWinPercentage() {
			return this.winPercentage;
		}
		public void setWinPercentage(double winPercentage) {
			this.winPercentage = winPercentage;
		}
		public double getPointsFor() {
			return this.pointsFor;
		}
		public void setPointsFor(double pointsFor) {
			this.pointsFor = pointsFor;
		}
		public double getPointsAgainst() {
			return pointsAgainst;
		}
		public void setPointsAgainst(double pointsAgainst) {
			this.pointsAgainst = pointsAgainst;
		}
		public int getRank() {
			return this.rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
	}
}
