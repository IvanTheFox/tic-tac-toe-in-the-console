package app;

public class Game {
    public GameField field;
    private boolean isCrossNext;

    public void Reset(){
        field.Reset();
        isCrossNext = true;
    }

    public Game(){
        this.field = new GameField();
        isCrossNext = true;
    }

    public void PlaceMark(int x, int y) throws Exception {
        if (!(1 <= x && x <= 3)){
            throw new Exception("Недопустимые координаты для x");
        }
        if (!(1 <= y && y <= 3)){
            throw new Exception("Недопустимые координаты для y");
        }
        CellState newState;
        if (isCrossNext) {
            newState = CellState.Cross;
        }
        else {
            newState = CellState.Circle;
        }
        CellState oldState = field.GetState(x-1,y-1);
        if (oldState == CellState.Empty){
            field.Mark(x-1,y-1,newState);
            isCrossNext = !isCrossNext;

        }
        else {
            throw new Exception("Эта клетка уже занята!");
        }

    }

    public boolean IsFieldFull() {
        boolean flag = true;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (this.field.GetState(x, y) == CellState.Empty) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public CellState CheckWin(){
        // Проверка диагоналей для крестика
        boolean crossWinToRight = true;
        boolean crossWinToLeft = true;
        for (int i = 0; i < 3; i++){
            crossWinToRight = crossWinToRight & (field.GetState(i,i) == CellState.Cross);
            crossWinToLeft = crossWinToLeft & (field.GetState(2-i,i) == CellState.Cross);
        }
        if (crossWinToLeft || crossWinToRight){
            return CellState.Cross;
        }
        // Проверка вертикалей и горизонталей для крестика
        for (int i = 0; i < 3; i++) {
            // Проверка строки i
            if (field.GetState(i, 0) == CellState.Cross &&
                    field.GetState(i, 1) == CellState.Cross &&
                    field.GetState(i, 2) == CellState.Cross) {
                return CellState.Cross;
            }
            // Проверка столбца i
            if (field.GetState(0, i) == CellState.Cross &&
                    field.GetState(1, i) == CellState.Cross &&
                    field.GetState(2, i) == CellState.Cross) {
                return CellState.Cross;
            }
        }

        // Проверка диагоналей для нолика
        boolean circleWinToRight = true;
        boolean circleWinToLeft = true;
        for (int i = 0; i < 3; i++){
            circleWinToRight = circleWinToRight & (field.GetState(i,i) == CellState.Circle);
            circleWinToLeft = circleWinToLeft & (field.GetState(2-i,i) == CellState.Circle);
        }
        if (circleWinToLeft || circleWinToRight){
            return CellState.Circle;
        }
        // Проверка вертикалей и горизонталей для нолика
        for (int i = 0; i < 3; i++) {
            if (field.GetState(i, 0) == CellState.Circle &&
                    field.GetState(i, 1) == CellState.Circle &&
                    field.GetState(i, 2) == CellState.Circle) {
                return CellState.Circle;
            }
            if (field.GetState(0, i) == CellState.Circle &&
                    field.GetState(1, i) == CellState.Circle &&
                    field.GetState(2, i) == CellState.Circle) {
                return CellState.Circle;
            }
        }

        // Случай ничьи
        return CellState.Empty;
    }
}