import java.util.Scanner;
public class MyTicTacToe {

    private String [][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    public static void main(String[]args){
        MyTicTacToe spel = new MyTicTacToe();
        do{
            spel.printBord();
            spel.spelareSpelare();
            if(spel.harVunnit()){
                break;
            }
            spel.datorSpelar();
            if(spel.harVunnit()){
                break;
            }
        }while(true);
        spel.printBord();
    }

    private void datorSpelar() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(rättVal(i,j)){
                    board[i][j] = "O";
                    return;
                }
            }
        }
    }

    private boolean harVunnit() {
        int x = 0;
        int o = 0;

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("X")) {
                    x++;
                } else if (board[i][j].equals("O")) {
                    o++;
                }
            }
            if (x == 3 || o == 3) {
                System.out.println("Player " + ((x == 3) ? "X" : "O") + " has won the game");
                return true;
            }
            x = o = 0;
        }

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals("X")) {
                    x++;
                } else if (board[j][i].equals("O")) {
                    o++;
                }
            }
            if (x == 3 || o == 3) {
                System.out.println("Player " + ((x == 3) ? "X" : "O") + " has won the game");
                return true;
            }
            x = o = 0;
        }

        for(int i = 0; i < 3; i++) {
                if (board[i][i].equals("X")) {
                    x++;
                } else if (board[i][i].equals("O")) {
                    o++;
                }
            if (x == 3 || o == 3) {
                System.out.println("Player " + ((x == 3) ? "X" : "O") + " has won the game");
                return true;
            }
        }
        x = o = 0;

        for(int i = 0; i < 3; i++) {
            if (board[i][2-i].equals("X")) {
                x++;
            } else if (board[i][2-i].equals("O")) {
                o++;
            }
            if (x == 3 || o == 3) {
                System.out.println("Player " + ((x == 3) ? "X" : "O") + " has won the game");
                return true;
            }
        }
        return false;
    }

    private void spelareSpelare() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv in position för X, t.ex. A1");
        int förstaIndex = 0;
        int andraIndex = 0;
        boolean placerad = false;

        do{
            String val = "";
            val = sc.next();
            char [] xy = val.toCharArray();

            if(xy.length != 2 || !((xy[0] == 'A' || xy[0] == 'B' || xy[0] == 'C') && (xy[1] == '1' || xy[1] == '2' || xy[1] == '3'))){
                System.out.println("Du har skrivit in felformat. Du ska skriva t.ex. A1");
            } else{
                förstaIndex = xy[0] - 'A';
                andraIndex = xy[1] - '1';

                placerad = rättVal(förstaIndex, andraIndex);
                if(!placerad){
                    System.out.println("Den positionen är upptagen. Välj en annan");
                } else {
                    board[förstaIndex][andraIndex] = "X";
                }
            }
        }while(!placerad);
    }

    private boolean rättVal(int förstaIndex, int andraIndex) {
        if(board[förstaIndex][andraIndex] == " "){
            return true;
        }else{
            return false;
        }
    }

    public void printBord() {
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("---------------");
        System.out.printf ("A | %s | %s | %s |\n", board[0][0], board[0][1],board[0][2]);
        System.out.println("---------------");
        System.out.printf ("B | %s | %s | %s |\n", board[1][0], board[1][1],board[1][2]);
        System.out.println("---------------");
        System.out.printf ("C | %s | %s | %s |\n", board[2][0], board[2][1],board[2][2]);
        System.out.println("---------------");
    }
}
