/**
 * 
 */
package de.hoffit.tipp.model.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.manager.ProjectManager;
import de.hoffit.tipp.model.TipSeason;

/**
 * @author Tony
 * 
 */
public class TipPanelProxy extends Proxy {

	public static final String NAME = "TippPanelProxy";

	private TipSeason data;

	public TipPanelProxy() {
		super(NAME, null);
		this.data = ProjectManager.getInstance().getSeason();
		sendNotification(AppFacade.DATA_CHANGED, getTableDataMap(0));
	}

	public Map<String, Vector<Vector<String>>> getTableDataMap(int day) {
		Vector<Vector<String>> gameData = this.data.getGamesForGameday(day);
		Vector<Vector<String>> playerData = this.data
				.getPlayerDataForGameday(day);
		Vector<Vector<String>> tipData = this.data.getTipDataForGameday(day);

		Map<String, Vector<Vector<String>>> dataMap = new HashMap<String, Vector<Vector<String>>>();

		dataMap.put("gameData", gameData);
		dataMap.put("playerData", playerData);
		dataMap.put("tipData", tipData);

		return dataMap;
	}
}
