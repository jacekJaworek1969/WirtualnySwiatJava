public class Zamiana {
    public static char naSymbol(String nazwa){
        if (nazwa.equals("Czlowiek"))return 'X';
        if (nazwa.equals("WilczeJagody"))return 'J';
        return nazwa.charAt(0);
    }
    public static String  naNazwe(char c){
        return switch (c) {
                case 'O' -> "Owca";
                case 'W' -> "Wilk";
                case 'A' -> "Antylopa";
                case 'Z' -> "Zolw";
                case 'X' -> "Czlowiek";
                case 'T' -> "Trawa";
                case 'M' -> "Mlecz";
                case 'J' -> "WilczeJagody";
                case 'B' -> "BarszczSosnowskiego";
                case 'G' -> "Guarana";
                case 'L' -> "Lis";
                default -> "blad";
        };
    }
}
