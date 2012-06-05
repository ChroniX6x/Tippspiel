package de.hoffit.tipp.controller.command;

import java.util.Iterator;
import java.util.Map;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.Application;
import de.hoffit.tipp.model.proxy.TipPanelProxy;

/**
 * @author Tony
 * 
 */
public class LoadCommand extends SimpleCommand {
	private static Logger log = LoggerFactory.getLogger(LoadCommand.class);

	@Override
	public void execute(INotification notification) {

		Application app = (Application) notification.getBody();

		createMediators(app);

		createProxys(app);

		sendNotification(AppFacade.STARTUP);

		// facade.registerProxy(new DataModelProxy());
	}

	private void createMediators(Application app) {
		Map<String, Object> viewElementsMap = app.getViewElements();
		String mediatorPackage = "de.hoffit.tipp.view.mediator.";
		Iterator<String> viewKeysList = viewElementsMap.keySet().iterator();

		while (viewKeysList.hasNext()) {
			String viewKey = viewKeysList.next();
			Object viewElement = viewElementsMap.get(viewKey);
			String className = mediatorPackage + viewKey + "Mediator";
			IMediator mediator = null;
			
			try {
				mediator = (IMediator) Class.forName(className).newInstance();
			} catch (ReflectiveOperationException e) {
				log.warn("Mediator not found!");
			}

			if (mediator != null) {
				log.info("Mediator registered: "+mediator.toString());
				mediator.setViewComponent(viewElement);
				facade.registerMediator(mediator);
			}
		}
	}

	private void createProxys(Application app) {

		TipPanelProxy tPP = new TipPanelProxy();

		facade.registerProxy(tPP);
	}

}
