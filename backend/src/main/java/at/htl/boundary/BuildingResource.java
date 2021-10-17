package at.htl.boundary;

import at.htl.control.BuildingRepository;
import at.htl.entity.Building;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id, @Context UriInfo uriInfo) {
        return Response.created(
                URI.create(uriInfo.getPath() + "/"
                        + buildingRepository.getBuildingById(id).getId()
                )
        ).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        return Response.ok(buildingRepository.getAll()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Building building, @Context UriInfo uriInfo) {
        buildingRepository.save(building);
        return Response
                .created(URI.create(uriInfo.getPath() + "/" + building.getId()))
                .build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") long id) {
        buildingRepository.remove(buildingRepository.getBuildingById(id));
        return Response.ok().build();
    }

}
