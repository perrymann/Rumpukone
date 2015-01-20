
package DrumMachine.ui;

import DrumMachine.domain.Machine;

import java.util.Scanner;
import jm.util.Play;

public class Kayttoliittyma {
   
    private Machine solo;
    private Scanner lukija = new Scanner(System.in);
    
    public Kayttoliittyma(Machine c) {
        this.solo = c;
        kaynnista();
    }
    
    public void kaynnista() {
        System.out.println("Tervetuloa");

        System.out.println("Luodaan uusi komppi");
       
        System.out.println("Anna kompille nimi:");
        String uusi = lukija.nextLine();
        this.solo.createScore(uusi);
        System.out.println("Määritä tempo:");
        double tempo = Double.parseDouble(lukija.nextLine());
        System.out.println(tempo);
        solo.setTempoForScore(tempo);
        this.solo.createDrumbeat("Osa1");

        while (true) {
            System.out.println("Luodaanko uusi fraasi?");
            uusi = lukija.nextLine();
            if (uusi.equals("OK")) {
                System.out.println("testi");
                this.solo.createDrumPhrase();
                int nuottienMaaraFraasissa = 0;

                while (true) {
                    System.out.println("Luodaanko uusi nuotti?");
                    uusi = lukija.nextLine();
                    if (uusi.equals("OK")) {
                        System.out.println("");
                        System.out.println("Anna rumpu: ");
                        int soitin = Integer.parseInt(lukija.nextLine());
                        System.out.println("Anna aika-arvo:");
                        int aika = Integer.parseInt(lukija.nextLine());
                        this.solo.createHit(soitin, aika);
                        System.out.println("Lisätään nuotti fraasiin");
                        this.solo.addHitIntoPhrase();
                        nuottienMaaraFraasissa++;
                        System.out.println("Nuottien määrä fraasissa: " + nuottienMaaraFraasissa);
                        
                    } else {
                        System.out.println("Ok, fraasi on valmis. Lisätään se osaan. Kuinka monta kertaa loopataan?");
                        int loops =  Integer.parseInt(lukija.nextLine());
                        solo.defineLooping(loops);
                        solo.addDrumPhraseIntoDrumbeat();
                        System.out.println("Fraasi on lisätty komppiin.");
                        break;
                    }
                }
            } else {
                System.out.println("Siirrytään kasaamaan biisiä.");
                break;
            }
        }
        System.out.println("");
        solo.addDrumbeatIntoScore();
        System.out.println(solo.getScore());
        System.out.println("Soitetaan komppi");
        solo.playScore();
    }
}


