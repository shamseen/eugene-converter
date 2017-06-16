package org.cidarlab_EugeneConverter.econverter;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.sbolstandard.core2.SBOLConversionException;
import org.sbolstandard.core2.SBOLDocument;
import org.sbolstandard.core2.SBOLValidate;
import org.sbolstandard.core2.SBOLValidationException;
import org.sbolstandard.core2.SBOLWriter;
import org.adaptor.SynBioHubAdaptor;
import org.synbiohub.frontend.SynBioHubException;


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
