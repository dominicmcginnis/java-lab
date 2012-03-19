package org.irishhombre.documents;

import org.irishhombre.ds.mongo.MongoDAO;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;


import java.util.List;
import java.util.ArrayList;

public class Matchups {
	private static String COLLECTION_NAME = "matchups";

	public List<Matchup> getMatchups(String teamName) {
		MongoDAO mongo = new MongoDAO();

		List<Matchup> matchups = new ArrayList<Matchup>();
		System.out.println("Calling mongo to get collection: " + COLLECTION_NAME + " filtered by key" + teamName);
		BasicDBObject query = new BasicDBObject();
		query.put("name", teamName);
		
		DBCursor cursor = mongo.queryCollection(COLLECTION_NAME, query);
		System.out.println("Returned the following collection size: " + cursor.count());
		while(cursor.hasNext()) {
			DBObject matchup = cursor.next();
			matchups.add(populateMatchup(matchup, mongo));
		}
		return matchups;		

	}

	private Matchup populateMatchup(DBObject matchup, MongoDAO mongo) {
		Matchup m = new Matchup();
		
		//Populate the Matchup data from the matchup object
		m.setMyName((String)matchup.get("name"));
		m.setOpponentName((String)matchup.get("opponent"));
		m.setWeekPlayed(((Integer)matchup.get("weekPlayed")).intValue());
		m.setMyScore(((Double)matchup.get("myScore")).doubleValue());
		m.setOpponentScore(((Double)matchup.get("opponentScore")).doubleValue());
		m.setOutcome((String)matchup.get("outcome"));

		return m;
	}

	public class Matchup {
		private String myName;
		private String opponentName;
		private int weekPlayed;
		private double myScore;
		private double opponentScore;
		private String outcome;

		public String getMyName() {
			return this.myName;
		}
		public void setMyName(String myName) {
			this.myName = myName;
		}
		public String getOpponentName() {
			return this.opponentName;
		}
		public void setOpponentName(String opponentName) {
			this.opponentName = opponentName;
		}
		public int getWeekPlayed() {
			return this.weekPlayed;
		}
		public void setWeekPlayed(int weekPlayed) {
			this.weekPlayed = weekPlayed;
		}
		public double getMyScore() {
			return this.myScore;
		}
		public void setMyScore(double myScore) {
			this.myScore = myScore;
		}
		public double getOpponentScore() {
			return this.opponentScore;
		}
		public void setOpponentScore(double opponentScore) {
			this.opponentScore = opponentScore;
		}
		public String getOutcome() {
			return this.outcome;
		}
		public void setOutcome(String outcome) {
			this.outcome = outcome;
		}

	}
}

