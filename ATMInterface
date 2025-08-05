import java.util.*;
class BankAccount{
    private double balance;

    public BankAccount(double balance){
        this.balance=balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited Amount:"+amount);
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawn amount:"+amount);
        }else if(amount> balance){
            System.out.println("Insufficient balance");
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void checkbalance(){
        System.out.println("Your current balance is:"+balance);
    }
}
public class ATMInterface
{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BankAccount account=new BankAccount(1000);
        boolean running=true;

        while(running){
            System.out.println("\n 1.Check balance \n 2. Deposit \n 3. Withdraw \n 4. Exit");
            System.out.println("Choose option:");
            int option=sc.nextInt();

            switch(option){
                case 1 -> account.checkbalance();
                case 2 -> {
                    System.out.println("Enter deposit amount:");
                    double amount=sc.nextDouble();
                    account.deposit(amount);
                }
                case 3 ->{
                    System.out.println("Enter amount to be withdrawn:");
                    double amount=sc.nextDouble();
                    account.withdraw(amount);
                }
                case 4->{
                    System.out.println("Thank You. Good Bye ");
                    running=false;
                }
                default->System.out.println("Inavlid option");
                }
            }
         sc.close();
    }
}
