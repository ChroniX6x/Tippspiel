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
import de.hoffit.tipp.view.component.SeasonEditDialog;

/**
 * @author Tony
 * 
 */
public class SeasonEditDialogMediator extends Notifier implements IMediator,
		INotifier {
	private static Logger log = LoggerFactory
			.getLogger(SeasonEditDialogMediator.class);

	private final String MEDIATOR_NAME = SeasonEditDialogMediator.class
			.getSimpleName();

	private SeasonEditDialog editDialog;

	@Override
	public String getMediatorName() {
		return MEDIATOR_NAME;
	}

	@Override
	public Object getViewComponent() {
		return this.editDialog;
	}

	@Override
	public void setViewComponent(Object viewComponent) {
		SeasonEditDialog editDialog = null;
		try {
			editDialog = (SeasonEditDialog) viewComponent;
		} catch (ClassCastException e) {
			// TODO 2: logging
		}
		this.editDialog = editDialog;
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
		if (this.editDialog != null) {
			this.editDialog.setVisible(true);
		}
	}

}
