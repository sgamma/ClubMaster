package eu.the.oldbacks.service;

import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

/**
 *
 * @author Stefano
 */
public class ClubMasterApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        return new Restlet() {
            @Override
            public void handle(Request request, Response response) {
                String entity = "Method : " + request.getMethod()
                        + "\nResource URI : "
                        + request.getResourceRef()
                        + "\nIP address : "
                        + request.getClientInfo().getAddress()
                        + "\nAgent name : "
                        + request.getClientInfo().getAgentName()
                        + "\nAgent version: "
                        + request.getClientInfo().getAgentVersion();
                response.setEntity(entity, MediaType.TEXT_PLAIN);
            }
        };
    }
}
