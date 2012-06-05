/**
 * 
 */
package de.hoffit.tipp.model;

import java.util.Vector;

/**
 * @author Tony
 * 
 */
public class Player {

	private String name;
	private Tip[][] tips;

	private int points;

	public Player(String name) {
		this.tips = new Tip[34][9];
		this.name = name;
	}

	public Vector<String> getPlayerStats(int day, boolean all) {
		Vector<String> result = new Vector<>();
		// TODO 1: implement
		result.add(name);
		result.add("");
		result.add("");

		return result;
	}

	public Vector<String> getPlayerTips(int day) {
		Vector<String> result = new Vector<>();

		for (int i = 0; i < this.tips[day].length; i++) {
			Tip tip = this.tips[day][i];
			if (tip != null) {
				result.add(tip.getTip());
			} else {
				result.add(":");
			}
		}

		return result;
	}
}
