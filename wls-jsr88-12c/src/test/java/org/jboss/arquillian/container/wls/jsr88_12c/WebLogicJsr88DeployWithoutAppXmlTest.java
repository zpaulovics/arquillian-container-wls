package org.jboss.arquillian.container.wls.jsr88_12c;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class WebLogicJsr88DeployWithoutAppXmlTest
{
   @Inject
   private Client client;
   
   @Deployment
   public static EnterpriseArchive createTestArchive()
   {
      JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(Client.class,WebLogicJsr88DeployWithoutAppXmlTest.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
      EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "test.ear").addAsLibrary(jar);
      return ear;
   }
   
   @Test
   public void testClient()
   {
      assertNotNull(client);
   }
}

class Client
{
   
}
