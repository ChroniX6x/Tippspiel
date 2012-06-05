/**
 * 
 */
package de.hoffit.tipp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Tony
 * 
 */
public class TipSeason {

	private List<Player> playerList;
	private Day[] dayList;

	public TipSeason() {
		this.playerList = new ArrayList<Player>();
		this.dayList = new Day[34];
	}

	public Vector<Vector<String>> getGamesForGameday(int dayNr) {
		if (dayNr < 0 || dayNr > this.dayList.length - 1) {
			return new Vector<Vector<String>>();
		}

		Day day = this.dayList[dayNr];

		if (day == null) {
			return new Vector<Vector<String>>();
		}

		Vector<Vector<String>> games = day.getGames();

		return games;
	}

	public Vector<Vector<String>> getPlayerDataForGameday(int day) {
		Vector<Vector<String>> result = new Vector<>();

		for (Player currPLayer : playerList) {
			Vector<String> playerStat = currPLayer.getPlayerStats(day, true);
			result.add(playerStat);
		}

		return result;
	}

	public Vector<Vector<String>> getTipDataForGameday(int day) {
		Vector<Vector<String>> result = new Vector<>();

		for (Player currPLayer : playerList) {
			Vector<String> playerTips = currPLayer.getPlayerTips(day);
			result.add(playerTips);
		}

		return result;
	}

	public void addPlayer(Player player) {
		this.playerList.add(player);
	}

	public void removePlayer(Player player) {
		this.playerList.remove(player);
	}

	public void setGameDay(int i, Day day) {
		this.dayList[i] = day;
	}

	public Day getGameDay(int i) {
		return this.dayList[i];
	}
}
