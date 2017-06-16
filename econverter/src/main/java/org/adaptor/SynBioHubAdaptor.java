package org.adaptor;

import org.sbolstandard.core2.SBOLDocument;
import org.synbiohub.frontend.SynBioHubException;
import org.synbiohub.frontend.SynBioHubFrontend;

public class SynBioHubAdaptor {
	SynBioHubFrontend frontend;
	
	public SynBioHubAdaptor(String synBioHubURL) {
        frontend = new SynBioHubFrontend(synBioHubURL);
    }
    
    public SynBioHubAdaptor(String synBioHubURL, String prefix) {
        frontend = new SynBioHubFrontend(synBioHubURL, prefix);
    }
    
    //login
    public void login(String email, String password) throws SynBioHubException{
    	frontend.login(email, password);
    }
    
    //logout
    public void logout(){
    	frontend.logout();
    }
    
    //submit to Synbiohub
    public void submit(String id, String version, String name, String description, String citations, String collections, String owerwrite_merge, SBOLDocument document) throws SynBioHubException{
    	frontend.submit(id, version, name, description, citations, collections, owerwrite_merge, document);
    }

}
