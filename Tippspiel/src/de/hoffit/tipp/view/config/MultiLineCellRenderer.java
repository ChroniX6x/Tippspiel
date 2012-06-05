/**
 * 
 */
package de.hoffit.tipp.view.config;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Tony
 * 
 */
public class MultiLineCellRenderer extends JLabel implements TableCellRenderer {
	private static final long serialVersionUID = -7098254103439643900L;

	public MultiLineCellRenderer() {
		super();
		setHorizontalAlignment(CENTER);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		String string = value == null ? "" : value.toString();
		StringBuilder b = new StringBuilder();
		StringTokenizer toki = new StringTokenizer(string, "/");

		b.append("<html>");
		b.append("<center>");
		while (toki.hasMoreTokens()) {
			b.append(toki.nextToken());
			b.append("<br>");
		}
		b.append("</center>");
		b.append("</html>");

		setText(b.toString());
		return this;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Graphics2D g2 = (Graphics2D) g;
		//
		// AffineTransform trans = g2.getTransform();
		// trans.rotate(-90);
		//
		// super.paint(g2);
		//
		// trans.rotate(90);
	}

}
