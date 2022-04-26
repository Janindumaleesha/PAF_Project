package web.routers;

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

import web.controller.CustomerController;
import web.modal.Customer;

@Path("myresource")
public class CustomerRouters {
	
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomer() throws ClassNotFoundException, SQLException{
    	
    	if(CustomerController.getCustomers().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Customers founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.getCustomers()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) throws ClassNotFoundException, SQLException {
    	 System.out.println(customer);
    	 Customer Createdcustomer = CustomerController.createCustomer(customer);
    	 if(Createdcustomer != null) {
    		 return Response.status(Status.CREATED).entity("Inserted Successfully").build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerByID(@PathParam("id") int cusId) throws ClassNotFoundException, SQLException{
    	
    	if(CustomerController.getCustomerByID(cusId) != null) {
    		return Response.status(Status.OK).entity(CustomerController.getCustomerByID(cusId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Customer Found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCustomer(Customer customer,@PathParam("id") int cusId) throws ClassNotFoundException, SQLException {
		
		if(customer != null) {
			if(CustomerController.updateCustomer(customer,cusId) != null) {
				return Response.status(Status.OK).entity("Updated Successfully").build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Customer Found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(@PathParam("id") int cusId) throws ClassNotFoundException, SQLException{
		 
		if(!CustomerController.deleteCustomer(cusId)) {
			return Response.status(Status.OK).entity("Deleted Successfully").build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
