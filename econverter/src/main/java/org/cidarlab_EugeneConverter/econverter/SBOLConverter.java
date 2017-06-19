package org.cidarlab_EugeneConverter.econverter;

import org.adaptor.SynBioHubAdaptor;
import org.cidarlab_EugeneConverter.econverter.dom.Part;
import org.junit.After;
import org.junit.Before;
import org.sbolstandard.core2.ComponentDefinition;
import org.sbolstandard.core2.SBOLDocument;
import org.sbolstandard.core2.SBOLValidationException;
import org.sbolstandard.core2.Sequence;
import org.sbolstandard.core2.SequenceOntology;
import org.synbiohub.frontend.SynBioHubException;


public class SBOLConverter 
{
	private SynBioHubAdaptor instance; //connection to symbiohub db
	
	// Takes in input Part and SBOL doc. Adds conversions to doc, returns doc.
	public static SBOLDocument convertPartToComponent(Part part, SBOLDocument doc) throws SBOLValidationException 
	{
		String version = "1.0";
		doc.createSequence(part.name+"_seq", version, part.sequence, Sequence.IUPAC_DNA);
		
		
		doc.createComponentDefinition(part.name, version, part.sequence, ComponentDefinition.DNA);
		
		switch (part.partType){
		case GENE: doc.getComponentDefinition(part.name, version).addRole(SequenceOntology.GENE); break;
		case PROMOTER: doc.getComponentDefinition(part.name, version).addRole(SequenceOntology.PROMOTER); break;
		case TERMINATOR: doc.getComponentDefinition(part.name, version).addRole(SequenceOntology.TERMINATOR); break;
		default: break;
		}
		
		return doc;
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
