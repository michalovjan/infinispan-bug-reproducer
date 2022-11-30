package io.michalov;

import io.quarkus.infinispan.client.Remote;
import org.infinispan.client.hotrod.RemoteCache;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Remote("cache")
    RemoteCache<String, Data> cache;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Data put(String text) {
        return cache.put(text, new Data(text));
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Data delete(String text) {
        return cache.remove(text);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Data get(@PathParam("id") String id) {
        return cache.get(id);
    }
}