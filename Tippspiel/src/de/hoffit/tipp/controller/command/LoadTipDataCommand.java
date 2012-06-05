/**
 * 
 */
package de.hoffit.tipp.controller.command;

import java.util.Map;
import java.util.Vector;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import de.hoffit.tipp.AppFacade;
import de.hoffit.tipp.model.proxy.TipPanelProxy;

/**
 * @author Tony
 * 
 */
public class LoadTipDataCommand extends SimpleCommand {

	@Override
	public void execute(INotification notification) {

		int day = (int) notification.getBody();
		TipPanelProxy proxy = (TipPanelProxy) AppFacade.getInst()
				.retrieveProxy(TipPanelProxy.NAME);

		Object map = proxy.getTableDataMap(day);

		sendNotification(AppFacade.DATA_CHANGED, map);
	}

}
