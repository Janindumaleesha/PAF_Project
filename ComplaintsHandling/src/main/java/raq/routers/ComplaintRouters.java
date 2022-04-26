package raq.routers;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;import javax.ws.rs.core.Response.Status;

import raq.controller.ComplaintController;
import raq.modal.Complaint;

@Path("myresource")
public class ComplaintRouters {
	
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllComplaint() throws ClassNotFoundException, SQLException{
    	
    	if(ComplaintController.getComplaints().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Complaints founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(ComplaintController.getComplaints()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
    	 System.out.println(complaint);
    	 Complaint Createdcomplaint = ComplaintController.createComplaint(complaint);
    	 if(Createdcomplaint != null) {
    		 return Response.status(Status.CREATED).entity("Inserted Succeessfully!!!").build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getComplaintByID(@PathParam("id") int compId) throws ClassNotFoundException, SQLException{
    	
    	if(ComplaintController.getComplaintByID(compId) != null) {
    		return Response.status(Status.OK).entity(ComplaintController.getComplaintByID(compId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Complaint Found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateComplaint(Complaint complaint,@PathParam("id") int compId) throws ClassNotFoundException, SQLException {
		
		if(complaint != null) {
			if(ComplaintController.updateComplaint(complaint,compId) != null) {
				return Response.status(Status.OK).entity("Updated Succeessfully!!!").build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Complaint Found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteComplaint(@PathParam("id") int compId) throws ClassNotFoundException, SQLException{
		 
		if(!ComplaintController.deleteComplaint(compId)) {
			return Response.status(Status.OK).entity("Deleted Successfully!!!").build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
