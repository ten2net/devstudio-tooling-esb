/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface CallTemplateMediatorPropertiesEditionPart {

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);


	/**
	 * @return the availableTemplates
	 * 
	 */
	public String getAvailableTemplates();

	/**
	 * Defines a new availableTemplates
	 * @param newValue the new availableTemplates to set
	 * 
	 */
	public void setAvailableTemplates(String newValue);




	/**
	 * Init the templateParameters
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTemplateParameters(ReferencesTableSettings settings);

	/**
	 * Update the templateParameters
	 * @param newValue the templateParameters to update
	 * 
	 */
	public void updateTemplateParameters();

	/**
	 * Adds the given filter to the templateParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTemplateParameters(ViewerFilter filter);

	/**
	 * Adds the given filter to the templateParameters edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTemplateParameters(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the templateParameters table
	 * 
	 */
	public boolean isContainedInTemplateParametersTable(EObject element);


	/**
	 * @return the targetTemplate
	 * 
	 */
	public String getTargetTemplate();

	/**
	 * Defines a new targetTemplate
	 * @param newValue the new targetTemplate to set
	 * 
	 */
	public void setTargetTemplate(String newValue);





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
