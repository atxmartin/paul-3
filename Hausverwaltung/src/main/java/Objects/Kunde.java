package Objects;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Kunde {

    private UUID id;
    private String name;
    private String vorname;

    public Kunde(String vorname, String name){
        this.vorname=vorname;
        this.name=name;
    }



}
