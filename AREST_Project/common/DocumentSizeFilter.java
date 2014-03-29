package common;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;

/**
 * This class is created to help format text fields in any JPanel.
 * @author Matt Orsini
 *
 */
public class DocumentSizeFilter extends DocumentFilter {

	/**
	 * Numeric characters accepted only.
	 */
	public static final int NO    = 1;
	/**
	 * Any combination of alpha-numeric characters accepted.
	 */
	public static final int AL_NO = 2;
	/**
	 * Only regular characters allowed.
	 */
	public static final int CHAR = 3;
	
	/**
	 * Anything allowed. Be careful here!
	 */
	public static final int ANY = 4;
	
	
	public static boolean DEBUG = false;
	
	private int acceptedType;
	private int maxCharacters;
	protected boolean isTypeAccepted;
	
	public DocumentSizeFilter(int maxCharacters){
		this.maxCharacters = maxCharacters;
		this.setAcceptedType(this.AL_NO);
	}
	
	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
		// Don't do anything if this string is unacceptable.
		if(!isAcceptable(str)){
			return;
		}
		if((fb.getDocument().getLength() + str.length()) > maxCharacters) {
			str = str.substring(0, this.maxCharacters);
		}
		System.out.println("Inserting " + str + " to the string.");
		super.insertString(fb, offs, str, a);
	}
	
	public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
		if(!isAcceptable(str)){
			return;
		}
		if((fb.getDocument().getLength() + str.length() - length) <= maxCharacters)
			super.replace(fb, offs, length, str, a);
	}
	
	public boolean isAcceptable(String s) {
		boolean acceptable = false;
		
		if(s == null) return acceptable;
		
		// Accept only numbers
		if(acceptedType == NO) {
			for(int i=0; i<s.length(); i++) {
				if(Character.isDigit(s.charAt(i))){
					acceptable = true;
				} else {
					return false;
				}
			}
		// Accept either number of regular character.
		} else if (acceptedType == AL_NO) {
			for(int i=0; i<s.length(); i++) {
				if(Character.isLetterOrDigit(s.charAt(i))){
					acceptable = true;
				} else {
					return false;
				}
			}
		// Accept only regular characters.
		} else if (acceptedType == CHAR){
			for(int i=0; i<s.length(); i++) {
				if(Character.isLetter(s.charAt(i))){
					acceptable = true;
				} else {
					return false;
				}
			}
		} else {
			acceptable = true;
		}
		return acceptable;
	}
	
	/**
	 * Get the maximum number of characters allowed for this document.
	 * @return
	 */
	public int getMaxCharacters(){
		return maxCharacters;
	}
	
	/**
	 * Set the maximum number of characters allowed for this document.
	 * @param maxCharacters
	 */
	public void setMaxCharacters(int maxCharacters){
		this.maxCharacters = maxCharacters;
	}

	/**
	 * Get the accepted type of character for this DocumentSizeFilter.
	 * @return
	 */
	public int getAcceptedType() {
		return acceptedType;
	}

	/**
	 * Set the accepted type of character for this DocumentSizeFilter.
	 * @param acceptedType
	 */
	public void setAcceptedType(int acceptedType) {
		this.acceptedType = acceptedType;
	}
	
	/**
	 * Accept a JTextComponent and filter to the acceptedType and maxSize parameters.
	 * Text will not be accepted if the acceptedType does not match, or if the maxSize
	 * has been reached.
	 * @param comp
	 * @param acceptedType
	 * @param maxSize
	 */
	public void setupTextField(JTextComponent comp, int acceptedType, int maxSize){
		AbstractDocument abstDoc = (AbstractDocument) comp.getDocument();
		DocumentSizeFilter filter = new DocumentSizeFilter(maxSize);
		filter.setAcceptedType(acceptedType);
		abstDoc.setDocumentFilter(filter);
	}
	
}
