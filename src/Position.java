public class Position {

    private int x;
    private int y;
    private int price;

    public Position(Position pos) {
        x = pos.x;
        y = pos.y;
        price = pos.price;
    }

    public Position(int x, int y, int price) {
        this.x = x;
        this.y = y;
        this.price = price;
    }

    public Position add(Position pos) {
        int newX = pos.getX() + x;
        int newY = pos.getY() + y;
        return new Position(newX, newY, Baukosten.field[newX-1][newY-1]);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position pos = (Position) obj;
            return x == pos.x && y == pos.y && price == pos.price;
        }
        return false;
    }

    @Override
    public String toString() {
        return ("(" + x + "," + y + ")");
    }
}
