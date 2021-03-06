package org.jboss.reddeer.core.condition;

import org.jboss.reddeer.core.condition.ShellWithTextIsActive;

/**
 * Condition is met when progress information shell is active.
 * 
 * @author Lucia Jelinkova
 *
 */
public class ProgressInformationShellIsActive extends ShellWithTextIsActive {

	/**
	 * Constructs ProgressInformationShellIsActive wait condition. Condition is met
	 * when shell with name Progress Information is active.
	 */
	public ProgressInformationShellIsActive() {
		super("Progress Information");
	}
}