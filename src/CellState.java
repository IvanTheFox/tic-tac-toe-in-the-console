public enum CellState {
    Empty(0),
    Cross(1),
    Circle(2);

    private int value;
    private CellState(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}