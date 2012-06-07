/**
 * 
 */
package de.hoffit.tipp.view.mediator;

import java.awt.event.ActionEvent;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.interfaces.INotifier;
import org.puremvc.java.patterns.observer.Notifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.view.component.PlayerEditDialog;

/**
 * @author Tony
 * 
 */
public class PlayerEditDialogMediator extends Notifier implements IMediator,
		INotifier {
	private static Logger log = LoggerFactory
			.getLogger(PlayerEditDialogMediator.class);

	private final String MEDIATOR_NAME = PlayerEditDialogMediator.class
			.getSimpleName();

	private PlayerEditDialog playerDialog;

	@Override
	public String getMediatorName() {
		return MEDIATOR_NAME;
	}

	@Override
	public Object getViewComponent() {
		return this.playerDialog;
	}

	@Override
	public void setViewComponent(Object viewComponent) {
		PlayerEditDialog editDialog = null;
		try {
			editDialog = (PlayerEditDialog) viewComponent;
		} catch (ClassCastException e) {
			// TODO 2: logging
		}
		this.playerDialog = editDialog;
		addListener();
	}

	private void addListener() {

	}

	private void handleEvent(ActionEvent e) {

	}

	@Override
	public String[] listNotificationInterests() {
		return new String[] { AppFacade.VIEW_OPEN_DIALOG };
	}

	@Override
	public void handleNotification(INotification notification) {
		log.debug(notification.getName());
		if (notification.getName().equals(AppFacade.VIEW_OPEN_DIALOG)) {
			String type = notification.getType();

			if (type.equals(MEDIATOR_NAME)) {
				show();
			}
		}
	}

	@Override
	public void onRegister() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRemove() {
		// TODO Auto-generated method stub

	}

	/**
	 * Shows the player dialog
	 */
	private void show() {
		if (this.playerDialog != null) {
			this.playerDialog.setVisible(true);
		}
	}

}
