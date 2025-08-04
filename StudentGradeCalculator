import java.util.*;
public class StudentGradeCalculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Student Grade Calculator");

        System.out.println("Enter the number of subjects:");
        int noOfSub=sc.nextInt();
        int total=0;

        int[] marks=new int[noOfSub];
        for(int i=0;i<noOfSub;i++){
             System.out.println("Enter your mark for subject"+ (i+1));
             marks[i]=sc.nextInt();     

             while(marks[i]<0 || marks[i]>100){
                System.out.println("Invalid Input");
                System.out.println("Enter again:");
                marks[i]=sc.nextInt();
             }
             total+=marks[i];     
        }

        double average=(double) total/noOfSub;
        String grade;

        if(average>=90 ){
            grade="A+";
        }else if(average>=80){
            grade="A";
        }else if(average>=70){
            grade="B+";
        }else if(average>=60){
            grade="B";
        }else if(average>=50){
            grade="c";
        }else if(average>=40){
            grade="d";
        }else{
            grade="Fail";
        }

        System.out.println("Result Summary:");
        System.out.println("Total Marks: "+total);
        System.out.printf("Average Percentage: %.2f%%\n",average);
        System.out.println("Grade: "+grade);
        sc.close();
    }
}
