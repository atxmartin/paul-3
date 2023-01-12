package Objects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

public class AblesungsListe {
    @Getter
    @Setter
    private HashMap<Kunde, List<Ablesung>> ablesungsListe = new HashMap<>();

    public void clear() {
        ablesungsListe.clear();
    }

    public int size() {
        return ablesungsListe.size();
    }


}
