package sample;
import sample.model.Board;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(5);
        Scanner scanner = new Scanner(System.in);

        while (!board.isGameOver()) {
            board.printBoard();
            System.out.println("Movimientos disponibles: arriba, abajo, izquierda, derecha.");
            System.out.print("Ingresa un movimiento: ");
            String direction = scanner.nextLine();
            board.moveMouse(direction);
        }
    }
}