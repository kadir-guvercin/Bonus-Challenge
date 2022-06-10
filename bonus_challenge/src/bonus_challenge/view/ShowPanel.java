package bonus_challenge.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class ShowPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSyntax;
	
	/**
	 * Create the panel.
	 */
	public ShowPanel() {
		setPreferredSize(new Dimension(300, 300));
		initComponents();
	}
	
	private void initComponents() {
		setBorder(new TitledBorder(null, "Show", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblSyntax = new GridBagConstraints();
		gbc_lblSyntax.fill = GridBagConstraints.BOTH;
		gbc_lblSyntax.gridx = 0;
		gbc_lblSyntax.gridy = 0;
		add(getLblSyntax(), gbc_lblSyntax);
	}
	
	public JLabel getLblSyntax() {
		if(lblSyntax == null) {
			lblSyntax = new JLabel();
			lblSyntax.setVerticalAlignment(SwingConstants.TOP);
		}
		return lblSyntax;
	}
}
