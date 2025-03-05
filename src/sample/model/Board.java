package sample.model;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private GameCell[][] grid;
    private int size;
    private Mouse mouse;
    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public Board(int size) {
        this.size = size;
        this.grid = new GameCell[size][size];
        this.mouse = new Mouse();
        this.gameOver = false;
        initializeBoard();
    }
    private void initializeBoard() {
        Random random = new Random();

        for(int i = 0; i<size; i ++) {
            for (int j = 0; j<size; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = new ScoreCell(0);
                } else if (i == size - 1 && j == size -1) {
                    grid[i][j] = new EndGameCell(EndGamecellType.Cheese);
                } else {
                    int rand = random.nextInt(100);
                    if (rand<10) {
                        grid[i][j] = new EndGameCell(EndGamecellType.Cat);
                    } else if (rand < 20) {
                        grid[i][j] = new BonusCell(20, "¿Cuánto es 2 + 2?", new String[]{"3", "4", "5"}, 2);
                    } else if (rand < 30) {
                        grid[i][j] = new PenaltyCell(-10);
                    } else {
                        grid[i][j] = new ScoreCell((random.nextInt(3) + 1) * 10);
                    }
                    }
                }
            }
        }
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == mouse.getRow() && j == mouse.getCol()) {
                    System.out.print("M ");
                } else{
                    System.out.print(grid[i][j].toString() + " ");
                }
            }
            System.out.println();
        }
    }
    public void moveMouse(String direction){
        if(gameOver){
            System.out.println("El juego ha terminado.");
            return;
        }
        int currentRow = mouse.getRow();
        int currentCol = mouse.getCol();

        switch (direction.toLowerCase()) {
            case "arriba":
                mouse.move(currentRow - 1, currentCol);
                break;
            case "abajo":
                mouse.move(currentRow + 1, currentCol);
                break;
            case "izquierda":
                mouse.move(currentRow, currentCol - 1);
                break;
            case "derecha":
                mouse.move(currentRow, currentCol + 1);
                break;
            default:
                System.out.println("Dirección no válida.");
                return;
        }
        checkGameOver();
    }
    private void checkGameOver() {
        int row = mouse.getRow();
        int col = mouse.getCol();

        if (grid[row][col] instanceof EndGameCell && ((EndGameCell) grid[row][col]).getType() == EndGamecellType.Cheese) {
            System.out.println("¡El ratón ha llegado al queso! ¡Ganaste!");
            gameOver = true;
        }
        else if (grid[row][col] instanceof EndGameCell && ((EndGameCell) grid[row][col]).getType() == EndGamecellType.Cat) {
            System.out.println("¡El ratón ha sido atrapado por el gato! Fin del juego.");
            gameOver = true;
        }
        else if (mouseIsTrapped()) {
            System.out.println("¡El ratón está atrapado! Fin del juego.");
            gameOver = true;
        }
    }
    private boolean mouseIsTrapped() {

        int row = mouse.getRow();
        int col = mouse.getCol();
        return !(isMoveValid(row - 1, col) || isMoveValid(row + 1, col) || isMoveValid(row, col - 1) || isMoveValid(row, col + 1));
    }
    private boolean isMoveValid(int newRow, int newCol) {
        return mouse.isValidMove(newRow, newCol) && grid[newRow][newCol] instanceof ScoreCell;
    }
}

