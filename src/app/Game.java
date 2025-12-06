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

        // Проверка диагоналей для нолика
        boolean circleWinToRight = true;
        boolean circleWinToLeft = true;
        for (int i = 1; i < 4; i++){
            circleWinToRight = circleWinToRight & (field.GetState(i,i) == CellState.Circle);
            circleWinToLeft = circleWinToLeft & (field.GetState(4-i,i) == CellState.Circle);
        }
        if (circleWinToLeft || circleWinToRight){
            return CellState.Circle;
        }
        // Проверка вертикалей и горизонталей для нолика
        boolean circleWinOnRows = true;
        boolean circleWinOnCols = true;
        for (int col = 1; col < 4; col++) {
            for (int row = 1; row < 4; row++) {
                circleWinOnRows = circleWinOnRows & (field.GetState(row, col) == CellState.Circle);
                circleWinOnCols = circleWinOnRows & (field.GetState(col, row) == CellState.Circle);
            }
        }
        if (circleWinOnCols || circleWinOnRows){
            return CellState.Circle;
        }
        // Случай ничьи
        return CellState.Empty;
    };
}