package bonus_challenge.view.controller;

import java.util.Set;

import javax.swing.AbstractListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;

import bonus_challenge.main.ViewController;
import bonus_challenge.view.MainFrame;
import bonus_challenge.view.SelectionPanel;
import bonus_challenge.view.ShowPanel;

public class MainFrameController {
	private static MainFrameController instance = null;
	private boolean isInitilazed = false;
	private MainFrame mainFrame;
	private SelectionPanel selectionPanel;
	private ShowPanel showPanel;
	
	public static synchronized MainFrameController getInstance() {
		if(instance == null) {
			instance = new MainFrameController();
		}
		return instance;
	}
	
	public void init() {
		
		try {
			if(isInitilazed) {
				return;
			}
			
			initComponents();
			initComponentsData();
			initEvents();
			
			setVisible(true);
			
			isInitilazed = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void initComponents() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					
					try {
						
						mainFrame = new MainFrame();
						
						selectionPanel = new SelectionPanel();
						showPanel = new ShowPanel();
						
						mainFrame.getTopPanel().add(selectionPanel);
						mainFrame.getBottomPanel().add(showPanel);
						
						mainFrame.setLocationRelativeTo(null);
						mainFrame.pack();
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
			});
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initComponentsData() {
		try {
			
			setSelectionPanelKeywordListInitialData();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void initEvents() {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					
					try {
						
						selectionPanel.getListKeyword().addListSelectionListener(e -> doKeywordListSelection(e));
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
			});
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setVisible(boolean visible) {
		try {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						mainFrame.setVisible(visible);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doKeywordListSelection(ListSelectionEvent e) {
		String selectedValue = selectionPanel.getListKeyword().getSelectedValue().toString();
		String selectedValueContent = ViewController.getInstance().getFileContainer().get(selectedValue);
		setTextToShowPanelSyntaxLabel(selectedValueContent);
		
	}
	
	private void setTextToShowPanelSyntaxLabel(String text) {
		showPanel.getLblSyntax().setText(text);
	}
	
	private void setSelectionPanelKeywordListInitialData() {
		
		Set<String> keySet = ViewController.getInstance().getFileContainer().keySet();
		String[] _values = new String[keySet.size()];
		keySet.toArray(_values);
		
		selectionPanel.getListKeyword().setModel(new AbstractListModel<Object>() {
									private static final long serialVersionUID = 1L;
									String[] values = _values;
									public int getSize() {
										return values.length;
									}
									public Object getElementAt(int index) {
										return values[index];
									}
								});
		
	}
}
