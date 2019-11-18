package space.akshaymathur.examples.jerseymemleak.resources;

import com.google.inject.Inject;
import space.akshaymathur.examples.jerseymemleak.utils.WebClient;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author : akshay.mathur
 * @since : 14-11-2019
 **/

@Resource
@Produces("text/plain")
@Path("/proxy")
public class ProxyResource {

    private final WebClient webClient;

    @Inject
    public ProxyResource(WebClient webClient) {
        this.webClient = webClient;
    }

    @GET
    public Object forward(@QueryParam("url") String url){
        try {
            return webClient.call(url);
        }catch (Exception e){
            return "Something Went Wrong";
        }
    }
}
