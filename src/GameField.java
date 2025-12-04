public class GameField {
    private CellState [][] Cells;
    public GameField() {
        Cells = new CellState[3][3];
        for (var CellRow:Cells){
            for (var Cell:CellRow){
                Cell=CellState.Empty;
            }
        }
    }
    public void Reset(){
        for (var CellRow:Cells){
            for(var Cell:CellRow){
                Cell=CellState.Empty;
            }
        }
    }
    public void Mark(int x,int y, CellState state){
        Cells [x-1][y-1]=state;
    }
    public CellState GetState(int x, int y){
        return Cells[x-1][y-1];
    }
}
