package tictactoe;

public class Shot {
    public final String[] coordinate;
    public final String mark;

    public Shot(String[] coordinate, String mark) {
        this.coordinate = coordinate;
        this.mark = mark;
    }

    public static boolean isValidCoordinate(String[] coordinate) {
        String numbers = "0123456789";
        return coordinate.length == 2
                && (numbers.contains(coordinate[0]) && numbers.contains(coordinate[1]));
    }
}
