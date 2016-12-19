package cardGame;

import java.util.Scanner;

public class BlackjackGame {
	private int decksInShoe;
	private int players;
	
	public BlackjackGame() {
		players = 1;
		decksInShoe = 1;
	}
	
	public BlackjackGame(int players, int decksInShoe) {
		this.players = players;
		this.decksInShoe = decksInShoe;
	}
	
	public void newGame() {
		Deck deck;
		Scanner input = new Scanner(System.in);

		deck = new Deck(decksInShoe);

		System.out.print("     Enter Player Name: ");
		CardPlayer player = new CardPlayer(input.next());
		
		CardPlayer dealer = new CardPlayer("Dealer");
		char hitOrStay;
		char again = 'Y';
		char cont;

		deck.shuffleDeck();

		while (again == 'Y') {
			boolean blackjack = false;
			int bet;
			
			System.out.println("\n        Current Wallet : $" + player.getWallet());
			System.out.print("     Please place a bet to play\n     ($5 min - $50 max) : ");
			bet = input.nextInt();
			while (bet <5 || bet >50){
				System.err.print("\nBad input. Please enter a\npositive value between 5 and 50 : ");
				bet = input.nextInt();
			}
			
			player.addToHand(deck.dealCard());
			dealer.addToHand(deck.dealCard());
			player.addToHand(deck.dealCard());
			dealer.addToHand(deck.dealCard());

			System.out.println("\nThe Deal:\n");
			System.out.println("\t" + player.name() + "\t\t" + dealer.name());
			System.out.println("------------------|-------------------");
			System.out.println(player.showCard(1) + "     " + dealer.showCard(1));
			System.out.println(player.showCard(2) + "          ?");
			System.out.println("--------------------------------------");
			System.out.println("\t" + player.getHandValue() + "\t\t" + dealer.upCardValue() + "+?");
			if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
				System.out.println("\n\t   BLACKJACK!!!\n\n");
				blackjack = true;
			} else if (dealer.getHandValue() == 21) {
				System.out.println("\n   Dealer Blackjack.\n\n");
				player.updateWallet(-1*bet);
			}
			
			while (player.getHandValue() < 21 && dealer.getHandValue() != 21) {
				System.out.print("\n    [H]it or [S]tay? >>> ");
				hitOrStay = input.next().toUpperCase().charAt(0);
				if (hitOrStay == 'S') {
					break;
				} else if (hitOrStay == 'H') {
					player.addToHand(deck.dealCard());
					if (player.getHandValue() > 21) {
						if (player.hasAce()) {
							player.aceToOne();
						}
					}
					System.out.println("\n" + player.showCard());
					System.out.println("New total : " + player.getHandValue());
					if (player.getHandValue() > 21) {
						System.out.println("\n\tBust!! You lose.\n");
						player.updateWallet(-1*bet);
					}
				} else if (player.getHandValue() == 21) {
					System.out.println("\n\t21!!!");
					break;
				} else {
					System.err.println("Bad input, please enter \"H\" or \"S\"");
				}
			}
			if (!blackjack && player.getHandValue() <= 21) {
				System.out.println("\n    Dealer Cards : ");
				System.out.println(dealer.showCard(1) + "     " + dealer.showCard(2));
				System.out.println("    Dealer total : " + dealer.getHandValue());
				while (dealer.getHandValue() < 17) {
					dealer.addToHand(deck.dealCard());
					if (dealer.getHandValue() > 21) {
						if (dealer.hasAce()) {
							dealer.aceToOne();
						}
					}
					System.out.println("\n" + dealer.showCard());
					System.out.println("New total : " + dealer.getHandValue());
					if (dealer.getHandValue() > 21) {
						System.out.println("\n\tDealer Bust!! You Win!\n");
						player.updateWallet(bet);
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
					player.updateWallet(bet);
				} else if (player.getHandValue() < dealer.getHandValue()) {
					System.out.println("\n\tDealer Wins the Hand.\n");
					player.updateWallet(-1*bet);
				} else {
					System.out.println("\n\t\tPush\n");
				}
			}

			player.resetHand();
			dealer.resetHand();
			if (deck.deckValueRemaining() < 42) {
				System.err.println("\n\t\tToo few cards for a full round.\n\t\tDeck Shuffled.");
				deck = new Deck(decksInShoe);
			}
			if (decksInShoe == 1 && deck.cardsRemaining() < 26) {
				cont = ' ';
				System.err.print("\n\n50% or more of shoe Used.\nWould you like to re-shuffle? (Y/N) : ");
				while (!(cont == 'Y' || cont == 'N')) {
					cont = input.next().toUpperCase().charAt(0);
					if (cont == 'Y') {
						deck = new Deck(decksInShoe);
						deck.shuffleDeck();
					} else if (cont == 'N') {
						break;
					} else {
						System.out.print("\nBad input. Please enter \"Y\" or \"N\" : ");
					}
				}
			}

			System.out.print("\nWould You Like to Play Another Hand? (Y/N): ");
			again = input.next().toUpperCase().charAt(0);
			while (!(again == 'Y' || again == 'N')) {
				System.out.print("Bad input. Please enter \"Y\" or \"N\" : ");
				again = input.next().toUpperCase().charAt(0);
			}
		}
		input.close();
	}
}
