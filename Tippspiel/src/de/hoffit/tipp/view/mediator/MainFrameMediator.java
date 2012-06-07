package de.hoffit.tipp.view.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToggleButton.ToggleButtonModel;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.interfaces.INotifier;
import org.puremvc.java.patterns.observer.Notifier;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.view.component.MainFrame;
import de.hoffit.tipp.view.component.PlayerEditDialog;

/**
 * 
 */

/**
 * @author Tony
 * 
 */
public class MainFrameMediator extends Notifier implements IMediator, INotifier {

	private final String MEDIATOR_NAME = MainFrameMediator.class
			.getSimpleName();

	private MainFrame mainFrame;

	@Override
	public String getMediatorName() {
		return MEDIATOR_NAME;
	}

	@Override
	public Object getViewComponent() {
		return this.mainFrame;
	}

	@Override
	public void setViewComponent(Object viewComponent) {
		MainFrame mainFrame = null;
		try {
			mainFrame = (MainFrame) viewComponent;
		} catch (ClassCastException e) {
			// TODO 2: logging
		}
		this.mainFrame = mainFrame;
		addListener();
	}

	private void addListener() {
		this.mainFrame.setActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleEvent(e);
			}
		});
	}

	private void handleEvent(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(MainFrame.SEASON_PREFERENCES)) {
			sendNotification(AppFacade.VIEW_OPEN_DIALOG, null,
					SeasonEditDialogMediator.class.getSimpleName());

			return;
		}

		if (command.equals(MainFrame.SEASON_PLAYERS)) {
			sendNotification(AppFacade.VIEW_OPEN_DIALOG, null,
					PlayerEditDialogMediator.class.getSimpleName());

			return;
		}
	}

	@Override
	public String[] listNotificationInterests() {
		return new String[] { AppFacade.STARTUP };
	}

	@Override
	public void handleNotification(INotification notification) {
		if (notification.getName().equals(AppFacade.STARTUP)) {
			if (this.mainFrame != null) {
				this.mainFrame.setVisible(true);
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
}
