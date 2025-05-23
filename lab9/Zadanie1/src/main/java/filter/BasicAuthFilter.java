
package filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class BasicAuthFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BASIC_PREFIX = "Basic ";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString(AUTHORIZATION_HEADER);
        if (authHeader == null || !authHeader.startsWith(BASIC_PREFIX)) {
            abortWithUnauthorized(requestContext);
            return;
        }

        String base64Credentials = authHeader.substring(BASIC_PREFIX.length()).trim();

        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);

        final String[] values = credentials.split(":", 2);
        if (values.length != 2 || !isValidUser(values[0], values[1])) {
            abortWithUnauthorized(requestContext);
            return;
        }
    }

    private boolean isValidUser(String username, String password) {
        return "admin".equals(username) && "secret".equals(password);
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(
            Response.status(Response.Status.UNAUTHORIZED)
                .header("WWW-Authenticate", "Basic realm=\"example\"")
                .entity("User cannot access the resource.")
                .build()
        );
    }
}