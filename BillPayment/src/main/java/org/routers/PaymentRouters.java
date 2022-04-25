package org.routers;

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

import org.controller.PaymentController;
import org.modal.Payment;

@Path("myresource")
public class PaymentRouters {
	
	@GET
	@Path("/payment/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllPayment() throws ClassNotFoundException, SQLException{
    	
    	if(PaymentController.getPayments().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Payments founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(PaymentController.getPayments()).build();
    	}
    	
	}
	
	@POST
	@Path("/payment/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPayment(Payment payment) throws ClassNotFoundException, SQLException {
    	 System.out.println(payment);
    	 Payment Createdpayment = PaymentController.createPayment(payment);
    	 if(Createdpayment != null) {
    		 return Response.status(Status.CREATED).entity(Createdpayment).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/payment/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPaymentByID(@PathParam("id") int payId) throws ClassNotFoundException, SQLException{
    	
    	if(PaymentController.getPaymentByID(payId) != null) {
    		return Response.status(Status.OK).entity(PaymentController.getPaymentByID(payId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Payment Found").build();
    	}
    	
	}
	
	@PUT
	@Path("/payment/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePayment(Payment payment,@PathParam("id") int payId) throws ClassNotFoundException, SQLException {
		
		if(payment != null) {
			if(PaymentController.updatePayment(payment,payId) != null) {
				return Response.status(Status.OK).entity(PaymentController.updatePayment(payment,payId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Payment Found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/payment/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePayment(@PathParam("id") int payId) throws ClassNotFoundException, SQLException{
		 
		if(!PaymentController.deletePayment(payId)) {
			return Response.status(Status.OK).entity(payId).build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
