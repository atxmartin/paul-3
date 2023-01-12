/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author beasc
 */
import java.util.ArrayList;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;

public class MessdatenListe {
    @Getter
    @Setter
    private ArrayList<MessdatenEintrag> messdatenListe = new ArrayList<MessdatenEintrag>();

    public boolean add(MessdatenEintrag e) {
        return messdatenListe.add(e);
    }

    public void clear() {
        messdatenListe.clear();
    }

    public MessdatenEintrag get(int index) {
        return messdatenListe.get(index);
    }

    public MessdatenEintrag remove(int index) {
        return messdatenListe.remove(index);
    }

    public int size() {
        return messdatenListe.size();
    }

    public Stream<MessdatenEintrag> stream() {
        return messdatenListe.stream();
    }

    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder();
        messdatenListe.stream().forEach(en -> buf.append(en.toString()));
        return buf.toString();
    }
}
