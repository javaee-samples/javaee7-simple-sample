package org.javaee7.sample;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.StringTokenizer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
        target.register(Person.class);
    }

    /**
     * Test of get method, of class Person.
     */
    @Test
    public void testGetAll() {
        Person[] persons = target.request().get(Person[].class);
        assertEquals(8, persons.length);

        assertEquals("Penny", persons[0].getName());
        assertEquals("Leonard", persons[1].getName());
        assertEquals("Sheldon", persons[2].getName());
        assertEquals("Amy", persons[3].getName());
        assertEquals("Howard", persons[4].getName());
        assertEquals("Bernadette", persons[5].getName());
        assertEquals("Raj", persons[6].getName());
        assertEquals("Priya", persons[7].getName());
    }

    /**
     * Test of get method, of class Person.
     */
    @Test
    public void testGetOne() {
        WebTarget target2 = target.path("{id}");
        
        Person response = target2.resolveTemplate("id", 0).request().get(Person.class);
        assertEquals("Penny", response.getName());
        
        response = target2.resolveTemplate("id", 1).request().get(Person.class);
        assertEquals("Leonard", response.getName());
    }

}
