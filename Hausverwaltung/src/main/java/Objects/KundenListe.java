package Objects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Stream;

public class KundenListe {
    @Getter
    @Setter
    private ArrayList<Kunde> kundenListe = new ArrayList<Kunde>();

    public boolean add(Kunde e) {
        return kundenListe.add(e);
    }

    public void clear() {
        kundenListe.clear();
    }

    public Kunde get(int index) {
        return kundenListe.get(index);
    }

    public Kunde remove(int index) {
        return kundenListe.remove(index);
    }

    public int size() {
        return kundenListe.size();
    }

    public Stream<Kunde> stream() {
        return kundenListe.stream();
    }

    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder();
        kundenListe.stream().forEach(en -> buf.append(en.toString()));
        return buf.toString();
    }
}
