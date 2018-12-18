package app;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



@Path("/v1/status")
public class first {
	
	alienDAO rep=new alienDAO();
	//alienRepo rep=new alienRepo();
	
@GET
@Produces(MediaType.APPLICATION_XML)
public List<Alien> returnTitle() {
	
	return rep.getaliens();
}

//get by id

@GET
@Path("/alien/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Alien getalien(@PathParam("id") int id) {
	
	return rep.getalien(id);
}

//create a resource
@POST
@Path("alien")
public Alien create(Alien a) {
	
	//rep.createAlien(a);
	return a;
}


@Path("/version")
@GET
@Produces(MediaType.TEXT_HTML)
public String returnVersion() {
	
	return "<p>1.1.1 </p>";
}

}