//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {

        Swiat swiat = new Swiat(20,20);
        Czlowiek czlowiek = new Czlowiek(swiat,swiat.rand.nextInt(20), swiat.rand.nextInt(20));
        swiat.dodajCzlowieka(czlowiek);
        swiat.ustawSwiat();
        new Okno(swiat, czlowiek);
    }
}