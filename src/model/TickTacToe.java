package model;

import java.util.Scanner;

public class TickTacToe {
    static Scanner in = new Scanner(System.in);
    private static char [][] game = {{' ' , '|' , ' ' , '|' , ' '},
        {'+' , '+' , '+' , '+' , '+'},
        {' ' , '|' , ' ' , '|' , ' '},
        {'+' , '+' , '+' , '+' , '+'},
        {' ' , '|' , ' ' , '|' , ' '},};

    public static void displayBoard(){
        for(int r=0; r<game.length; r++){
            for(int c=0; c<game[r].length; c++){
                System.out.print(game[r][c]);
            }
            System.out.println();
        }
    }

    public static void addToBoard(){

        int move = in.nextInt();

        if(move == 1) {
            game[0][0] = 'X';
        } else if(move == 2) {
            game[0][2] = 'X';
        } else if(move == 3) {
            game[0][4] = 'X';
        } else if(move == 4) {
            game[2][0] = 'X';
        } else if(move == 5) {
            game[2][2] = 'X';
        } else if(move == 6) {
            game[2][4] = 'X';
        } else if(move == 7) {
            game[4][0] = 'X';
        } else if(move == 8) {
            game[4][2] = 'X';
        } else if(move == 9){
            game[4][4] = 'X';
        } else {
            System.out.println("N/A.. Try again");
        }


    }
    public static void main(String[] args) {

        displayBoard();

        for(int r=0;r<9;r++){
            addToBoard();
            displayBoard();
        }
    }
}
