package at.htl;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface MovieWrapperResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/api/movie/findAll")
    JsonArray getMovies();
}
