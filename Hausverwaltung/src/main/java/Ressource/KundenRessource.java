package Ressource;

import Objects.Kunde;
import Server.Server;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("kunden")
public class KundenRessource {

@GET
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public List<Kunde> getKunden(){
    return Server.list.getKundenListe();
}

}
