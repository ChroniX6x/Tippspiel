package de.hoffit.tipp.view.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToggleButton.ToggleButtonModel;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.interfaces.INotifier;
import org.puremvc.java.patterns.observer.Notifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.view.component.TipPanel;
import de.hoffit.tipp.view.component.model.TipPanelModel;

/**
 * 
 */

/**
 * @author Tony
 * 
 */
public class TipPanelMediator extends Notifier implements IMediator, INotifier {
	private static Logger log = LoggerFactory.getLogger(TipPanelMediator.class);

	private final String MEDIATOR_NAME = "TipPanelMediator";

	private TipPanel tipPanel;
	private TipPanelModel tipModel;

	private Vector<String> gameIds;

	private Vector<String> playerIDs;
	private Vector<String> playerDayIDs;

	@Override
	public String getMediatorName() {
		return MEDIATOR_NAME;
	}

	@Override
	public Object getViewComponent() {
		return this.tipPanel;
	}

	@Override
	public void setViewComponent(Object viewComponent) {
		TipPanel tippPanel = null;
		try {
			tippPanel = (TipPanel) viewComponent;
			this.tipModel = tippPanel.getModel();
		} catch (ClassCastException e) {
			// TODO 2: logging
		}
		this.tipPanel = tippPanel;
		addListener();
	}

	private void addListener() {
		this.tipPanel.setActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleEvent(e);
			}
		});
	}

	private void handleEvent(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(TipPanel.DAY_CHOICE)) {
			JComboBox source = (JComboBox) e.getSource();
			sendNotification(AppFacade.VIEW_DAY_CHANGED,
					source.getSelectedIndex());
			return;
		}

		if (command.equals("allPoints")) {
			JToggleButton source = (JToggleButton) e.getSource();
			ToggleButtonModel sourceModel = (ToggleButtonModel) source
					.getModel();
			sendNotification(AppFacade.VIEW_TOGGLE_ALL_POINTS,
					sourceModel.isSelected());
		}
	}

	@Override
	public String[] listNotificationInterests() {
		// TODO Auto-generated method stub
		return new String[] { AppFacade.STARTUP, AppFacade.DATA_CHANGED };
	}

	@Override
	public void handleNotification(INotification notification) {
		log.debug(notification.getName());
		if (notification.getName().equals(AppFacade.DATA_CHANGED)) {

			Map<String, Vector<Vector<String>>> data = (Map<String, Vector<Vector<String>>>) notification
					.getBody();
			refreshView(data);
		}

	}

	@SuppressWarnings("unchecked")
	private void refreshView(Map<String, Vector<Vector<String>>> data) {
		Iterator<String> it = data.keySet().iterator();

		while (it.hasNext()) {
			String key = (String) it.next();

			Object d = data.get(key);
			if (d != null) {
				log.debug(key + ":" + d.toString());

				if (key.equals("gameData")) {
					Vector<Vector<String>> v = (Vector<Vector<String>>) d;
					this.tipModel.setGameData(v, gameIds);
				}

				if (key.equals("playerData")) {
					Vector<Vector<String>> v = (Vector<Vector<String>>) d;
					this.tipModel.setPlayerData(v, playerIDs);
				}

				if (key.equals("tipData")) {
					Vector<Vector<String>> v = (Vector<Vector<String>>) d;
					this.tipModel.setTipData(v, gameIds);
				}
			}
		}
	}

	@Override
	public void onRegister() {
		this.gameIds = new Vector<>();
		for (int i = 0; i < 9; i++) {
			this.gameIds.add("Game " + String.valueOf(i + 1));
		}

		this.playerIDs = new Vector<>();
		this.playerIDs.add("Name");
		this.playerIDs.add("Ranc");
		this.playerIDs.add("Points");

		this.playerDayIDs = new Vector<>();
		this.playerDayIDs.add("Name");
		this.playerDayIDs.add("DayRanc");
		this.playerDayIDs.add("DayPoints");
	}

	@Override
	public void onRemove() {
		// TODO Auto-generated method stub

	}

	// public void showWholeRanc(boolean wholeRanc) {
	// if (wholeRanc) {
	// this.playerTblModel.setColumnIdentifiers(playerIDs);
	// } else {
	// this.playerTblModel.setColumnIdentifiers(playerDayIDs);
	// }
	// }

}
