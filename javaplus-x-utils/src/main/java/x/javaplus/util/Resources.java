package x.javaplus.util;

import java.net.URL;

public class Resources {

	  public static URL getUrl( String resourceName ) {
	    URL url = Resources.class.getClassLoader().getResource(resourceName);
	    if(url == null) {
	    	throw new IllegalArgumentException(resourceName);
	    }
	    return url;
	  }
	  
	  public static String getResource( String resourceName ){
		  return "resources/" + resourceName;
	  }
	  
}
