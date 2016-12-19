package cardGame;

import java.util.*;

public class Blackjack {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		BlackjackGame game;
		int players;
		int decksInShoe;

		while (true) {
			welcome();
			char choice = input.next().toUpperCase().charAt(0);
			if (choice == '1') {
				game = new BlackjackGame();
				game.newGame();
			} else if (choice == '2') {
				System.out.print("\n    Enter number of players (2 - 4) : ");
				players = input.nextInt();
				while (players < 2 || players > 5) {
					System.err.print("\n    Bad input. Please enter a number\nbetween 2 and 5 : ");
					players = input.nextInt();
				}
				System.out.print("    Enter number of decks in shoe (2, 4, 6, or 8 : ");
				decksInShoe = input.nextInt();
				while (decksInShoe != 2 && decksInShoe != 4 && decksInShoe != 6 && decksInShoe != 8) {
					System.err.print("    Bad input. Please enter 2, 4, 6 or 8 : ");
					decksInShoe = input.nextInt();
				}
				game = new BlackjackGame(players, decksInShoe);
				game.newMultiplayerGame();
			} else if (choice == 'Q') {
				break;
			} else {
				System.err.println("Bad input, please choose a listed option.");
			}
		}
	}

	public static void welcome() {
		System.out.println("    * * * *   Blackjack   * * * *    ");
		System.out.println();
		System.out.println("                Menu: ");
		System.out.println("-------------------------------------");
		System.out.println("  [1]: Start New 1 Player Game");
		System.out.println("  [2]: Start New Multi Player Game");
		System.out.println("  [Q]: Quit");
		System.out.print("\n  >>> : ");
	}
}
