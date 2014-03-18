package cs509.grp8.arest.common;

import java.awt.event.KeyEvent;

public class TextFieldFilter {

	public static final int ALL = 1;
	public static final int NUM = 2;
	public static final int ALPHA = 3;
	public static final int ALPHA_NUMERIC = 4;
	
	private int acceptedType;
	private boolean spacesOK;
	private boolean alphaOK;
	private boolean numericOK;
	
	private int maximumSize;
	
	private int count;
	
	public TextFieldFilter(int type, int maxSize) {
		this.acceptedType = type;
		this.setMaximumSize(maxSize);
		this.spacesOK = true; // Must be set by user if otherwise
		if(type != NUM){
			alphaOK = true;
		} else {
			alphaOK = false;
		}
		
		if(type != ALPHA){
			numericOK = true;
		}
		
		count = 0;
	}
	
	
	/**
	 * Updates the string depending on the character input in the KeyEvent.
	 * @param e
	 * @param s
	 * @return
	 */
	public StringBuilder updateString(KeyEvent e, StringBuilder s){
		if((count != 0) && (e.getKeyCode() == KeyEvent.VK_DELETE)) {
			count--;
		}
		
		if(count != maximumSize) {
			if(spacesOK && (e.getKeyCode() == KeyEvent.VK_SPACE)){
				s.append(e.getKeyChar());
				count++;
			}
			if(alphaOK && ((e.getKeyCode() == KeyEvent.VK_A) 
					|| (e.getKeyCode() == KeyEvent.VK_B)
					|| (e.getKeyCode() == KeyEvent.VK_C)
					|| (e.getKeyCode() == KeyEvent.VK_D)
					|| (e.getKeyCode() == KeyEvent.VK_E)
					|| (e.getKeyCode() == KeyEvent.VK_F)
					|| (e.getKeyCode() == KeyEvent.VK_G)
					|| (e.getKeyCode() == KeyEvent.VK_H)
					|| (e.getKeyCode() == KeyEvent.VK_I)
					|| (e.getKeyCode() == KeyEvent.VK_J)
					|| (e.getKeyCode() == KeyEvent.VK_K)
					|| (e.getKeyCode() == KeyEvent.VK_L)
					|| (e.getKeyCode() == KeyEvent.VK_M)
					|| (e.getKeyCode() == KeyEvent.VK_N)
					|| (e.getKeyCode() == KeyEvent.VK_O)
					|| (e.getKeyCode() == KeyEvent.VK_P)
					|| (e.getKeyCode() == KeyEvent.VK_Q)
					|| (e.getKeyCode() == KeyEvent.VK_R)
					|| (e.getKeyCode() == KeyEvent.VK_S)
					|| (e.getKeyCode() == KeyEvent.VK_T)
					|| (e.getKeyCode() == KeyEvent.VK_U)
					|| (e.getKeyCode() == KeyEvent.VK_V)
					|| (e.getKeyCode() == KeyEvent.VK_W)
					|| (e.getKeyCode() == KeyEvent.VK_X)
					|| (e.getKeyCode() == KeyEvent.VK_Y)
					|| (e.getKeyCode() == KeyEvent.VK_Z))){
				s.append(e.getKeyChar());
				count++;
			}
			if(numericOK && ((e.getKeyCode() == KeyEvent.VK_0) 
					|| (e.getKeyCode() == KeyEvent.VK_1)
					|| (e.getKeyCode() == KeyEvent.VK_2)
					|| (e.getKeyCode() == KeyEvent.VK_3)
					|| (e.getKeyCode() == KeyEvent.VK_4)
					|| (e.getKeyCode() == KeyEvent.VK_5)
					|| (e.getKeyCode() == KeyEvent.VK_6)
					|| (e.getKeyCode() == KeyEvent.VK_7)
					|| (e.getKeyCode() == KeyEvent.VK_8)
					|| (e.getKeyCode() == KeyEvent.VK_9))){
				s.append(e.getKeyChar());
				count++;
			}
		}
		return s;
	}

	/**
	 * Returns true if spaces are OK to have in this text field.
	 * @return
	 */
	public boolean isSpacesOK() {
		return spacesOK;
	}

	/**
	 * Set the spaces OK to allow or disallow spaces in a text field.
	 * @param spacesOK
	 */
	public void setSpacesOK(boolean spacesOK) {
		this.spacesOK = spacesOK;
	}



	public int getMaximumSize() {
		return maximumSize;
	}



	public void setMaximumSize(int maximumSize) {
		this.maximumSize = maximumSize;
	}
	
}
