package testing;
import app.CellState;
import app.Game;
import app.GameField;

public class GameTest {

    private final static Game game = new Game();
    public static void main(String args[]){
        try {
            // Тест1. Победа за крестик по верхней горизонтали
            game.PlaceMark(1, 1);
            game.PlaceMark(1,2);
            game.PlaceMark(2,1);
            game.PlaceMark(1,3);
            game.PlaceMark(3,1);
            System.out.println("Тест1: " + game.CheckWin());

            // Тест2. Победа за нолик по средней горизонтали
            game.Reset();
            game.PlaceMark(3,3);
            game.PlaceMark(1,2);
            game.PlaceMark(2,3);
            game.PlaceMark(2,2);
            game.PlaceMark(3,1);
            game.PlaceMark(3,2);
            System.out.println("Тест2: " + game.CheckWin());

            // Тест3. Победа за нолик по правой вертикали
            game.Reset();
            game.PlaceMark(2,1);
            game.PlaceMark(3,1);
            game.PlaceMark(1,2);
            game.PlaceMark(3,2);
            game.PlaceMark(1,1);
            game.PlaceMark(3,3);
            System.out.println("Тест3: " + game.CheckWin());

            // Тест4. Победа за крестик по диагонали (из верхнего правого угла до левого нижнего)
            game.Reset();
            game.PlaceMark(3,1);
            game.PlaceMark(1,1);
            game.PlaceMark(2,2);
            game.PlaceMark(3,2);
            game.PlaceMark(1,3);
            System.out.println("Тест4: " + game.CheckWin());

            // Тест5. Победа за нолик по диагонали (из верхнего левого угла до правого нижнего)
            game.Reset();
            game.PlaceMark(2,1);
            game.PlaceMark(1,1);
            game.PlaceMark(3,1);
            game.PlaceMark(2,2);
            game.PlaceMark(2,3);
            game.PlaceMark(3,3);
            System.out.println("Тест5: " + game.CheckWin());

            // Тест6. Выход за пределы поля
            game.Reset();
            System.out.print("Тест6: ");
            // game.PlaceMark(2,4);
            System.out.print("\n");

            // Тест7. Ход в клетку, где уже есть фигура
            game.Reset();
            System.out.print("Тест7: ");
            game.PlaceMark(2,2);
            // game.PlaceMark(2,2);
            System.out.print("\n");

            // Тест8. Проверка заполненности поля (поле не заполнено)
            game.Reset();
            System.out.print("Тест8: ");
            System.out.println(game.IsFieldFull());

            // Тест9. Проверка заполнения поля (поле заполнено)
            System.out.print("Тест 9: ");
            for (int x = 1; x < 4; x++) {
                for (int y = 1; y < 4; y++) {
                    game.PlaceMark(x, y);
                }
            }
            System.out.println(game.IsFieldFull());
        }
        catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
