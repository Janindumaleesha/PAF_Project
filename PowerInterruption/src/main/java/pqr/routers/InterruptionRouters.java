package pqr.routers;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pqr.controller.InterruptionController;
import pqr.modal.Interruption;

@Path("myresource")
public class InterruptionRouters {
	
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllInterruption() throws ClassNotFoundException, SQLException{
    	
    	if(InterruptionController.getInterruptions().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Interruptions founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(InterruptionController.getInterruptions()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInterruption(Interruption interruption) throws ClassNotFoundException, SQLException {
    	 System.out.println(interruption);
    	 Interruption Createdinterruption = InterruptionController.createInterruption(interruption);
    	 if(Createdinterruption != null) {
    		 return Response.status(Status.CREATED).entity(Createdinterruption).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getInterruptionByID(@PathParam("id") int intId) throws ClassNotFoundException, SQLException{
    	
    	if(InterruptionController.getInterruptionByID(intId) != null) {
    		return Response.status(Status.OK).entity(InterruptionController.getInterruptionByID(intId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Interruption Found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInterruption(Interruption interruption,@PathParam("id") int intId) throws ClassNotFoundException, SQLException {
		
		if(interruption != null) {
			if(InterruptionController.updateInterruption(interruption,intId) != null) {
				return Response.status(Status.OK).entity(InterruptionController.updateInterruption(interruption,intId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Interruption Found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteInterruption(@PathParam("id") int intId) throws ClassNotFoundException, SQLException{
		 
		if(!InterruptionController.deleteInterruption(intId)) {
			return Response.status(Status.OK).entity(intId).build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
