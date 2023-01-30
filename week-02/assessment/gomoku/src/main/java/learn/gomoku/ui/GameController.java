package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;


import java.util.Random;
import java.util.Scanner;

import static learn.gomoku.game.Gomoku.WIDTH;


public class GameController {

    final Random random = new Random();
    final Player[] players = new Player[2];


    private final Scanner console = new Scanner(System.in);
    public void run() {

        System.out.println("Welcome to the Gomoku" + "\n" + "========================");
        System.out.println("Player 1 is: " + "\n " + "1. Human" + "\n " + "2. Random Player");
        System.out.println("Select [1-2]: ");
        int p1 = Integer.parseInt(console.nextLine());
        String choice1 = "", choice2 = "";
        if (p1 == 1) {
            System.out.println("Player 1, enter your name: ");
            choice1 = console.nextLine();

        } else if (p1 == 2) {
            Player rand1 = new RandomPlayer();
            choice1 = rand1.getName();
            System.out.println(choice1);
        } else {
            System.out.println("Error. Please select 1 or 2.");
        }

        System.out.println("Player 2 is: " + "\n " + "1. Human" + "\n " + "2. Random Player");
        System.out.println("Select [1-2]: ");
        int p2 = Integer.parseInt(console.nextLine());

        if (p2 == 1) {
            System.out.println("Player 2, enter your name: ");
            choice2 = console.nextLine();

        } else if (p2 == 2) {
            Player rand2 = new RandomPlayer();
            choice2 = rand2.getName();
            System.out.println(choice2);

        }

        Player playerOne = new HumanPlayer(choice1);
        Player playerTwo = new HumanPlayer(choice2);


        Gomoku game = new Gomoku(playerOne, playerTwo);


        // TODO prompt the user for the player type;
        System.out.println("\n(Randomizing)");
        int randInt = random.nextInt(2);
        if (randInt == 0) {
            players[0] = playerOne;
            players[1] = playerTwo;
        } else {
            players[0] = playerTwo;
            players[1] = playerOne;
        }


        do {


            System.out.println(players[0].getName() + " goes first");

            System.out.println("\n" + players[0].getName() + "'s turn.");
            System.out.printf("\n" + "Enter a row #: ");
            int row = Integer.parseInt(console.nextLine()) - 1;
            System.out.printf("Enter a column #: ");
            int column = Integer.parseInt(console.nextLine()) - 1;

            displayBoard();


            Stone stone = new Stone(row, column, game.isBlacksTurn());

            Result result = game.place(stone);
            if (result.isSuccess()) {
                System.out.println("Error" + result.getMessage());
            }

        } while (!game.isOver());

        System.out.println("Game is over? " + game.isOver());
        System.out.println("The winner is " + game.getWinner().getName());





        // Get a reference to the first player (i.e. the black player).
        Player black = game.getCurrent();

        // Black player's first move.
        Result result = game.place(new Stone(0, 0, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        //  assertNull(result.getMessage());

        // White player's first move.
        result = game.place(new Stone(1, 0, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        // assertNull(result.getMessage());

        // Black player's second move.
        result = game.place(new Stone(0, 1, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        //assertNull(result.getMessage());

        // White player's second move.
        result = game.place(new Stone(1, 1, game.isBlacksTurn()));
        // assertTrue(result.isSuccess());
        // assertNull(result.getMessage());

        // Black player's third move.
        result = game.place(new Stone(0, 2, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        //assertNull(result.getMessage());

        // White player's third move.
        result = game.place(new Stone(1, 2, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        //assertNull(result.getMessage());

        // Black player's fourth move.
        result = game.place(new Stone(0, 3, game.isBlacksTurn()));
        // assertTrue(result.isSuccess());
        // assertNull(result.getMessage());

        // White player's fourth move.
        result = game.place(new Stone(1, 3, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        //assertNull(result.getMessage());

        // Black player's fifth move... the winning move of the game.
        // Not only should the result be successful, but it should contain the expected "winning" message.
        result = game.place(new Stone(0, 4, game.isBlacksTurn()));
        //assertTrue(result.isSuccess());
        // assertEquals(String.format("%s wins.", black.getName()), result.getMessage());

        // Check that the game is in fact over and that the winner was the black player.
        //assertTrue(game.isOver());
        // assertEquals(black, game.getWinner());
    }

    private void displayBoard() {
        char[][] board = new char[WIDTH][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}

