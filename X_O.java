import java.util.*;

public class X_O {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introdu in celula (1-9): ");
            int playerPos = sc.nextInt();
            placePiece(gameBoard, playerPos, "player");

            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            String result = checkWinner();
            System.out.println(result);
        }

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();

        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;

        }
    }

    public static String checkWinner() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> firstCol = Arrays.asList(1, 4, 7);
        List<Integer> secondCol = Arrays.asList(2, 5, 8);
        List<Integer> thirdCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List> winningCondition = new ArrayList<List>();
        winningCondition.add(topRow);
        winningCondition.add(middleRow);
        winningCondition.add(botRow);
        winningCondition.add(firstCol);
        winningCondition.add(secondCol);
        winningCondition.add(thirdCol);
        winningCondition.add(cross1);
        winningCondition.add(cross2);

        for (List l : winningCondition) {

            if (playerPositions.containsAll(l)) {
                return "Ai cistigat";
            } else if (cpuPositions.containsAll(l)) {
                return "You lose! Don't worry! :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9)
                return "Egal";

        }


        return "";
    }
}
