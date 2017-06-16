package org.cidarlab_EugeneConverter.econverter;

import org.adaptor.SynBioHubAdaptor;
import org.synbiohub.frontend.SynBioHubException;

/**
 * Hello world!
 *
 */
public class SBOLConverter 
{
	private SynBioHubAdaptor instance; //connection to symbiohub db
	
	
	 @Before
	    public void setUp() {
	        instance = new SynBioHubAdaptor("https://synbiohub.programmingbiology.org/");
	        try {
				instance.login("shamseen@bu.edu", "cidarlab");
			} catch (SynBioHubException e) {
				e.printStackTrace();
			}
	    }
	 
	 @After
	    public void tearDown() {
	    	instance.logout();
	    }
}
