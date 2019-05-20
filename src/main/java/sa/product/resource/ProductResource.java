package sa.product.resource;

import sa.product.model.Product;
import sa.product.service.ProductService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/products")
public class ProductResource {

    @Context
    UriInfo uriInfo;

    @EJB
    ProductService productService;

    @GET
    public List<Product> getAllProducts(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return productService.getAllProducts(first, maxResult);
    }

    @GET
    @Path("{code}")
    public Product getProductByCode(@PathParam("code") long code) {
        return productService.getProductByCode(code);
    }

    @POST
    public Response createProduct(Product product) {
        productService.createProduct(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{code}")
    public Response updateProduct(@PathParam("code") long code, Product product) {
        productService.updateProduct(code, product);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{code}")
    public Response deleteProduct(@PathParam("code") long code) {
        productService.deleteProduct(code);
        return Response.status(Response.Status.OK).build();
    }

}
