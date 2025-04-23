package com.abbosidev;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @POST
    public void save(Product product) throws JsonProcessingException {
        productService.save(product);
    }

    @PUT
    @Path("{productId}")
    public void update(Product product, UUID productId) {
        productService.update(product,productId);
    }

    @GET
    @Path("{productId}")
    public Product findById(UUID productId) {
        return productService.findById(productId);
    }

    @GET
    public List<Product> getAll() {
        return productService.getAll();
    }

    @DELETE
    public void delete(Product product) {
        productService.delete(product);
    }

}
