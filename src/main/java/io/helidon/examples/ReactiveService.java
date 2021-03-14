package io.helidon.examples;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.helidon.microprofile.server.RoutingPath;
import io.helidon.security.Security;
import io.helidon.webserver.Routing;
import io.helidon.webserver.Service;

/**
 * Reactive service.
 * <p>
 * Helidon WebServer reactive services can be used in MP as well.
 * Injection is limited to {@link javax.enterprise.context.ApplicationScoped}.
 */
@ApplicationScoped
@RoutingPath("/reactive")
public class ReactiveService implements Service {
    @Inject
    private Security security;

    @Override
    public void update(Routing.Rules rules) {
        rules.get("/", (req, res) -> res.send("Security: " + security));
    }
}
