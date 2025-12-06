package app;

public class Game {
    private GameField field;
    private boolean isCrossNext;

    public void Reset(){
        field.Reset();
    };
    // Возвращает true, если ход совершен, в противном случае - false
    public boolean PlaceMark(int x, int y, CellState newState){
        CellState oldState = field.GetState(x,y);
        if (oldState == CellState.Empty){
            field.Mark(x,y,newState);
            return true;
        }
        return false;
    };
    public CellState CheckWin(){

        return CellState.Empty;
    };
}