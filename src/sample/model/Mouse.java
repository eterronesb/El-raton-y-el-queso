package sample.model;
import java.util.HashSet;
import java.util.Set;

public class Mouse {
    private int row, col;
    private Set<String> visitedCells;

    public Mouse() {
        this.row = 0;
        this.col = 0;
        this.visitedCells = new HashSet<>();
        visitCell(row,col);
    }
    public int getRow(){
        return row;
    }
    public int getCol() {
        return col;
    }
    public void move( int newRow, int newCol) {
        if (isValidMove(newRow, newCol)) {
            this.row = newRow;
            this.col = newCol;
            visitCell(newRow, newCol);
        } else {
            System.out.println("Movimiento invalido.");
        }
    }
    public boolean isValidMove(int newRow, int newCol){
            return newRow >= 0 && newRow < 5 && newCol >= 0 && newCol < 5 && !visitedCells.contains(newRow + "," + newCol);
    }
    private void visitCell(int row, int col){
            visitedCells.add(row + "," + col);
    }
}
