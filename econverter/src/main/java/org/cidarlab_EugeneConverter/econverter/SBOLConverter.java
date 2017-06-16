package org.cidarlab_EugeneConverter.econverter;

import org.adaptor.SynBioHubAdaptor;
import org.cidarlab_EugeneConverter.econverter.dom.*;

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
import org.sbolstandard.core2.Component;
import org.sbolstandard.core2.ComponentDefinition;
import org.sbolstandard.core2.OrientationType;
import org.sbolstandard.core2.Sequence;
import org.sbolstandard.core2.SequenceAnnotation;
import org.sbolstandard.core2.SequenceOntology;

import org.synbiohub.frontend.SynBioHubException;


public class SBOLConverter 
{
	private SynBioHubAdaptor instance; //connection to symbiohub db
	
	// Takes in Part and a doc to add conversions. Outputs modified doc.
	public static SBOLDocument convertPartToComponent(Part part, SBOLDocument doc) throws BOLValidationException, MalformedURLException, URISyntaxException
	{
		
	}
	
	
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
