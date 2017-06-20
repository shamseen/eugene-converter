package org.cidarlab_EugeneConverter.econverter;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
//import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import org.cidarlab_EugeneConverter.econverter.dom.Part;
import org.cidarlab_EugeneConverter.econverter.dom.PartType;
import org.hamcrest.Matchers;
import org.sbolstandard.core2.ComponentDefinition;
import org.sbolstandard.core2.SBOLDocument;
import org.sbolstandard.core2.SBOLValidationException;
import org.adaptor.SynBioHubAdaptor;
import org.synbiohub.frontend.SynBioHubException;

import com.google.common.collect.Lists;

public class DeviceTest {
	
	private SynBioHubAdaptor instance;
	public static List<Part> Parts = new ArrayList<Part>();
	
	
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
	
	@Test
	public void ConverterReturnsSBOLComponents() throws SBOLValidationException{
		//setup
		SBOLDocument doc = new SBOLDocument();
		
		
		
		doc.setDefaultURIprefix("https://www.cidarlab.org/owl/Synbiohub_Demo/");
		doc.setComplete(true);
		doc.setCreateDefaults(true);
		
		Parts.add(new Part(PartType.GENE, "test1", "ATTCGA"));
		
		for(Part p : Parts){
			doc = SBOLConverter.convertPartToComponent(p, doc);
		}
		
		List<ComponentDefinition> retVal = Lists.newArrayList(doc.getComponentDefinitions());
		
		//test		
		assert(retVal.size() == Parts.size());

		for(Part p : Parts){
			assertThat(retVal, contains(Matchers.hasProperty("displayId", is(p.name))));
		};
		
	}
}
