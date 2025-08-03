import java.util.*;
public class NumberGuessingGame{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
Random random=new Random();
int score=0;
boolean playAgain=true;

while(playAgain){
System.out.println("Welcome to the Number Guessing Game!");

int numberToGuess=random.nextInt(100)+1;
int attempts=5;
boolean guessedCorrect=false;

System.out.println("I have generated a number between 1 to 100 and you need to guess it");
System.out.println("You have"+attempts+"to guess it");

for(int i=0;i<=attempts;i++){
System.out.println("Attempt"+i);
System.out.println("Enter the number:");
int guessedNum=sc.nextInt();

if(guessedNum==numberToGuess){
    System.out.println("You guessed Correctly. The number is "+guessedNum);
}else if(guessedNum>numberToGuess){
    System.out.println("Your Guess is too high");
}else{
    System.out.println("Your Guess is too low");
}
}

if(!guessedCorrect){
    System.out.println("You ran out of attempts");
}

System.out.println("Do you want to play again ?");
String response=sc.next().toLowerCase();
playAgain=response.equals("yes");
}

System.out.println("Game Over");
System.out.println("Your Score is:"+score);
sc.close();
}
}
