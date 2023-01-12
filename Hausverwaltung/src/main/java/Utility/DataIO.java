/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Objects.MessdatenEintrag;
import Objects.MessdatenListe;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

/**
 *
 * @author Phineas Gaming
 */
public class DataIO {

    private final String FILE = "Hausverwaltung/Messdaten.json";
    private MessdatenListe liste;

    public DataIO()
    {
        liste = new MessdatenListe();
    }
    
    
    public void load() {
        final File f = new File(FILE);
        if (f.exists()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                liste = objectMapper.readValue(new File(FILE), MessdatenListe.class);
                System.out.format("Datei %s gelesen\n", FILE);
            } catch (final Exception e) {
                e.printStackTrace();
                // ignore
            }
        }
        if (liste == null) {
            liste = new MessdatenListe();
        }
    }

    // bei exit oder speichern?
    public void save() {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(FILE), liste);

            System.out.format("Datei %s erzeugt\n", FILE);
        } catch (final Exception e) {
            e.printStackTrace();
            //System.exit(1);
        }
    }

    // bei click speichern
    public void addEntry(int kundennr, String hausnr, int wohnungsnr, String zaehlerart, int zaehlernr, int ablesedatum, boolean zahlerwechsel, float zaehlerstandK, float zaehlerstandH, String kommentar) {
        final MessdatenEintrag entry = new MessdatenEintrag(kundennr, hausnr, wohnungsnr, zaehlerart, zaehlernr, ablesedatum, zahlerwechsel, zaehlerstandK, zaehlerstandH, kommentar);
        if(liste == null)
        {
            liste = new MessdatenListe();
        }    
        liste.add(entry);
        System.out.format("Added %s to Liste\n", entry.getKundennr() + " " + entry.getAblesedatum());
    }
    
    
    public MessdatenListe getMessdatenListe()
    {
        return liste;
    }
}
