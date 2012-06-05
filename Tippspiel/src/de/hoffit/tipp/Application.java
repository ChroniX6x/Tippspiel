package de.hoffit.tipp;

import java.util.Map;

import de.hoffit.tipp.view.Gui;

/**
 * @author Tony
 * 
 */
public class Application {

	private Gui gui;

	public Application() {

		this.gui = new Gui();

		startup();
	}

	private void startup() {

		AppFacade.getInst().load(this);

	}
	
	public Map<String,Object> getViewElements() {
		return this.gui.getViewElements();
	}

}
