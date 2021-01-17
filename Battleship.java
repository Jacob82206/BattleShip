import java.util.Arrays;
import java.util.Random;
/**
 * This program allows the user to play the gane Battleship
 *
 * @author (Jacob Kuntz)
 * @version (1.0)
 */
public class Battleship
{
    public static void main(String[] args) {
        int gameBoardLength = 4;
        char water = '-';
        char ship = 's';
        char hit = 'X';
        char miss = '0';
        int shipNumber = 3;
        
        
        char[][] gameBoard = createGameBoard(gameBoardLength, water, ship, shipNumber);
        printGameBoard(gameBoard, water, ship);
    }
    
    private static void printGameBoard(char[][] gameBoard, char water, char ship) {
        int gameBoardLength = gameBoard.length;
                for (int row = 0; row < gameBoardLength; row++){
                    for (int col = 0; col < gameBoardLength; col++){
                        char position = gameBoard[row][col];
                        if (position == ship) { 
                            System.out.print(water + " ");
                        } else {
                            System.out.print(position + " ");
                        }
                    }
        }
    }
    
    private static char[][] createGameBoard(int gameBoardLength, char water, char ship, int shipNumber) {
        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }
        return placeShips(gameBoard, shipNumber, water, ship);
    }
    
    private static char[][] placeShips(char[][] gameBoard, int shipNumber, char water, char ship) {
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placedShips < shipNumber) {
            int[] location = generateShipCoordinates(gameBoardLength);
            char possiblePlacement = gameBoard[location[0]][location[1]];
            if (possiblePlacement == water) {
                gameBoard[location[0]][location[1]] = ship;
                placedShips++;
            }
        }
        return gameBoard;
    }

    private static int[] generateShipCoordinates(int gameBoardLength) {
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }
}

