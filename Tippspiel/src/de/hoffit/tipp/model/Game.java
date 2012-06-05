/**
 * 
 */
package de.hoffit.tipp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tony
 * 
 */
public class Game {

	private Team home;
	private Team guest;
	private int resultHome;
	private int resultGuest;
	private String date;

	private List<Tip> tipHandlerList;

	public Game(Team home, Team guest, String date) {
		this.tipHandlerList = new ArrayList<Tip>();

		this.home = home;
		this.guest = guest;
		this.date = date;

		this.resultHome = -1;
		this.resultGuest = -1;
	}

	private void firePropertyChanged() {
		for (Tip handler : this.tipHandlerList) {
			handler.onGameChanged();
		}
	}

	private void addGameChangedHandler(Tip handler) {
		this.tipHandlerList.add(handler);
	}

	private void removeGameChangedHandler(Tip handler) {
		this.tipHandlerList.remove(handler);
	}

	public String getGameString() {
		StringBuilder builder = new StringBuilder();

		builder.append(date);
		builder.append("/ /");

		if (home != null) {
			builder.append(home.getName());
		}

		builder.append("/");
		builder.append(":");
		builder.append("/");
		if (guest != null) {
			builder.append(guest.getName());
		}
		builder.append("/ /");

		if (resultHome >= 0 && resultGuest >= 0) {
			builder.append(resultHome + ":" + resultGuest);
		}
		return builder.toString();
	}

}
