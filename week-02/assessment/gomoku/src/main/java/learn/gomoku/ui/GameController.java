package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.List;
import java.util.Scanner;

public class GameController {

    private final Scanner console = new Scanner(System.in);
    Gomoku game;
    char[][] board = new char[15][15];

    public void run() {
        //to be called from the main App
        System.out.println("Welcome to Gomoku!");
        System.out.println("===================");

        setup();
        play();
        if(playAgain()){
            run();
        }

    }

    private void setup(){
        Player playerOne, playerTwo;
        // ASK FOR human or random
        playerOne = getPlayer(1);
        playerTwo = getPlayer(2);

        System.out.println("(Randomizing)");
        game = new Gomoku(playerOne, playerTwo);

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                board[x][y] = '-';
            }
        }
        System.out.println(game.getCurrent().getName() + " goes first.");
    }

    private Player getPlayer(int playerNumber){
        Player human, random;
        int choice;
        String name;
        System.out.println("Player " + playerNumber + " is:\n1. Human\n2. Random Player\nSelect [1-2]:");
        choice = readInt("Error, please enter 1 or 2.", 1, 2);
        if(choice == 1){
            System.out.println("Player " + playerNumber + ", enter your name:");
            name = readRequiredString("Error: Invalid Input. Please enter a name. (No Whitespace)");
            human = new HumanPlayer(name);
            return human;
        }else{
            random = new RandomPlayer();
            return random;
        }
    }

    private void play(){
        int row, column;
        Stone stone;
        Result result;

        do {

            System.out.println("\n" + game.getCurrent().getName() + "'s Turn");
            stone = game.getCurrent().generateMove(game.getStones());


            if (stone == null) {
                System.out.println("Enter a row:");
                row = readInt("Out of Bounds. Please enter an integer from 1 to 15", 1, 15) - 1;
                System.out.println("Enter a column:");
                column = readInt("Out of Bounds. Please enter an integer from 1 to 15", 1, 15) - 1;

                stone = new Stone(row, column, game.isBlacksTurn());
            }

            result = game.place(stone);
            if(!result.isSuccess()){
                System.out.println(result.getMessage());
                continue;
            }

            printBoard();
        }while (!game.isOver()) ;

        if(result.getMessage() != null){
            System.out.println(result.getMessage());
        }
    }

    private void printBoard(){

        System.out.print("  ");
        List<Stone> list = game.getStones();

        if(!game.isBlacksTurn()) {
            board[(list.get(list.size() - 1).getRow())][(list.get(list.size() - 1).getColumn())] = 'X';
            if(game.isOver()){
                board[(list.get(list.size() - 1).getRow())][(list.get(list.size() - 1).getColumn())] = 'O';
            }
        }else{
            board[(list.get(list.size() - 1).getRow())][(list.get(list.size() - 1).getColumn())] = 'O';
            if(game.isOver()){
                board[(list.get(list.size() - 1).getRow())][(list.get(list.size() - 1).getColumn())] = 'X';
            }
        }
        for(int x = 1; x <= board.length; x++) {
            if (x < 10) {
                System.out.print("0" + x + " ");
            }else{
                System.out.print(x + " ");
            }
        }
        System.out.println();

        for(int x = 0; x < board.length; x++){
            if(x < 9) {
                System.out.print("0" + (x + 1));
            }else{
                System.out.print(x+1);
            }
            for(int y = 0; y < board[x].length; y++){
                System.out.print(" " + board[x][y] + " ");
            }
            System.out.println();
        }
    }


    private String readRequiredString(String message){
        String input;
        input = console.nextLine();
        boolean isWhitespace = false;

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                isWhitespace = true;
            }
        }

        while(isWhitespace || input.equals("") || input == null) {
            if (isWhitespace || input.equals("") || input == null) {
                System.out.println(message);
                input = console.nextLine();
            }
        }

        return input;
    }


    private int readInt(String message, int min, int max){
        String stringInput;
        int intInput = -1;
        boolean isNumber;
        while(true) {
            stringInput = readRequiredString("Error: Invalid Input. Try again.");
            try {
                intInput = Integer.parseInt(stringInput);
            } catch (NumberFormatException nfe) {
                System.out.println(message);
            }

            if (!(intInput >= min && intInput <= max)) {
                System.out.println(message);
            } else {
                return intInput;
            }
        }
    }


    private boolean playAgain(){
        String response;
        System.out.print("Play Again?[y/n]: ");
        response = readRequiredString("Please enter \"y\" or \"n\".");
        if(response.equalsIgnoreCase("y")){
            return true;
        }else{
            return false;
        }
    }


}