/**
 * Copyright 2009-2012 Jayway Products AB. All Rights Reserved by Jayway Products AB.
 *
 * The content of this file is property of Jayway Products AB, org no 556777-9896, with the address
 * Hans Michelsensgatan 9, SE-211 20 Malmö, Sweden. Any unauthorized review, use, disclosure
 * or distribution is prohibited.
 */
package com.jayway.surface.mycases.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;

public class StreamflowSAMLUserDetailsService implements SAMLUserDetailsService
{

   @Value("${idp.commonname.attributename}")
   String commonNameAttribute;

   @Value("${idp.serialnumber.attributename}")
   String serialNumberAttribute;

   
   public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException
   {
      
      String username = credential.getNameID().getValue();
  //    String name = credential.getAttributeByName( commonNameAttribute ).getAttributeValues().get( 0 ).getDOM().getTextContent();
  //    String pnr = credential.getAttributeByName( serialNumberAttribute ).getAttributeValues().get( 0 ).getDOM().getTextContent();
  //    return new StreamflowEndUser(username, name, pnr);
      UserDetails streamflowEndUser = new StreamflowEndUser( username, "", username );
      return streamflowEndUser;
      
   }

}
