package app;

public class Game {
    private GameField field;
    private boolean isCrossNext;

    public void Reset(){
        field.Reset();
    }

    Game(){
        this.field = new GameField();
        isCrossNext = true;
    }

    public void PlaceMark(int x, int y) throws Exception {
        CellState newState;
        if (isCrossNext) {
            newState = CellState.Cross;
        }
        else {
            newState = CellState.Circle;
        }
        CellState oldState = field.GetState(x,y);
        if (oldState == CellState.Empty){
            field.Mark(x,y,newState);
        }
        else {
            throw new Exception("Эта клетка уже занята!");
        }
    }

    public CellState CheckWin(){
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
    }
}