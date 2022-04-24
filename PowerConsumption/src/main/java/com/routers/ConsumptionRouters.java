package com.routers;

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

import com.controller.ConsumptionController;
import com.modal.Consumption;

@Path("myresource")
public class ConsumptionRouters {
	
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllConsumption() throws ClassNotFoundException, SQLException{
    	
    	if(ConsumptionController.getConsumptions().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Consumptions founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(ConsumptionController.getConsumptions()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createConsumption(Consumption consumption) throws ClassNotFoundException, SQLException {
    	 System.out.println(consumption);
    	 Consumption Createdconsumption = ConsumptionController.createConsumption(consumption);
    	 if(Createdconsumption != null) {
    		 return Response.status(Status.CREATED).entity(Createdconsumption).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getConsumptionByID(@PathParam("id") int conId) throws ClassNotFoundException, SQLException{
    	
    	if(ConsumptionController.getConsumptionByID(conId) != null) {
    		return Response.status(Status.OK).entity(ConsumptionController.getConsumptionByID(conId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Consumption Found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateConsumption(Consumption consumption,@PathParam("id") int conId) throws ClassNotFoundException, SQLException {
		
		if(consumption != null) {
			if(ConsumptionController.updateConsumption(consumption,conId) != null) {
				return Response.status(Status.OK).entity(ConsumptionController.updateConsumption(consumption,conId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Consumption Found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteConsumption(@PathParam("id") int conId) throws ClassNotFoundException, SQLException{
		 
		if(!ConsumptionController.deleteConsumption(conId)) {
			return Response.status(Status.OK).entity(conId).build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
