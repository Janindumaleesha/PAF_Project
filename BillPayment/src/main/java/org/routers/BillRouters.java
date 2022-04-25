package org.routers;

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

import org.controller.BillController;
import org.modal.Bill;

@Path("myresource")
public class BillRouters {
	
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllBill() throws ClassNotFoundException, SQLException{
    	
    	if(BillController.getBills().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Bills founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(BillController.getBills()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBill(Bill bill) throws ClassNotFoundException, SQLException {
    	 System.out.println(bill);
    	 Bill Createdbill = BillController.createBill(bill);
    	 if(Createdbill != null) {
    		 return Response.status(Status.CREATED).entity(Createdbill).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getBillByID(@PathParam("id") int bilId) throws ClassNotFoundException, SQLException{
    	
    	if(BillController.getBillByID(bilId) != null) {
    		return Response.status(Status.OK).entity(BillController.getBillByID(bilId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Bill Found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBill(Bill bill,@PathParam("id") int bilId) throws ClassNotFoundException, SQLException {
		
		if(bill != null) {
			if(BillController.updateBill(bill,bilId) != null) {
				return Response.status(Status.OK).entity(BillController.updateBill(bill,bilId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Bill Found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBill(@PathParam("id") int bilId) throws ClassNotFoundException, SQLException{
		 
		if(!BillController.deleteBill(bilId)) {
			return Response.status(Status.OK).entity(bilId).build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
