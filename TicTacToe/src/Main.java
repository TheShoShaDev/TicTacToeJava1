import java.util.Scanner;

class TicTacToe
{
    interface Basic
    {
        char getChar();
        String PrintWin();
    }

    interface Basic1 extends  Basic
    {

    }

    class Cross implements Basic
    {
        public char getChar()
        {
            return 'X';
        }
        public String PrintWin()
        {
            return "О WIN!";
        }
    }
    class Cirle implements Basic
    {
        public char getChar()
        {
            return  '0';
        }
        public String PrintWin()
        {
            return "Х WIN!";
        }
    }
     class Empty implements Basic
    {
        void changeLocalSign(){
            CURR_SIGN = "!";
        }
        public char getChar()
        {
            return '*';
        }
        public String PrintWin()
        {
            return "No1 WIN!";
        }
    }
    final Basic SIGN_X = new Cross();
    final Basic SIGN_O = new Cirle();
    static String CURR_SIGN = "X";
    final Basic SIGN_EMPTY = new Empty();
    Basic[][] table;
    Scanner scanner;

    public static void main(String[] args)
    {
        new TicTacToe().game();
    }

    TicTacToe()
    {
        scanner = new Scanner(System.in);
        table = new Basic[3][3];
    }

    void game()
    {
        initTable();
        while (true)
        {
            if (checkWin(SIGN_X))
            {
                System.out.println(GetSign().PrintWin());
                break;
            }
            printTable();
            turn();
            if(isEmptyBoxExist())
            {
                System.out.println("Game over!");
                break;
            }
            if (checkWin(SIGN_O))
            {
                System.out.println(GetSign().PrintWin());
                break;
            }
            printTable();
            turn();
            if(isEmptyBoxExist())
            {
                System.out.println("Game over!");
                break;
            }
        }
        System.out.println("GAME OVER");
        printTable();
    }
    void initTable()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                table[row][col] = SIGN_EMPTY;
            }
        }
    }
    void printTable()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                System.out.print(table[row][col].getChar() + " ");
            }
            System.out.println();
        }
    }
    void turn()
    {
        System.out.println("Enter X (1..9):");
        printhint();
        int pos = 1;
        do
        {
            pos = scanner.nextInt();
            if (pos <= 9 && pos >= 1) {
                pos = pos - 1;
                int j = pos % 3;
                int i = pos / 3;
                if (table[i][j] == SIGN_EMPTY) {
                    table[i][j] = GetSign();
                    break;
                } else {
                    System.out.println("Error. Try again");
                }
            } else {
                System.out.println("Error. You fool");
            }
        }
        while (pos > 0 || pos < 0);

    }

    boolean checkWin(Basic dot)
    {
        for (int i = 0; i < 3; i++)
        {
            if ((table[i][0].equals(dot) && table[i][1].equals(dot) &&
                    table[i][2].equals(dot)) ||
                    (table[0][i].equals(dot) && table[1][i].equals(dot) &&
                            table[2][i].equals(dot)))
            {
                return true;
            }
        }
        return (table[0][0].equals(dot) && table[1][1].equals(dot) &&
                table[2][2].equals(dot)) ||
                (table[2][0].equals(dot) && table[1][1].equals(dot) &&
                        table[0][2].equals(dot));

    }

    boolean isEmptyBoxExist()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (table[row][col] == SIGN_EMPTY)
                {
                    return false;
                }
            }

        }
        return true;
    }

    Basic GetSign()
    {
        if (CURR_SIGN != "X")
        {
            CURR_SIGN = "X";
            return SIGN_X;
        }
        else
        {
            CURR_SIGN = "O";
            return SIGN_O;
        }
    }
    void printhint()
    {
        System.out.println("[1][2][3]");
        System.out.println("[4][5][6]");
        System.out.println("[7][8][9]");
    }
}