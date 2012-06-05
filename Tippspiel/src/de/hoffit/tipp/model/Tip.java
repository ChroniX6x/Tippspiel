/**
 * 
 */
package de.hoffit.tipp.model;

/**
 * @author Tony
 * 
 */
public class Tip {

	private Game game;
	private int teamOneTip;
	private int teamTwoTip;
	private int points;

	public Tip(Game game, int teamOneTip, int teamTwoTip) {
		this.game = game;
		this.teamOneTip = teamOneTip;
		this.teamTwoTip = teamTwoTip;

	}

	public void onGameChanged() {

	}

	public String getTip() {
		StringBuilder builder = new StringBuilder();

		if (this.teamOneTip != -1) {
			builder.append(this.teamOneTip);
		}

		builder.append(":");

		if (this.teamTwoTip != -1) {
			builder.append(this.teamTwoTip);
		}

		return builder.toString();
	}

}
