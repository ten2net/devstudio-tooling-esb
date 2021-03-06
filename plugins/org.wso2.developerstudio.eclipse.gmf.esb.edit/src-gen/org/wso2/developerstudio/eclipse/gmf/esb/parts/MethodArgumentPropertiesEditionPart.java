/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * 
 * 
 */
public interface MethodArgumentPropertiesEditionPart {

	/**
	 * @return the propertyName
	 * 
	 */
	public String getPropertyName();

	/**
	 * Defines a new propertyName
	 * @param newValue the new propertyName to set
	 * 
	 */
	public void setPropertyName(String newValue);


	/**
	 * @return the propertyValueType
	 * 
	 */
	public Enumerator getPropertyValueType();

	/**
	 * Init the propertyValueType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyValueType(Object input, Enumerator current);

	/**
	 * Defines a new propertyValueType
	 * @param newValue the new propertyValueType to set
	 * 
	 */
	public void setPropertyValueType(Enumerator newValue);


	/**
	 * @return the propertyValue
	 * 
	 */
	public String getPropertyValue();

	/**
	 * Defines a new propertyValue
	 * @param newValue the new propertyValue to set
	 * 
	 */
	public void setPropertyValue(String newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
