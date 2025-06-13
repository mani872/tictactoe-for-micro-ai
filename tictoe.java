import java.util.Scanner;
public class tictoe {
static char[][] board ={
{' ', '|', ' ', '|', ' '},
{'-', '+', '-', '+', '-'},
{' ', '|', ' ', '|', ' '},
{'-', '+', '-', '+', '-'},
{' ', '|', ' ', '|', ' '}
 };
 public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);
    boolean isPlayer1Turn = true;
    int moves = 0;

     while (true){
        printBoard();
        if (isPlayer1Turn) {
        System.out.print("Player 1 (X), enter your move (1-9): ");
        }
        else {
        System.out.print("Player 2 (O), enter your move (1-9): ");
        }
        int pos = scanner.nextInt();
        char symbol = isPlayer1Turn ? 'X' : 'O';
        if(placeMove(pos, symbol)){
        moves++;
        if(checkWinner(symbol)) {
         printBoard();
        System.out.println("Player " + (isPlayer1Turn ? "1" : "2") + " wins!");
        break;
        }
        else if(moves == 9){
        printBoard();
        System.out.println("It's a draw!");
        break;
        }
        isPlayer1Turn = !isPlayer1Turn;
        } 
        else {
                System.out.println("Invalid move! Try again.");
            }
        }
       scanner.close();
    }

    public static void printBoard(){
        for(char[] row : board){
        for (char c : row){
             System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean placeMove(int pos, char symbol){
        int row = 0, col = 0;
        switch (pos){
            case 1 -> {row = 0; col = 0;}
            case 2 -> {row = 0; col = 2;}
            case 3 -> {row = 0; col = 4;}
            case 4 -> {row = 2; col = 0;}
            case 5 -> {row = 2; col = 2;}
            case 6 -> {row = 2; col = 4;}
            case 7 -> {row = 4; col = 0;}
            case 8 -> {row = 4; col = 2;}
            case 9 -> {row = 4; col = 4;}
            default ->{return false; }
        }

        if (board[row][col] == ' '){
        board[row][col] = symbol;
            return true;
        }

        return false;
    }

    public static boolean checkWinner(char symbol){
        for (int i = 0; i <= 4; i += 2) {
            if (board[i][0] == symbol && board[i][2] == symbol && board[i][4] == symbol)
                return true;
            if (board[0][i] == symbol && board[2][i] == symbol && board[4][i] == symbol)
                return true;
        }
        return (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
               (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol);
    }
}