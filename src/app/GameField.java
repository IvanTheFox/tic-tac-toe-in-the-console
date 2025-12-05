package app;
public class GameField {
    private CellState [][] Cells;
    public GameField() {
        Cells = new CellState[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Cells[x][y] = CellState.Empty;
            }
        }
    }
    public void Reset() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Cells[x][y] = CellState.Empty;
            }
        }
    }
    public void Mark(int x,int y, CellState state){
        Cells [x][y]=state;
    }
    public CellState GetState(int x, int y){
        return Cells[x][y];
    }
}
