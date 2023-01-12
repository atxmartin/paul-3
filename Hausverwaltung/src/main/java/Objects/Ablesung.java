package Objects;

import Objects.Kunde;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ablesung {

    private UUID id;
    private String zaehlernummer;
    private LocalDate datum;
    private Kunde kunde;
    private String kommentar;
    private boolean neuEingebaut;
    private Number zaehlerstand;

    public Ablesung(String zaehlernummer, LocalDate datum, Kunde kunde, String kommentar, boolean neuEingebaut, Number zaehlerstand) {
        this.zaehlernummer = zaehlernummer;
        this.datum = datum;
        this.kunde = kunde;
        this.kommentar = kommentar;
        this.neuEingebaut = neuEingebaut;
        this.zaehlerstand = zaehlerstand;
    }
}
