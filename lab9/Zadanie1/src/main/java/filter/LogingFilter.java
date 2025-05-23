package filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LogingFilter implements ContainerResponseFilter, ContainerRequestFilter{
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("Request Filter: ");
        System.out.println("Headers: " + requestContext.getHeaders());
    }
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseRequest) throws IOException {
        System.out.println("Response Filter: ");
        System.out.println("Headers: " + responseRequest.getHeaders());
    }
}