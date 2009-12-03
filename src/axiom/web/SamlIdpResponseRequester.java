package axiom.web;

import sun.misc.BASE64Decoder;
import axiom.saml.idp.Saml2AuthnRequestConsumer;
import axiom.saml.idp.SamlVersion;

public class SamlIdpResponseRequester extends SamlIdpSupport implements Breadcrumbable {
	
	@Override
    public String execute() throws Exception {
		//set ssoStartPage to self
		getIdpConfig().setSsoStartPage(getServletRequest().getRequestURL().toString());
		
		//set startURL to startURL (SAML 1.1) or RelayState (SAML 2.0)
		if(getServletRequest().getParameter("startURL") != null){
			getIdpConfig().setStartURL(getServletRequest().getParameter("startURL"));
			getIdpConfig().setSamlVersion(SamlVersion._1_1);
		} else if(getServletRequest().getParameter("RelayState") != null && getServletRequest().getParameter("SAMLRequest") != null){
			setRelayState(getServletRequest().getParameter("RelayState"));
			getIdpConfig().setSamlVersion(SamlVersion._2_0);
			
			BASE64Decoder decoder = new BASE64Decoder();
			String authnRequestXmlString = new String(decoder.decodeBuffer(getServletRequest().getParameter("SAMLRequest")));
			String requestedRecipient = Saml2AuthnRequestConsumer.parseAssertionConsumerServiceURL(authnRequestXmlString);
			getIdpConfig().setRecipient(requestedRecipient);
		} 
		
		return SUCCESS;
	}
	
	@Override
	public Breadcrumbable getParentPage() {
		return new SamlIdpHome();
	}	
}
