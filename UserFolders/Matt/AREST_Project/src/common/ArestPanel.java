package common;

import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

public class ArestPanel extends JPanel {

	public ArestPanel() {
		
	}
	
	/**
	 * Check if a text component contains enough contents to be considered "Valid," or 
	 * satisfactory for this input from the user.
	 * @param textComp - The JTextComponent to check.
	 * @param minLen   - The minimum length for this textfield (length of string).      
	 * @return false if the length does not equal the minimum requirement, true if it does.
	 */
	public boolean isTextComponentValid(JTextComponent textComp, int minLen) {
		if (!(textComp.getText().length() == minLen))
			return false;
		else if (textComp.getText().length() == 0)
			return false;
		else
			return true;
	}
	
	/**
	 * Check if a text component contains ANY string contents to be considered "Valid," or
	 * satisfactory for this input from the user. 
	 * @param textComp - The JTextComponent to check.
	 * @return - False if the length is zero. True otherwise.
	 */
	public boolean isTextComponentValid(JTextComponent textComp) {
		if (textComp.getText().length() == 0)
			return false;
		else
			return true;
	}
	
}
