package Ressource;

import Objects.Ablesung;
import Objects.Kunde;
import Server.Server;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;

@Path("ablesungen")
public class AblesungenRessource {
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
public Response getAblesungen(){
        HashMap<Kunde, List<Ablesung>> ablesungen = Server.ablesungListe.getAblesungsListe();
        return Response.ok(ablesungen.values()).build();
    }
}
