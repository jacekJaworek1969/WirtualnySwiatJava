import java.util.Random;
public abstract class Zwierze extends Organizm{
    int predkosc;
    protected Random rand = new Random();
    public Zwierze(Swiat swiat, int x, int y, char symbol, int sila, int inicjatywa, String ikona) {
        super(swiat, x, y, symbol, sila, inicjatywa, ikona);
        this.predkosc=1;
    }

    private Kierunek wybierzKierunek() {
        int i = 0;
        Kierunek kierunek=Kierunek.brak;
        while (true) {
            if (i >= 20) {
                System.out.println("nie znaleziono kierunku ");
                return kierunek;
            }
             kierunek = Losuj.wybierz_kierunek();
            koordynaty pole = Losuj.ustaw_pozycje(kierunek,x,y,predkosc) ;
            if (swiat.czyRuchMozliwy(pole.x, pole.y)) break;
            i++;
        }
        return kierunek;
    }
    @Override
    public void akcja() {
        if (getWiek() == 0) {
            postarzWiek();
            return;
        }
        postarzWiek();
        Kierunek kierunek = wybierzKierunek();

        if (kierunek == Kierunek.brak) {
            swiat.komunikat(this, "nie moze sie ruszyc ");
            return;
        }

        koordynaty pole;
        pole = Losuj.ustaw_pozycje(kierunek,x,y,predkosc);
        if (swiat.getMapaOrganizmow()[pole.x][pole.y] == null)swiat.przestawOrganizm(this, pole.x, pole.y);
        else swiat.getMapaOrganizmow()[pole.x][pole.y].kolizja(this);
    }

    @Override
    public void kolizja(Organizm atakujacy) {
        if (this.getSymbol() == atakujacy.getSymbol()) {
            //dziecko
            if (swiat.czySasiadujaceWolne(this.getX(), this.getY())) {
                koordynaty pole = swiat.znajdzWolnePole(this);
                int x1 = pole.x, y1 = pole.y;
                swiat.dodajOrganizm(getSymbol(), x1,  y1);
                swiat.komunikat(this, "sie rozmnozyl");
            }
            //else swiat->komunikat(this, "nie ma miejsca na rozmnazanie");


        }
	else if (atakujacy.getSila() >= this.getSila()) {
            swiat.komunikat(atakujacy, "atakuje ");
            swiat.komunikat(this, "przegrywa ");
            swiat.zastapOrganizm(atakujacy, this);
        }
	else {
            swiat.komunikat(atakujacy, "atakuje ");
            swiat.komunikat(this, "wygrywa ");
            swiat.usunOrganizm(atakujacy);
        }
    }
}
