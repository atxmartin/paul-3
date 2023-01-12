/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author beasc
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessdatenEintrag {

    private int kundennr;
    private String hausnr;
    private int wohnungsnr;
    private String zaehlerart;
    private int zaehlernr;
    private int ablesedatum;
    private boolean zahlerwechsel;
    private float zaehlerstandK;
    private float zaehlerstandH;
    private String kommentar;

    public MessdatenEintrag(int kundennr, String hausnr, int wohnungsnr, String zaehlerart, int zaehlernr, int ablesedatum, boolean zahlerwechsel, float zaehlerstandK, float zaehlerstandH, String kommentar) {
        this.kundennr = kundennr;
        this.hausnr = hausnr;
        this.wohnungsnr = wohnungsnr;
        this.zaehlerart = zaehlerart;
        this.zaehlernr = zaehlernr;
        this.ablesedatum = ablesedatum;
        this.zahlerwechsel = zahlerwechsel;
        this.zaehlerstandK = zaehlerstandK;
        this.zaehlerstandH = zaehlerstandH;
        this.kommentar = kommentar;
    }

    @Override
    public String toString() {
        return "MessdatenEintrag{" + "kundennr=" + kundennr + ", hausnr=" + hausnr + ", wohnungsnr=" + wohnungsnr + ", zaehlerart=" + zaehlerart + ", zaehlernr=" + zaehlernr + ", ablesedatum=" + ablesedatum + ", zahlerwechsel=" + zahlerwechsel + ", zaehlerstandK=" + zaehlerstandK + ", zaehlerstandH=" + zaehlerstandH + ", kommentar=" + kommentar + '}';
    }

}
