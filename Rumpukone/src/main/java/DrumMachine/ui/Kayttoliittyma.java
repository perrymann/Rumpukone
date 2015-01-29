
package DrumMachine.ui;

import DrumMachine.domain.Machine;

import java.util.Scanner;
import jm.util.Play;

public class Kayttoliittyma {
   
    private Machine solo;
    private Scanner lukija;
    
    public Kayttoliittyma(Machine c) {
        this.solo = c;
        kaynnista();
    }
    
    public void kaynnista() {
        
        System.out.println("Tervetuloa");
        
        while (true) {
        this.lukija = new Scanner(System.in);
            
            System.out.println("Anna komento: " + "\n" 
                + "1: Luo uusi biisi"  + "\n"   // kysytään  metodissa nimeä ja luodaan komppi  ja määritellään tempo.
                + "2: Luo uusi rumpukomppi" + "\n"  
                + "3: Luo uusi fraasi" + "\n"
                + "4: Liita fraasi rumpukomppiin" + "\n"
                + "5: Testaa rumpukomppia" + "\n"
                + "6: Liita komppi biisiin" + "\n"
                + "7: Tallenna" + "\n" 
                + "8: Toista tallenne" + "\n"     
                + "9: Rock on!" + "\n"
                + "10: Lopeta");
  
            int uusi = Integer.parseInt(lukija.nextLine());
            if (uusi == 1) {
                luoBiisi();
            }
            if (uusi == 2) {
                luoKomppi();
            }
            if (uusi == 3) {
                luoFraasi();
            }
            if (uusi == 4) {
               lisaaFraasiRumpukomppiin();
            }
            if (uusi == 5) {
                testaaKomppia(); 
            }
            if (uusi == 6) {
               lisaaKomppiBiisiin();
            }
            if (uusi == 7) {
                tallenna();
            }
            if (uusi == 8) {
               toistaTallenne();
            } 
            if (uusi == 9) {
                soita();
            } 
            if (uusi == 10) {
                break;
            }
            
        } 
        System.out.println("Näkemiin");     
    }
    
    public void luoBiisi (){
        System.out.print("Anna biisille nimi: ");
        String nimi = lukija.nextLine();
        this.solo.createSong(nimi);
        System.out.println("");
        System.out.print("Määritä tempo: ");
        double tempo = Double.parseDouble(lukija.nextLine());
        System.out.println(tempo);
        solo.setTempoForSong(tempo);
        System.out.println("Biisi alustettu ja tempo määritelty.");
    }
    
    public void luoKomppi() {
        this.solo.createDrumbeat("Osa1");
        System.out.println("Komppi alustettu");
    }
    
    public void luoFraasi() {
        while (true) {
            System.out.println("Lisätään nuotit");
            this.solo.createDrumPhrase();
            luoNuotti();
            System.out.println("Ok, fraasi on valmis. Kuinka monta kertaa loopataan?");
            int loops = Integer.parseInt(lukija.nextLine());
            solo.defineLooping(loops);
            lisaaFraasiRumpukomppiin();
            System.out.println("Luodaanko uusi fraasi? joo tai ei");
            String uusi = lukija.nextLine(); 
            if (!uusi.equalsIgnoreCase("joo")) {
                break;
            }
        }
    }

    public void luoNuotti() {
        while (true) {
            System.out.println("Luodaan uusi nuotti.");
            System.out.println("Anna rumpu: ");
            int soitin = Integer.parseInt(lukija.nextLine());
            System.out.println("Anna aika-arvo:");
            int aika = Integer.parseInt(lukija.nextLine());
            this.solo.createHit(soitin, aika);
            this.solo.addHitIntoPhrase();
            System.out.println("Jatketaanko: joo tai ei");
            String x = lukija.nextLine();
            if (!x.equals("joo")) {
                break;
            }
        }
    }   

    public void lisaaFraasiRumpukomppiin () {
        solo.addDrumPhraseIntoDrumbeat();
        System.out.println("Fraasi on lisätty komppiin.");
    }
              
    public void testaaKomppia () {
        solo.testDrumBeat();
    }        
                    
    public void lisaaKomppiBiisiin () {
         solo.addDrumbeatIntoScore();
        System.out.println("Komppi lisätty biisiin.");
        }
    
    public void soita() {
        System.out.println("Soitetaan komppi");
        solo.playSong();
    }
    
    public void tallenna() {
        System.out.println("Nimeä tiedosto: ");
        String nimi = lukija.nextLine();
        solo.writeFile(nimi);
    }
    
    public void toistaTallenne() {
        System.out.println("Anna tiedoston nimi:");
        String nimi = lukija.nextLine();
        solo.playSong(nimi);
    }
}


