package de.hoffit.tipp;

import org.puremvc.java.patterns.facade.Facade;

import de.hoffit.tipp.controller.command.LoadCommand;
import de.hoffit.tipp.controller.command.LoadTipDataCommand;

public class AppFacade extends Facade {

	public static final String STARTUP = "STARTUP";
	public static final String LOAD = "LOAD";
	public static final String DATA_CHANGED = "DATA_CHANGED";

	public static final String VIEW_DAY_CHANGED = "DAY_CHANGED";
	public static final String VIEW_TOGGLE_ALL_POINTS = "TOGGLE_ALL_POINTS";

	private static AppFacade instance = null;

	public static AppFacade getInst() {
		if (instance == null) {
			instance = new AppFacade();
		}
		return (AppFacade) instance;
	}

	@Override
	protected void initializeController() {
		super.initializeController();

		super.registerCommand(LOAD, new LoadCommand());
		super.registerCommand(VIEW_DAY_CHANGED, new LoadTipDataCommand());
	}

	public void load(Application app) {
		this.sendNotification(LOAD, app, null);
	}
}
