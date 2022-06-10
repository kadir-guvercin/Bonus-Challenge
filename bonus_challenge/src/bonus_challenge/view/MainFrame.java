package bonus_challenge.view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
	}
	
	private void initComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.fill = GridBagConstraints.BOTH;
		gbc_topPanel.gridx = 0;
		gbc_topPanel.gridy = 0;
		getContentPane().add(getTopPanel(), gbc_topPanel);
		
		GridBagConstraints gbc_bottomPanel = new GridBagConstraints();
		gbc_bottomPanel.fill = GridBagConstraints.BOTH;
		gbc_bottomPanel.gridx = 0;
		gbc_bottomPanel.gridy = 1;
		getContentPane().add(getBottomPanel(), gbc_bottomPanel);
	}
	
	public JPanel getTopPanel() {
		if(topPanel == null) {
			topPanel = new JPanel();
			topPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		}
		return topPanel;
	}
	
	public JPanel getBottomPanel() {
		if(bottomPanel == null) {
			bottomPanel = new JPanel();
			bottomPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		}
		return bottomPanel;
	}
}
