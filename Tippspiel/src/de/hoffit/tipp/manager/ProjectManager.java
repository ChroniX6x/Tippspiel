/**
 * 
 */
package de.hoffit.tipp.manager;

import org.puremvc.java.patterns.observer.Notifier;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.model.Day;
import de.hoffit.tipp.model.Game;
import de.hoffit.tipp.model.Player;
import de.hoffit.tipp.model.Team;
import de.hoffit.tipp.model.TipSeason;

/**
 * @author Tony
 * 
 */
public class ProjectManager extends Notifier {

	private static ProjectManager instance;

	public static ProjectManager getInstance() {
		if (instance == null) {
			instance = new ProjectManager();
		}

		return instance;
	}

	/**
	 * TestMethod
	 * 
	 * @return
	 */
	private static TipSeason getTestSeason() {
		TipSeason season = new TipSeason();

		season.addPlayer(new Player("Tony"));

		Day day = new Day();

		for (int i = 0; i < 9; i++) {
			Game game = new Game(new Team("dfgh"), new Team("fghjkjhgf"),
					"13.09.2012");

			day.setGame(i, game);
		}

		season.setGameDay(0, day);

		return season;
	}

	private TipSeason season = getTestSeason();;

	private ProjectManager() {
	}

	public TipSeason getSeason() {
		return season;
	}

	public void setSeason(TipSeason season) {
		this.season = season;
		sendNotification(AppFacade.DATA_CHANGED);
	}
}
