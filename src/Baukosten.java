import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baukosten {

    private List<String> kommentare;
    private List<String> lines;

    public static int[][] field;

    private Position start;
    private Position ziel;

    public Baukosten() {
        readEingabe();
        convertInSystemVar();

        Route direkteRoute = new Route(start, ziel);
        boolean horizontal = Route.getWayPrice(start, ziel, true) <= Route.getWayPrice(start, ziel, false);
        direkteRoute.directWay(horizontal);

        // TODO. Günstigster Weg

        Route guenstigsteRoute = new Route(start, ziel);
        guenstigsteRoute.cheapestWay();

        /*
        Ausgabe
         */
        for(String kom : kommentare) {
            System.out.println(kom.substring(1));
        }
        System.out.println("Startzelle: " + start.toString() + ", Zielzelle: " + ziel.toString());

        System.out.println("Abschätzung der Kostenobergrenze: " + direkteRoute.getPrice());

    }

    private void ausgabe() {
    }

    private void convertInSystemVar() {
        field = new int[lines.size()][];

        for(int i = 0; i < field.length; i++) {
            String[] line = lines.get(i).split(",");
            field[i] = new int[line.length];
            for(int j = 0; j < line.length; j++) {
                String cur = line[j];
                if(cur.equals("S")) {
                    start = new Position(i+1, j+1, 0);
                    field[i][j] = 0;
                } else if(cur.equals("Z")) {
                    ziel = new Position(i+1, j+1, 0);
                    field[i][j] = 0;
                } else {
                    if(cur.length() == 1) {
                        field[i][j] = Integer.parseInt(cur);
                    }
                }
            }
        }
    }

    private void readEingabe() {
        System.out.println("Eingabe:");
        Scanner scanner = new Scanner(System.in);
        lines = new ArrayList<>();
        kommentare = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String current = scanner.nextLine();
            if(current.startsWith(";")) {
                kommentare.add(current);
                continue;
            }
            lines.add(current);
            if(current.equals("")) {
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Baukosten();
    }

}
