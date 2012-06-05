package de.hoffit.tipp.view.mediator;
import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.interfaces.INotifier;
import org.puremvc.java.patterns.observer.Notifier;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.view.component.MainFrame;

/**
 * 
 */

/**
 * @author Tony
 * 
 */
public class MainFrameMediator extends Notifier implements IMediator, INotifier {

	private final String MEDIATOR_NAME = "MainFrameMediator";

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
