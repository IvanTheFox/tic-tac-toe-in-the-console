package testing;
import app.CellState;
import app.Game;
import app.GameField;

public class GameTest {

    private static Game game;

    public static void main(String args[]){
        game = new Game();
        try {
            game.PlaceMark(1, 1);
            game.PlaceMark(1,2);
            game.PlaceMark(2,1);
            game.PlaceMark(1,3);
            game.PlaceMark(3,1);
            System.out.println(game.CheckWin());
        }
        catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
