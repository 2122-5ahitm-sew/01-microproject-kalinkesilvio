package at.htl.boundary;

import at.htl.control.BuildingRepository;
import at.htl.control.FacilityManagerRepository;
import at.htl.entity.Building;
import at.htl.entity.FacilityManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("manager")
@Produces(MediaType.APPLICATION_JSON)
public class FacilityManagerResource {
    @Inject
    FacilityManagerRepository facilityManagerRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(FacilityManager facilityManager, @Context UriInfo uriInfo) {
        facilityManagerRepository.create(facilityManager);
        return Response.created(
                URI.create(uriInfo.getPath() + "/" + facilityManager.getId())
        ).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        return Response.ok(facilityManagerRepository.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id, @Context UriInfo uriInfo) {
        return Response.created(
                URI.create(uriInfo.getPath() + "/"
                        + facilityManagerRepository.getFacilityManagerById(id).getId()
                )
        ).build();
    }
}
