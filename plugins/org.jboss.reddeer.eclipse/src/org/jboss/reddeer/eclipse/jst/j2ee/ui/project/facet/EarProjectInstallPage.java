package org.jboss.reddeer.eclipse.jst.j2ee.ui.project.facet;

import java.util.ArrayList;
import java.util.List;

import org.jboss.reddeer.eclipse.jst.j2ee.wizard.NewJ2EEComponentSelectionPage;
import org.jboss.reddeer.jface.wizard.WizardPage;
import org.jboss.reddeer.swt.api.TableItem;
import org.jboss.reddeer.swt.impl.button.CheckBox;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.table.DefaultTable;
import org.jboss.reddeer.swt.impl.text.LabeledText;

/**
 * The second wizard page for creating  EAR project.
 */
public class EarProjectInstallPage extends WizardPage{
	
	/**
	 * Opens a wizard page for adding new module.
	 * @return Wizard page for adding new module
	 */
	public NewJ2EEComponentSelectionPage newModule(){
		new PushButton("New Module...").click();
		new DefaultShell("Create default Java EE modules.");
		return new NewJ2EEComponentSelectionPage();
	}
	
	/**
	 * Selects all.
	 */
	public void selectAll(){
		new PushButton("Select All").click();
	}
	
	/**
	 * Deselects all.
	 */
	public void deselectAll(){
		new PushButton("Deselect All").click();
	}
	
	/**
	 * Returns list of module dependencies.
	 * 
	 * @return List of module dependencies
	 */
	public List<String> getJavaEEModuleDependencies(){
		List<String> modules = new ArrayList<String>();
		for(TableItem i: new DefaultTable().getItems()){
			modules.add(i.getText());
		}
		return modules;
	}
	
	/**
	 * Sets whether to select a given dependency.
	 * 
	 * @param dependency Dependency
	 * @param toggle Whether to select the dependency
	 */
	public void toggleJavaEEModuleDependency(String dependency, boolean toggle){
		new DefaultTable().getItem(dependency).setChecked(toggle);
	}
	
	/**
	 * Returns whether a given dependency is selected.
	 * 
	 * @param dependency Dependency
	 * @return Whether the dependency is selected
	 */
	public boolean isJavaEEModuleDependency(String dependency){
		return new DefaultTable().getItem(dependency).isChecked();
	}
	
	/**
	 * Sets a given content directory.
	 * 
	 * @param directory Content directory
	 */
	public void setContentDirectory(String directory){
		new LabeledText("Content directory:").setText(directory);
	}
	
	/**
	 * Sets whether to generate application XML.
	 * 
	 * @param toggle Indicates whether to generate application XML
	 */
	public void toggleGenerateApplicationXML(boolean toggle){
		new CheckBox("Generate application.xml deployment descriptor").toggle(toggle);
	}
	
	/**
	 * Returns whether application.xml is generated.
	 * 
	 * @return Whether application.xml is generated
	 */
	public boolean isGenerateApplicationXML(){
		return new CheckBox("Generate application.xml deployment descriptor").isChecked();
	}

}
