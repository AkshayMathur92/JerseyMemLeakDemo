package space.akshaymathur.examples.jerseymemleak.resources;

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
@Path("/echo")
public class EchoResource {

    @GET
    public String echo(@QueryParam("data")String data){
        return data;
    }

}
