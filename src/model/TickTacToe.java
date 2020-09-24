package model;

import java.util.*;

public class TickTacToe {

    static boolean winner = false;

    static Scanner in = new Scanner(System.in);

    private static char [][] game = {{' ' , '|' , ' ' , '|' , ' '},
        {'+' , '+' , '+' , '+' , '+'},
        {' ' , '|' , ' ' , '|' , ' '},
        {'+' , '+' , '+' , '+' , '+'},
        {' ' , '|' , ' ' , '|' , ' '},};

    static ArrayList<Integer> pPos = new ArrayList<>();
    static ArrayList<Integer> cPos = new ArrayList<>();

    public static void displayBoard(){
        for(char[] r: game){
            for(char c: r){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void addToBoard(String user){

        int move = 0;
        char xo = '0';
        Random r = new Random();

        if (user.equals("player")){
            move = in.nextInt();
            while(pPos.contains(move) || cPos.contains(move)){
                System.out.println("Please enter a valid position");
                move = in.nextInt();
            }
            pPos.add(move);
            xo = 'X';
        } else if(user.equals("computer")){
            move = r.nextInt(9) + 1;
            while(pPos.contains(move) || cPos.contains(move)){
                move = r.nextInt(9) + 1;
            }
            cPos.add(move);
            xo = 'O';
        }

        if(move == 1) {
            game[0][0] = xo;
        } else if(move == 2) {
            game[0][2] = xo;
        } else if(move == 3) {
            game[0][4] = xo;
        } else if(move == 4) {
            game[2][0] = xo;
        } else if(move == 5) {
            game[2][2] = xo;
        } else if(move == 6) {
            game[2][4] = xo;
        } else if(move == 7) {
            game[4][0] = xo;
        } else if(move == 8) {
            game[4][2] = xo;
        } else if(move == 9){
            game[4][4] = xo;
        } else {
            System.out.println("N/A.. Try again");
        }


    }
    static public boolean win(){
        List tr = Arrays.asList(1,2,3);
        List mr = Arrays.asList(4,5,6);
        List br = Arrays.asList(7,8,9);
        List lc = Arrays.asList(1,4,7);
        List mc = Arrays.asList(2,5,8);
        List rc = Arrays.asList(3,6,9);
        List cr1 = Arrays.asList(1,5,9);
        List cr2 = Arrays.asList(3,5,7);

        List<List> winn = new ArrayList<>();
        winn.add(tr);
        winn.add(mr);
        winn.add(br);
        winn.add(lc);
        winn.add(mc);
        winn.add(rc);
        winn.add(cr1);
        winn.add(cr2);

        for(List l: winn){
            if(pPos.containsAll(l)){
                System.out.println("Congrats! You won!");
                return true;
            } else if (cPos.containsAll(l)){
                System.out.println("CPU Wins! Better luck next time!");
                return true;
            } else if (pPos.size() + cPos.size() == 9){
                System.out.println("Game TIED, Start again :D");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        displayBoard();

        while(!winner){
            addToBoard("player");
            addToBoard("computer");
            displayBoard();
            if (win()){
                break;
            }
        }
    }
}
