package testing;
import app.*;

public class GameFieldTesting {
    private static void printCells(GameField field) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(field.GetState(x,y));
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String args[]) {
        GameField field = new GameField();
        field.Mark(0, 0, CellState.Cross);
        field.Mark(2, 1, CellState.Circle);
        field.Mark(1, 0, CellState.Cross);
        printCells(field);
        field.Reset();
        printCells(field);
    }
}
