import java.util.Scanner;

class TicTacToe
{
    interface Basic
    {
        char getChar();
        String PrintWin();
    }

    class Cross implements Basic
    {
        public char getChar()
        {
            return 'X';
        }
        public String PrintWin()
        {
            return "X WIN!";
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
            return "O WIN!";
        }
    }
    class Empty implements Basic
    {
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
    String CURR_SIGN = "X";
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
            printTable();
            turn();
            if (checkWin(SIGN_X))
            {
                System.out.println(GetSign().PrintWin());
                break;
            }
            if(isEmptyBoxExist())
            {
                System.out.println("Game over!");
                break;
            }
            printTable();
            turn();
            if (checkWin(SIGN_O))
            {
                System.out.println(GetSign().PrintWin());
                break;
            }
            if(isEmptyBoxExist())
            {
                System.out.println("Game over!");
                break;
            }
        }
        System.out.println("GAME OVER");
        printTable();
    }

}