package common;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * Use this document listener to observe changes in a JTextField type component.
 * @author Matt Orsini
 *
 */
public class ArestDocumentListener implements DocumentListener{
	public boolean isUpdated = false;
	
	private int count = 0;
	
	private DocumentSizeFilter filter;
	@Override
	public void changedUpdate(DocumentEvent e) {
		// Unaffected.
	}

	/**
	 * Notifies if the document has inserted text. Checks the filter set by this document to determine if the
	 * text entered is valid before displaying the text.
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		isUpdated = true;
		try {
			if(filter.isAcceptable(e.getDocument().getText(count, 1))){
				count++;
				System.out.println("Adding " + e.getDocument().getText(0, count));
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Keeps track of the count by observing the length of the document.
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		count = e.getDocument().getLength();
	}
	
	//FIXME: Are the following getters and setters really required?
	/**
	 * Set the filter for this DocumentListener.
	 * @param filter
	 */
	public void setFilter(DocumentSizeFilter filter) {
		this.filter = filter;
	}
	
	/**
	 * Gets the filter for this DocumentListener.
	 * @return
	 */
	public DocumentSizeFilter getFilter(){
		return filter;
	}

	/**
	 * Sets the filter's maxCharacters for this DocumentListener.
	 * @param size
	 */
	public void setFilterMaxCharacters(int size){
		filter.setMaxCharacters(size);
	}
	
	/**
	 * Gets the filter's maxCharacters for this DocumentListener.
	 * @return
	 */
	public int getFilterMaxCharacters(){
		return filter.getMaxCharacters();
	}
}
