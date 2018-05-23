package view;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	public ToolBar(){
		JComboBox<Object> fuck = new JComboBox<>();
		JButton addPlayer = new JButton("Add Player");	
		JButton placeBet = new JButton("Place Bet");
		add(addPlayer);
		add(placeBet);
		
	}
}
