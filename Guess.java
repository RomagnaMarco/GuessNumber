import java.util.Scanner;
import java.util.Random;

public class Guess {
	
	static Scanner scanner;
	static int numRange = 10; //Range of numbers
	static int lives = 3;
	public static String intro = "The game is now starting, Once you lose all your lives, its game over.\nGuess the random number to win the game.";
	public static Boolean again = true;
	public static int wNum = 0;
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		
		while (again == true)
		{
			setDefaults();
			print("Welcome to Guess that Number!");
			print("Please select a Difficulty level to start.");
			int sLives = determineA();
			Boolean results = runGame();
			endResults(sLives, results);
		}
		scanner.close();
		print("Thanks for Playing Guess that Number!");
	}
	
	/**
	 * Resets defaults for if the player plays the game again
	 */
	public static void setDefaults()
	{
		numRange = 10;
		lives = 3;
		intro = "The game is now starting, Once you lose all your lives, its game over.\nGuess the random number to win the game.";
		wNum = 0;
	}
	
	/**
	 * sets up Game
	 * checks input. re-prompts if option not selected.
	 * @return how many starting lives there are
	 */
	public static int determineA()
	{
		Boolean loop = true; //only when false will break loop.
		String modeS =  " Difficulty Selected. Good luck and have fun!";
		
		//open scanner to difficulty
		
		print("Please select a number from: ");
		print("Easy = 0\nMedium = 1\nHard = 2\nExtreme = 3\nImpossible = 4");
		while(loop == true)
		{
			int diffAns = scanner.nextInt();
			//switch statement to check answers
			switch (diffAns) {
				case 0:
					print("Easy" + modeS);
					lives += 2;
					loop = false;
					break;
				case 1:
					print("Medium" + modeS);
					numRange = 15;
					lives+= lives;
					intro += " ";
					loop = false;
					break;
				case 2:
					print("Hard" + modeS);
					numRange = 20;
					lives+= 1;
					intro += " ";
					loop = false;
					break;
				case 3:
					print("Extreme" + modeS);
					numRange = 25;
					lives+= 2;
					intro += " ";
					loop = false;
					break;
				case 4:
					print("Impossible" + modeS);
					numRange = 100;
					lives= 2;
					intro += " ";
					loop = false;
					break;
				default:
				print("Inavlid Input, please enter a number between 0 and 4 to choose a difficulty.");
			}
			//set introduction for when game starts
			intro += "\nFor this Difficulty, you have: "
					+"\n"+ lives + " lives and the range of guesses is 1 to " +numRange;
		}
		
		return lives;
		
	}
	
	/**
	 * Runs the game
	 * @return boolean for the status of win or lose. win = true.
	 */
	public static Boolean runGame()
	{
		Boolean win = false; //initialize false by default
		
		//generate winning number for the game
		int min = 1;
		Random rand = new Random();
		wNum = rand.nextInt(numRange-min+1) + min;
		
		//start game
		print(intro);
		
		while(lives >= 1) //assume lives will decrease to 0
		{
			
			if(lives > 1)
			{
				print("\nPlease enter a guess.");
			}
			else //when lives == 1
			{
				print("\nPlease enter your last guess. This is your last life, so good luck!");
			}
			
			int diffAns = scanner.nextInt();
			
			if(diffAns == wNum)
			{
				win = true;
				break;
			}
			
			print("Nope, the number wasn't "+ diffAns);
			lives--;
		
		}
		
		return win;
	}
	
	/**
	 * just prints end Results. Then allows game to be setup again if player chooses to play again.
	 * @param startingLives
	 * @param results
	 * @return 
	 */
	public static void endResults(int startingLives , Boolean results)
	{
		if(results == true) //win
		{
			print("Congrats! You guessed the number.\nYou had: "+ lives + " left.\nYou started with "+ startingLives);
			if(lives == startingLives)
				print("Incredible! you didn't lose a single life! You are lucky for sure!");
			else if(lives == 1)
			{
				print("Phew that was close, you beat it with 1 life left. Count yourself lucky you didn't lose there.");
			}
		}
		else //lose
		{
			print("\nWell, you tried, but sadly there are no lives left for this difficulty. Maybe you will be luckier next time.\nThe Number was: "+wNum+"." );
		}
		
		print("\n\n If you want to play again, press 1, otherwise enter any other number");
		int playAgain = scanner.nextInt();
		if(playAgain == 1)
		{
			again = true;
		}
		else
		{
			again = false;
		}
	}
	
	/**
	 * basic helper method for printing STRINGS only
	 * @param input
	 */
	public static void print(String input)
	{
		System.out.println(input);
	}
}

