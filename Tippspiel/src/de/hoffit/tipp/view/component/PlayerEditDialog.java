package de.hoffit.tipp.view.component;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class PlayerEditDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblPlayerName;
	private JButton btnAddPlayer;
	private JButton btnRemovePlayer;
	private JButton btnEditPlayer;
	private JList list;
	private JButton btnRemoveAll;
	private JButton btnOk;
	private JButton btnCancel;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// try {
	// PlayerEditDialog dialog = new PlayerEditDialog();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public PlayerEditDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][50px:n:50px][grow,center]", "[grow][10px][grow][][][20px][]"));
		{
			this.list = new JList();
			this.list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Player", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(this.list, "cell 0 0 1 3,grow");
		}
		{
			this.lblPlayerName = new JLabel("Player Name");
			contentPanel.add(this.lblPlayerName, "flowx,cell 2 0,aligny bottom");
		}
		{
			this.textField = new JTextField();
			contentPanel.add(this.textField, "cell 2 0,growx,aligny bottom");
			this.textField.setColumns(10);
		}
		{
			this.btnAddPlayer = new JButton("Add Player");
			contentPanel.add(this.btnAddPlayer, "cell 2 2,growx,aligny top");
		}
		{
			this.btnRemovePlayer = new JButton("Remove Player");
			contentPanel.add(this.btnRemovePlayer, "cell 2 3,growx");
		}
		{
			this.btnRemoveAll = new JButton("Remove All");
			contentPanel.add(this.btnRemoveAll, "cell 0 4,growx");
		}
		{
			this.btnEditPlayer = new JButton("Edit Player");
			contentPanel.add(this.btnEditPlayer, "cell 2 4,growx");
		}
		{
			this.btnOk = new JButton("OK");
			contentPanel.add(this.btnOk, "flowx,cell 0 6 3 1,alignx center");
		}
		{
			this.btnCancel = new JButton("Cancel");
			contentPanel.add(this.btnCancel, "cell 0 6 3 1,alignx center");
		}
	}

}
