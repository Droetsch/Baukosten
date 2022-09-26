import java.util.ArrayList;
import java.util.List;

public class Route {

    private int length;
    private int price;

    private Position start;
    private Position ziel;

    private List<Position> way;

    public Route(Position start, Position ziel) {
        length = 0;
        price = start.getPrice() + ziel.getPrice();
        this.start = start;
        this.ziel = ziel;
        way = new ArrayList<>();
    }

    public static int getWayPrice(Position start, Position ziel, boolean horizontal) {
        int sx = start.getX();
        int zx = ziel.getX();
        int sy = start.getY();
        int zy = ziel.getY();

        int myPrice = 0;

        if(sx == zx && sy == zy) {
            return 0;
        }
        if(!horizontal) {
            if(sx > zx) {
                while(sx > zx) {
                    sx--;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
            if(sx < zx) {
                while(sx < zx) {
                    sx++;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
            if(sy > zy) {
                while(sy > zy) {
                    sy--;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
            if(sy < zy) {
                while(sy < zy) {
                    sy++;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
        } else {
            if(sy > zy) {
                while(sy > zy) {
                    sy--;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
            if(sy < zy) {
                while(sy < zy) {
                    sy++;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
            if(sx > zx) {
                while(sx > zx) {
                    sx--;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
            if(sx < zx) {
                while(sx < zx) {
                    sx++;
                    int price = Baukosten.field[sx-1][sy-1];
                    myPrice += price;
                }
            }
        }
        return myPrice;
    }

    public void directWay(boolean horizontal) {
        int sx = start.getX();
        int zx = ziel.getX();
        int sy = start.getY();
        int zy = ziel.getY();

        if(sx == zx && sy == zy) {
            return;
        }
        if(horizontal) {
            if(sx > zx) {
                while(sx > zx) {
                    sx--;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
            if(sx < zx) {
                while(sx < zx) {
                    sx++;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
            if(sy > zy) {
                while(sy > zy) {
                    sy--;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
            if(sy < zy) {
                while(sy < zy) {
                    sy++;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
        } else {
            if(sy > zy) {
                while(sy > zy) {
                    sy--;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
            if(sy < zy) {
                while(sy < zy) {
                    sy++;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
            if(sx > zx) {
                while(sx > zx) {
                    sx--;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
            if(sx < zx) {
                while(sx < zx) {
                    sx++;
                    int price = Baukosten.field[sx-1][sy-1];
                    this.price += price;
                    way.add(new Position(sx, sy, price));
                }
            }
        }

    }

    public Route cheapestUmweg(Position start, Direction direction) {

        Position ziel;
        List<Integer> priceList = new ArrayList<>();
        int zielPosX = start.getX();
        int zielPosY = start.getY();
        int curFeldkosten = 0;

        switch(direction) {
            case LEFT:
                zielPosY -= 2;
                curFeldkosten = Baukosten.field[zielPosX-1][zielPosY-1];
                ziel = new Position(zielPosX, zielPosY, curFeldkosten);

                /*
                1 1 1 1 1 1 1 1 1 1 1 1 1
                9 S 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 1 5 9 9 9
                9 9 9 9 9 9 9 9 1 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 9 9 9 9 9 5 9 9 9
                9 9 9 9 Z 5 5 5 5 5 9 9 9
                1 1 1 1 1 1 1 1 1 1 1 1 1
                 */

                break;
            case RIGHT:

                break;
            case UP:
                break;
            case DOWN:
                break;
        }

    }

    private Route umweg(Position start, Position ziel, int n, boolean up, boolean right) {
        Route retVal = new Route(start, ziel);
        if(up && right) {

        } else if(up && !right) {

        } else if(!up && right) {

        } else if(!up && !right) {

        }
    }

    public int getPrice() {
        return price;
    }
}
