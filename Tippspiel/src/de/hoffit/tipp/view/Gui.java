package de.hoffit.tipp.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hoffit.tipp.view.component.MainFrame;
import de.hoffit.tipp.view.component.PlayerEditDialog;
import de.hoffit.tipp.view.component.SeasonEditDialog;
import de.hoffit.tipp.view.component.TeamEditDialog;
import de.hoffit.tipp.view.component.TipPanel;

/**
 * @author Tony
 * 
 */
public class Gui {
	private static Logger log = LoggerFactory.getLogger(Gui.class);

	private Map<String, Object> viewElements;

	/**
	 * 
	 */
	public Gui() {
		this.viewElements = new HashMap<String, Object>();
		init();
	}

	/**
	 * 
	 */
	private void init() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			log.warn("Ui not found");
		}

		MainFrame mainFrame = new MainFrame();

		TipPanel tippPanel = new TipPanel();

		mainFrame.addViewPanel("TippPanel", tippPanel);

		this.viewElements.put(MainFrame.class.getSimpleName(), mainFrame);
		this.viewElements.put(TipPanel.class.getSimpleName(), tippPanel);
		
		PlayerEditDialog playerEditDialog = new PlayerEditDialog();
		this.viewElements.put(PlayerEditDialog.class.getSimpleName(), playerEditDialog);
		
		// TeamEditDialog teamEditDialog = new TeamEditDialog();
		// this.viewElements.put(TeamEditDialog.class.getSimpleName(), teamEditDialog);
		
		SeasonEditDialog seasonEditDialog = new SeasonEditDialog();
		this.viewElements.put(SeasonEditDialog.class.getSimpleName(), seasonEditDialog);
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, Object> getViewElements() {
		return this.viewElements;
	}
}
