package at.htl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieResourceTest {

    private static Client client;
    private static WebTarget tut;

    @BeforeAll
    public static void init(){
        client = ClientBuilder.newClient();
        tut = client.target("http://localhost:8085/movie/allMovies");
    }

    @Test
    public void test01_getMovies(){
        Response response =tut.request().get() ;
        assertEquals(response.getStatus(),200);
        JsonArray jsonArray  = response.readEntity(JsonArray.class);
        assertThat(jsonArray.getJsonObject(0).getString("genre"), is("Drama"));
        assertThat(jsonArray.getJsonObject(0).getString("title"), is("Die Verurteilten"));

        assertThat(jsonArray.getJsonObject(1).getString("genre"), is("Drama"));
        assertThat(jsonArray.getJsonObject(1).getString("title"), is("Der Pate"));

        assertThat(jsonArray.getJsonObject(2).getString("genre"), is("Action"));
        assertThat(jsonArray.getJsonObject(2).getString("title"), is("The Dark Knight"));
    }
}
