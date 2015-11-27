package org.jboss.reddeer.requirements.autobuilding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.reddeer.direct.preferences.PreferencesUtil;
import org.jboss.reddeer.junit.requirement.Requirement;
import org.jboss.reddeer.requirements.autobuilding.AutoBuildingRequirement.AutoBuilding;

/**
 * This requirement ensures that the setting for auto building is set on/off.
 * During the cleanup phase the change is set back.
 * 
 * @author Andrej Podhradsky
 *
 */
public class AutoBuildingRequirement implements Requirement<AutoBuilding> {

	private AutoBuilding autoBuilding;
	private boolean autoBuildingOriginalValue;

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface AutoBuilding {
		
		/**
		 * Value.
		 *
		 * @return true, if successful
		 */
		boolean value() default true;
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.junit.requirement.Requirement#canFulfill()
	 */
	@Override
	public boolean canFulfill() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.junit.requirement.Requirement#fulfill()
	 */
	@Override
	public void fulfill() {
		autoBuildingOriginalValue = PreferencesUtil.isAutoBuildingOn();
		if (autoBuilding.value()) {
			PreferencesUtil.setAutoBuildingOn();
		} else {
			PreferencesUtil.setAutoBuildingOff();
		}
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.junit.requirement.Requirement#setDeclaration(java.lang.annotation.Annotation)
	 */
	@Override
	public void setDeclaration(AutoBuilding autoBuilding) {
		this.autoBuilding = autoBuilding;
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.junit.requirement.Requirement#cleanUp()
	 */
	@Override
	public void cleanUp() {
		if (autoBuildingOriginalValue) {
			PreferencesUtil.setAutoBuildingOn();
		} else {
			PreferencesUtil.setAutoBuildingOff();
		}
	}
}