package cardGame;

import java.util.*;

public class Blackjack {
	static Deck deck;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			welcome();
			String choice = input.next().toUpperCase();
			if (choice.equals("1")) {
				newSinglePlayerGame();
			} else if (choice.equals("Q")) {
				break;
			} else {
				System.err.println("Bad input, please choose a listed option.");
			}
		}
	}

	public static void welcome() {
		System.out.println("   * * * *   Blackjack   * * * *   ");
		System.out.println();
		System.out.println("              Menu: ");
		System.out.println("-----------------------------------");
		System.out.println("	[1]: Start New Game");
		System.out.println("	[Q]: Quit");
	}

	public static void newSinglePlayerGame() {
		deck = new Deck();

		System.out.print("Enter Player Name: ");
		CardPlayer player = new CardPlayer(input.next());
		CardPlayer dealer = new CardPlayer("Dealer");
		String hitOrStay = "S";
		String again = "Y";
		String cont;

		deck.shuffleDeck();

		while (again.equals("Y")) {
			boolean blackjack = false;
			player.addToHand(deck.dealCard());
			player.addToHand(deck.dealCard());
			dealer.addToHand(deck.dealCard());
			dealer.addToHand(deck.dealCard());

			System.out.println("\nThe Deal:\n");
			System.out.println("\t" + player.name() + "\t\t" + dealer.name());
			System.out.println("------------------|-------------------");
			System.out.println(player.showCard(1) + "       " + dealer.showCard(1));
			System.out.println(player.showCard(2) + "            ?");
			System.out.println("--------------------------------------");
			System.out.println("\t" + player.getHandValue() + "\t\t" + dealer.upCardValue() + "+?");
			if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
				System.out.println("\n\t\tBLACKJACK!!!\n\n");
				blackjack = true;
			} else if (dealer.getHandValue() == 21) {
				System.out.println("\n   Dealer Blackjack, Dealer wins.\n\n");
			} else {
				hitOrStay.equals("H");
			}

			while (player.getHandValue() < 21) {
				System.out.print("\n    [H]it or [S]tay? >>> ");
				hitOrStay = input.next().toUpperCase();
				if (hitOrStay.equals("S")) {
					break;
				} else if (hitOrStay.equals("H")) {
					player.addToHand(deck.dealCard());
					System.out.println("\n" + player.showCard());
					System.out.println("New total : " + player.getHandValue());
					if (player.getHandValue() > 21) {
						System.out.println("\n\tBust!! You lose.\n");
						break;
					} else if (player.getHandValue() == 21) {
						System.out.println("\t21!!!");
						break;
					}
				} else {
					System.out.println("Bad input, please enter \"H\" or \"S\"");
				}
			}
			if (!blackjack && player.getHandValue() <= 21) {
				System.out.println("\n    Dealer Cards : ");
				System.out.println(dealer.showCard(1) + "     " + dealer.showCard(2));
				System.out.println("    Dealer total : " + dealer.getHandValue());
				while (dealer.getHandValue() < 17) {
					dealer.addToHand(deck.dealCard());
					System.out.println("\n" + dealer.showCard());
					System.out.println("New total : " + dealer.getHandValue());
					if (dealer.getHandValue() > 21) {
						System.out.println("\n\tDealer Bust!! You Win!\n");
						break;
					} else if (dealer.getHandValue() == 21) {
						System.out.println("\n\tDealer 21!!");
						break;
					}
				}
			}
			if (dealer.getHandValue() <= 21 && player.getHandValue() <= 21) {
				if (player.getHandValue() > dealer.getHandValue()) {
					System.out.println("\n\tYou Win the Hand!!\n");
				} else if (player.getHandValue() < dealer.getHandValue()) {
					System.out.println("\n\tDealer Wins the Hand.\n");
				} else {
					System.out.println("\n\t\tPush\n");
				}
			}

			player.resetHand();
			dealer.resetHand();
			if (deck.cardsRemaining() < 26) {
				cont = "";
				System.out.print("\n\n50% of Deck Used. Would you like to re-shuffle and continue? (Y/N) : ");
				while (!(cont.equals("Y") || cont.equals("N"))) {
					cont = input.next().toUpperCase();
					if (cont.equals("Y")) {
						deck = new Deck();
						deck.shuffleDeck();
					} else if (cont.equals("N")) {
						break;
					} else {
						System.out.print("Bad input. Please enter \"Y\" or \"N\" : ");
					}
				}
			}

			System.out.print("Would You Like to Play Another Hand? (Y/N): ");
			again = input.next().toUpperCase();
			while (!(again.equals("Y") || again.equals("N"))) {
				System.out.print("Bad input. Please enter \"Y\" or \"N\" : ");
				again = input.next();
			}
		}
	}
}
