/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author MateuszK
 */
@Path("hello")
@RequestScoped
public class HelloWorldService {

    @Context
    private UriInfo context;

    public HelloWorldService() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "Witaj w JAX-RS";
    }
    
    @GET
    @Path("echo")
    @Produces(MediaType.TEXT_HTML)
    public String getHtmle() {
        return "Witaj Echo";
    }
    
    @GET
    @Path("echo2/{parametr}")
    @Produces(MediaType.TEXT_HTML)
    public String getHtmle(@PathParam("parametr") String name) {
        return "Witaj Echo: " +name;
    }
    
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
