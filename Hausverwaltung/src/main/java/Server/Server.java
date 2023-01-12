package Server;

import Objects.Ablesung;
import Objects.AblesungsListe;
import Objects.Kunde;
import Objects.KundenListe;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class Server {
    private static HttpServer server;
    public static KundenListe list = new KundenListe();
    public static AblesungsListe ablesungListe= new AblesungsListe();
    private static final File kundenJson = new File("Kunden.json");
    private static final File ablesungsJson = new File("Ablesung.json");
    public static void startServer(String url, boolean loadFromFile) throws IOException {
        final String pack = "Ressource";
        final ResourceConfig rc = new ResourceConfig().packages(pack);
        server = JdkHttpServerFactory.createHttpServer(URI.create(url),rc);
        if(loadFromFile) {
            if(kundenJson.exists() && ablesungsJson.exists()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.findAndRegisterModules();
                list = mapper.readValue(kundenJson, KundenListe.class);
                ablesungListe.setAblesungsListe(mapper.readValue(ablesungsJson, HashMap.class));
            }
        }
    }

    public static void stopServer(boolean saveToFile) throws IOException {
        if(saveToFile){
                if(kundenJson.exists() && ablesungsJson.exists()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.findAndRegisterModules();
                    mapper.writeValue(kundenJson, list);
                    mapper.writeValue(ablesungsJson, ablesungListe.getAblesungsListe());
                } else {
                    FileWriter myWriter = new FileWriter("Kunden.json");
                    myWriter.write("");
                    myWriter = new FileWriter("Ablesung.json");
                    myWriter.write("");
                    myWriter.close();
                }
        }
        if(server != null){
            server.stop(0);
            server = null;
        }

    }
}
