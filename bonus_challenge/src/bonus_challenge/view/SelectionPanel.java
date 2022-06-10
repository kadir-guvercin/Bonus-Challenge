package bonus_challenge.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;

public class SelectionPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSelectKeyword;
	private JList<Object> listKeyword;
	
	
	/**
	 * Create the panel.
	 */
	public SelectionPanel() {
		setPreferredSize(new Dimension(300, 200));
		initComponents();
	}
	
	private void initComponents() {
		setBorder(new TitledBorder(null, "Selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblSelectKeyword = new GridBagConstraints();
		gbc_lblSelectKeyword.anchor = GridBagConstraints.NORTH;
		gbc_lblSelectKeyword.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelectKeyword.gridx = 0;
		gbc_lblSelectKeyword.gridy = 0;
		add(getLblSelectKeyword(), gbc_lblSelectKeyword);
		
		GridBagConstraints gbc_listKeywords = new GridBagConstraints();
		gbc_listKeywords.fill = GridBagConstraints.BOTH;
		gbc_listKeywords.gridx = 1;
		gbc_listKeywords.gridy = 0;
		add(getListKeyword(), gbc_listKeywords);
	}
	
	public JLabel getLblSelectKeyword() {
		if(lblSelectKeyword == null) {
			lblSelectKeyword = new JLabel("Select Keyword : ");
		}
		return lblSelectKeyword;
	}
	
	public JList<Object> getListKeyword() {
		if(listKeyword == null) {
			listKeyword = new JList<Object>();
			listKeyword.setVisibleRowCount(7);
			listKeyword.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listKeyword;
	}

}
