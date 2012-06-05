/**
 * 
 */
package de.hoffit.tipp.view.component.model;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Tony
 * 
 */
public class TipPanelModel {

	private DefaultComboBoxModel cbDayChoiceModel;
	private DefaultTableModel gamesTblModel;
	private DefaultTableModel playerTblModel;
	private DefaultTableModel tipTblModel;

	public TipPanelModel() {

		String[] gameDayIds = new String[34];
		for (int i = 0; i < gameDayIds.length; i++) {
			gameDayIds[i] = "Gameday " + String.valueOf(i + 1);
		}

		this.cbDayChoiceModel = new DefaultComboBoxModel(gameDayIds);

		this.gamesTblModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		this.playerTblModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		this.tipTblModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	public DefaultComboBoxModel getCbDayChoiceModel() {
		return cbDayChoiceModel;
	}

	public DefaultTableModel getGamesTblModel() {
		return gamesTblModel;
	}

	public DefaultTableModel getPlayerTblModel() {
		return playerTblModel;
	}

	public DefaultTableModel getTipTblModel() {
		return tipTblModel;
	}

	public void setGameData(Vector<Vector<String>> game, Vector<String> ids) {
		this.gamesTblModel.setDataVector(game, ids);
	}

	public void setPlayerData(Vector<Vector<String>> player, Vector<String> ids) {
		this.playerTblModel.setDataVector(player, ids);
	}

	public void setTipData(Vector<Vector<String>> tip, Vector<String> ids) {
		this.tipTblModel.setDataVector(tip, ids);
	}

}
