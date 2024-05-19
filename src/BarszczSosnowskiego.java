public class BarszczSosnowskiego extends Roslina{
    public BarszczSosnowskiego(Swiat swiat, int x, int y) {
        super(swiat, x, y, 'B', 99, "src/ikony/barszcz.png");
        inicjatywa=0;
    }
    @Override
    public void akcja() {
        super.akcja();
        int x1 = 0, y1 = 0;
        for (int i = 0; 4 > i; i++) {
            if (i == 0) { x1 = 1; y1 = 0; }
            if (i == 1) { x1 = -1; y1 = 0; }
            if (i == 2) { x1 = 0; y1 = 1; }
            if (i == 3) { x1 = 0; y1 = -1; }

            if (swiat.czyRuchMozliwy(getX() + x1, getY() + y1)
                    && swiat.jestZwierzeciem( swiat.getMapaOrganizmow()[getX() + x1][getY() + y1])) {
                Organizm inny = swiat.getMapaOrganizmow()[getX() + x1][getY() + y1];
                swiat.komunikat(this, "atakuje ");
                swiat.komunikat(inny, "zatruty ");
                swiat.usunOrganizm(inny);
            }
        }
    }
}
