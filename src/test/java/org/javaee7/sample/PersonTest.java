package org.javaee7.sample;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author arungupta
 */
@RunWith(Arquillian.class)
public class PersonTest {

    private WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage("org.javaee7.sample");
    }

    @ArquillianResource
    private URL base;

    @Before
    public void setUp() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "resources/persons").toExternalForm()));
    }

    /**
     * Test of get method, of class Person.
     */
//    @Test
    public void testGetAll() {
        String[] list = target.request().get(String[].class);
        assertEquals(8, list.length);

        assertEquals("Penny", list[0]);
        assertEquals("Leonard", list[1]);
        assertEquals("Sheldon", list[2]);
        assertEquals("Amy", list[3]);
        assertEquals("Howard", list[4]);
        assertEquals("Bernadette", list[5]);
        assertEquals("Raj", list[6]);
        assertEquals("Priya", list[7]);
    }

    /**
     * Test of get method, of class Person.
     */
    @Test
    public void testGetOne() {
        WebTarget target2 = target.path("{id}");
        
        String response = target2.resolveTemplate("id", 0).request().get(String.class);
        assertEquals("Penny", response);
        
        response = target2.resolveTemplate("id", 1).request().get(String.class);
        assertEquals("Leonard", response);
    }

}
