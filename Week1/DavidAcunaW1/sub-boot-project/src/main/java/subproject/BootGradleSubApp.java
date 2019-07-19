package subproject;

import groovy.transform.CompileStatic;

@CompileStatic
public class BootGradleSubApp {
	 public static String greeting(final String name) {
		return name.toUpperCase();
    }
}
