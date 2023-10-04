package bisharasaidlab4;

/*
course: CSC191
project: Lab Assignment 4
date due: 2/8/2023 
author: Bishara Said
purpose: A java program that will allow two users to play tic, tac, toe with a
    3x3 board. The the two players should be able to alternatively enter their
    X or O. A player should not be able to place their X or O on aspot already
    taken on the board.

    The program will check for a winner and continue if there isn't a winner. A
    player wins when they get three symbols in a row in one of three directions:
    horizontally, vertically, or diagonally.

    The program will display the winner when one is found or display that it was
    a draw once all the boxes on the board have been filled.

    The program should allow the users to keep playing against each other until
    they are ready to quit. When they quit, the program should tell te users how
    many games each player won as well as how many ties there were.
*/

import java.util.Scanner;
    
//the Tic Tac Toe class
class TTT {
    Scanner in = new Scanner(System.in);
    //data members
    char[][] board;
    int rows, cols;
    
    //default constructor
    public TTT() {
        board = new char[3][3];
        rows = 0;
        cols = 0;
    }

    //This method will change values in our board to simulate the game
    //It will call printBoard to display the board, and findWinner to find out
    //when to stop the game if we did. When the game completes with the board
    //filled, we know the game is a tie.
    public int setBoard() {
        char symbol;
        for (int i = 0; i < 4; i++) {
            //ask player X for row and column to put their symbol
            System.out.println("Enter a row (1, 2, or 3) for player X:");
            rows = in.nextInt();
            //input validation for rows
            while (rows>3 || rows<1) {
                System.out.println("The rows must be between 1 and 3");
                System.out.println("Enter a row (1, 2, or 3) for player X:");
                rows = in.nextInt();
            }
            System.out.println("Enter a column (1, 2, or 3) for player X:");
            cols = in.nextInt();
            //input validation for cols
            while (cols>3 || cols<1) {
                System.out.println("The rows must be between 1 and 3");
                System.out.println("Enter a column (1, 2, or 3) for player X:");
                cols = in.nextInt();
            }
            
            //make sure the spot wasn't taken before
            while (this.board[rows-1][cols-1] != 0) {
                System.out.println("This spot was taken, try again.");
                System.out.println("Enter a row (1, 2, or 3) for player X:");
                rows = in.nextInt();
                System.out.println("Enter a column (1, 2, or 3) for player X:");
                cols = in.nextInt();
            }
            this.board[rows-1][cols-1] = 'X';
            printBoard(board);
            
            //check if there is a winner
            symbol = findWinner();
            if (symbol == 'X') {
                System.out.println("Player X Won!");
                return 1;
            }else if (symbol == 'O') {
                System.out.println("Player O wins!");
                return 2;
            }else {
            }
            
            //ask player O for row and column to put their symbol
            System.out.println("Enter a row (1, 2, or 3) for player O:");
            rows = in.nextInt();
            //input validation for rows
            while (rows>3 || rows<1) {
                System.out.println("The rows must be between 1 and 3");
                System.out.println("Enter a row (1, 2, or 3) for player O:");
                rows = in.nextInt();
            }
            System.out.println("Enter a column (1, 2, or 3) for player O:");
            cols = in.nextInt();
            //input validation for cols
            while (cols>3 || cols<1) {
                System.out.println("The rows must be between 1 and 3");
                System.out.println("Enter a column (1, 2, or 3) for player O:");
                cols = in.nextInt();
            }
            
            //make sure the spot wasn't taken before
            while (this.board[rows-1][cols-1] != 0) {
                System.out.println("This spot was taken, try again.");
                System.out.println("Enter a row (1, 2, or 3) for player O:");
                rows = in.nextInt();
                System.out.println("Enter a column (1, 2, or 3) for player O:");
                cols = in.nextInt();
            }
            this.board[rows-1][cols-1] = 'O';
            printBoard(board);
            
            //check if there is a winner
            symbol = findWinner();
            if (symbol == 'X') {
                System.out.println("Player X Won!");
                return 1;
            }else if (symbol == 'O') {
                System.out.println("Player O wins!");
                return 2;
            }else {
            }
        }
        //player X is asked one more time to fill the last remaining spot
        //ask player X for row and column to put their symbol
        System.out.println("Enter a row (1, 2, or 3) for player X:");
        rows = in.nextInt();
        //input validation for rows
        while (rows>3 || rows<1) {
            System.out.println("The rows must be between 1 and 3");
            System.out.println("Enter a row (1, 2, or 3) for player X:");
            rows = in.nextInt();
        }
        System.out.println("Enter a column (1, 2, or 3) for player X:");
        cols = in.nextInt();
        //input validation for cols
        while (cols>3 || cols<1) {
            System.out.println("The rows must be between 1 and 3");
            System.out.println("Enter a column (1, 2, or 3) for player X:");
            cols = in.nextInt();
        }
        //make sure the spot wasn't taken before
        while (this.board[rows-1][cols-1] != 0) {
            System.out.println("This spot was taken, try again.");
            System.out.println("Enter a row (1, 2, or 3) for player X:");
            rows = in.nextInt();
            System.out.println("Enter a column (1, 2, or 3) for player X:");
            cols = in.nextInt();
        }
        this.board[rows-1][cols-1] = 'X';
        printBoard(board);
        
        //check if there is a winner
        symbol = findWinner();
        if (symbol == 'X') {
            System.out.println("Player X Won!");
            return 1;
        }else if (symbol == 'O') {
            System.out.println("Player O wins!");
            return 2;
        }else {
            return 0;
        }
        
    }// end setBoard
    
    //this method will print out the board to the players
    public void printBoard(char[][] b) {
        //note to self: fix the board so that printf will make the board shown
        //in the assignment
        System.out.println("-------------");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("| ");
                if(board[r][c] == 0)
                    System.out.printf("%-2c", ' ');
                else
                    System.out.printf("%-2c", board[r][c]);
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
    
    //This method will clear the board for a new game
    public void clearBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = 0;
            }
        }
    }
    
    //This method will find out who won at any point
    //When no condition passes, we want nothing to happen and the game will
    //continue. A throw-away value we return will trigger this.
    public char findWinner() {
        //check diagonally - topleft to bottomright
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2] 
                && board[0][0]!=' ') {
            return board[0][0];
        }
        //check diagonally - bottomleft to topright
        if (board[0][2]==board[1][1] && board[1][1]==board[2][0] 
                && board[0][2]!=' ') {
            return board[0][2];
        }
        
        //check horizontally
        for (int r = 0; r < 3; r++) {
            if (board[r][0]==board[r][1] && board[r][1]==board[r][2]) {
                return board[r][0];
            }
        }
        
        //check vertically
        for (int c = 0; c < 3; c++) {
            if (board[0][c]==board[1][c] && board[1][c]==board[2][c]) {
                return board[0][c];
            }
        }
        
        return 'T';
    }
    

} //end TTT class

public class BisharaSaidLab4 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice, winVal, xWins = 0, oWins = 0, ties = 0;
        TTT b = new TTT();
        
        b.printBoard(b.board);
        winVal = b.setBoard();
        if (winVal == 1) {
            xWins++;
        }else if (winVal == 2) {
            oWins++;
        }else {
            ties++;
        }
            
        do {
            System.out.println("Play again?\n1. Yes\n2. No");
            System.out.println("Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    b.clearBoard();
                    b.printBoard(b.board);
                    winVal = b.setBoard();
                    if (winVal == 1) {
                        xWins++;
                    }else if (winVal == 2) {
                        oWins++;
                    }else {
                        ties++;
                    }
                    break;
                case 2:
                    System.out.println("Player X won "+xWins+" times.\n"
                            + "Player O won "+oWins+" times.\n"
                            + "There were "+ties+" ties.\n");
                    System.out.println("The game is now over."
                            + "Thanks for playing!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        } while (choice != 2);

    } //end main

} //end main class
