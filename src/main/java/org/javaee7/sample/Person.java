package org.javaee7.sample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RequestScoped
@Path("persons")
public class Person {

    @Inject
    PersonDatabase database;

    @GET
    public String get() {
        return database.currentList().toString();
    }

    @GET
    @Path("{id}")
    public String get(@PathParam("id") int id) {
        return database.getPerson(id);
    }
}
