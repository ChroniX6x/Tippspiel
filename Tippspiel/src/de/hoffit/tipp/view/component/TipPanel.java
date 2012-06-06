package de.hoffit.tipp.view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import de.hoffit.tipp.view.component.model.TipPanelModel;
import de.hoffit.tipp.view.config.MultiLineCellRenderer;
import de.hoffit.tipp.view.config.RotatedTableCellRenderer;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class TipPanel extends JPanel {

	public static final String DAY_CHOICE = "dayChoice";

	private static final long serialVersionUID = 8488504806410446897L;

	private JPanel daysPnl;
	private JPanel playerPnl;
	private JPanel gamesPnl;
	private JPanel tipPnl;
	private JTable gamesTbl;
	private JComboBox cbDayChoice;
	private JTable playerTbl;
	private JTable tipTbl;
	private JLabel lblDayChoice;
	private JToggleButton tglbtnAllPoints;

	private TipPanelModel model;

	/**
	 * Create the panel.
	 */
	public TipPanel() {
		this.model = new TipPanelModel();

		initComponents();
	}

	@SuppressWarnings("serial")
	private void initComponents() {
		this.setLayout(new MigLayout("", "[200px:n:200px][grow]",
				"[200px:n:200px,fill][grow]"));

		this.daysPnl = new JPanel();
		this.daysPnl.setBackground(Color.WHITE);
		this.add(this.daysPnl, "cell 0 0,grow");
		this.daysPnl.setLayout(null);

		this.cbDayChoice = new JComboBox();
		this.cbDayChoice.setBounds(50, 85, 100, 29);
		this.cbDayChoice.setModel(this.model.getCbDayChoiceModel());
		this.daysPnl.add(this.cbDayChoice);

		this.lblDayChoice = new JLabel("Day Choice");
		this.lblDayChoice.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblDayChoice.setBounds(50, 60, 100, 14);
		this.daysPnl.add(this.lblDayChoice);

		this.tglbtnAllPoints = new JToggleButton("All points");
		this.tglbtnAllPoints.setBounds(61, 166, 78, 28);
		this.daysPnl.add(this.tglbtnAllPoints);

		this.gamesPnl = new JPanel();
		this.gamesPnl.setBackground(Color.WHITE);
		this.add(this.gamesPnl, "cell 1 0,grow");
		this.gamesPnl.setLayout(new BorderLayout(0, 0));

		this.gamesTbl = new JTable();
		this.gamesTbl.setFillsViewportHeight(true);
		this.gamesTbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		this.gamesTbl.setDefaultRenderer(Object.class,
				new MultiLineCellRenderer());
		this.gamesTbl.setRowHeight(200);
		this.gamesTbl.getTableHeader().setResizingAllowed(false);

		// hide>>
		Enumeration<TableColumn> colEnum = this.gamesTbl.getColumnModel()
				.getColumns();
		while (colEnum.hasMoreElements()) {
			TableColumn tblCol = (TableColumn) colEnum.nextElement();
			tblCol.setMinWidth(80);

		}
		// hide<<
		this.gamesTbl.setModel(this.model.getGamesTblModel());
		this.gamesTbl.getTableHeader().setReorderingAllowed(false);

		this.gamesPnl.add(this.gamesTbl, BorderLayout.NORTH);

		this.playerPnl = new JPanel();
		this.playerPnl.setBackground(Color.WHITE);
		this.add(this.playerPnl, "cell 0 1,grow");
		this.playerPnl.setLayout(new BorderLayout(0, 0));

		this.playerTbl = new JTable();
		this.playerTbl.setModel(this.model.getPlayerTblModel());
		this.playerTbl.setDefaultRenderer(Object.class,
				new MultiLineCellRenderer());
		this.playerTbl.getTableHeader().setReorderingAllowed(false);
		this.playerTbl.getTableHeader().setResizingAllowed(false);

		// hide>>
		colEnum = this.playerTbl.getColumnModel().getColumns();
		while (colEnum.hasMoreElements()) {
			TableColumn tblCol = (TableColumn) colEnum.nextElement();
			tblCol.setMinWidth(50);
			tblCol.setResizable(false);
		}
		// hide<<

		this.playerPnl.add(this.playerTbl, BorderLayout.CENTER);
		this.playerPnl.add(this.playerTbl.getTableHeader(), BorderLayout.NORTH);

		this.tipPnl = new JPanel();
		this.tipPnl.setBackground(Color.WHITE);
		this.add(this.tipPnl, "cell 1 1,grow");
		this.tipPnl.setLayout(new BorderLayout(0, 0));

		this.tipTbl = new JTable();
		this.tipTbl.setModel(this.model.getTipTblModel());
		this.tipTbl.getTableHeader().setReorderingAllowed(false);
		this.tipTbl.setDefaultRenderer(Object.class,
				new MultiLineCellRenderer());
		this.tipTbl.getTableHeader().setResizingAllowed(false);

		// hide>>
		colEnum = this.tipTbl.getColumnModel().getColumns();
		while (colEnum.hasMoreElements()) {
			TableColumn tblCol = (TableColumn) colEnum.nextElement();
			tblCol.setMinWidth(50);
			tblCol.setResizable(false);

		}
		// hide<<

		this.tipPnl.add(this.tipTbl);
		this.tipPnl.add(this.tipTbl.getTableHeader(), BorderLayout.NORTH);
	}

	public void setActionListener(ActionListener listener) {
		this.cbDayChoice.addActionListener(listener);
		this.cbDayChoice.setActionCommand(DAY_CHOICE);

		this.tglbtnAllPoints.addActionListener(listener);
		this.tglbtnAllPoints.setActionCommand("allPoints");
	}

	public TipPanelModel getModel() {
		return this.model;
	}
}
