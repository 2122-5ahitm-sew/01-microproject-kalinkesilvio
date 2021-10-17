package at.htl.boundary;

import at.htl.control.BuildingRepository;
import at.htl.entity.Building;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("building")
@Produces(MediaType.APPLICATION_JSON)
public class BuildingResource {

    @Inject
    BuildingRepository buildingRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Building building, @Context UriInfo uriInfo) {
        buildingRepository.save(building);
        return Response.created(
                URI.create(uriInfo.getPath() + "/" + building.getId())
        ).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        return Response.ok(buildingRepository.getAll()).build();
    }
}
