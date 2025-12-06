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
    public CellState CheckWin(GameField field){
        // Проверка диагоналей для крестика
        boolean crossWinToRight = true;
        boolean crossWinToLeft = true;
        for (int i = 1; i < 4; i++){
            crossWinToRight = crossWinToRight & (field.GetState(i,i) == CellState.Cross);
            crossWinToLeft = crossWinToLeft & (field.GetState(4-i,i) == CellState.Cross);
        }
        if (crossWinToLeft || crossWinToRight){
            return CellState.Cross;
        }
        // Проверка вертикалей и горизонталей для крестика
        boolean crossWinOnRows = true;
        boolean crossWinOnCols = true;
        for (int col = 1; col < 4; col++) {
            for (int row = 1; row < 4; row++) {
                crossWinOnRows = crossWinOnRows & (field.GetState(row, col) == CellState.Cross);
                crossWinOnCols = crossWinOnRows & (field.GetState(col, row) == CellState.Cross);
            }
        }
        if (crossWinOnCols || crossWinOnRows){
            return CellState.Cross;
        }

        return CellState.Empty;
    };
}