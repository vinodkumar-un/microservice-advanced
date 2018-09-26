package com.mycom.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @goal log
 */
public class LogPlugin extends AbstractMojo {
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Maven LogPlugin is running...");
	}

}
