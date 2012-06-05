/**
 * 
 */
package de.hoffit.tipp.model;

import java.util.Vector;

/**
 * @author Tony
 * 
 */
public class Day {

	private Game[] games;

	public Day() {
		games = new Game[9];
	}

	public Game getGame(int i) {
		if (i < 0 || i >= this.games.length) {
			return null;
		}

		return this.games[i];
	}

	public void setGame(int i, Game game) {
		if (i < 0 || i >= this.games.length) {
			return;
		}
		this.games[i] = game;
	}

	public Vector<Vector<String>> getGames() {

		Vector<Vector<String>> result = new Vector<>();
		Vector<String> strVector = new Vector<>();

		for (Game game : games) {
			if (game != null) {
				strVector.add(game.getGameString());
			} else {
				strVector.add("");
			}
		}

		result.add(strVector);

		return result;
	}

}
