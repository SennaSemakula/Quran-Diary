package com.semakula;

import java.util.Scanner;

public class DeadlineManager {

    private SurahList diary1;
    Scanner scanner;

    public DeadlineManager(SurahList surah_list){
        diary1 = surah_list;
    }

    private void printTargetInstructions(){
        System.out.println("Select an option from the list below");

        System.out.println("0- Set days \t" +
                "1 - Set weeks \t" +
                "2 - Set months \t" +
                "3 - Set Years");
    }

    public void setMilestone(){
        //find the surah title that the user selected
        //return the title from the array
        scanner = new Scanner(System.in);
        printTargetInstructions();

        String choice = scanner.next();

        switch(Integer.parseInt(choice)){

            case 0:
                System.out.println("Enter number of days you want to set as a target");
                int result = scanner.nextInt();

                System.out.println("Deadline: " + diary1.getCurrentDate().plusDays(result));

                scanner.nextLine();
                break;
            case 1:
                System.out.println("Enter number of weeks you would like to set as a target");
                result = scanner.nextInt();

                System.out.println("Deadline: " + diary1.getCurrentDate().plusWeeks(result));

                scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter number of months you would like to set as a target");
                result = scanner.nextInt();

                System.out.println("Deadline: " + diary1.getCurrentDate().plusMonths(result));

                scanner.nextLine();
                break;
            case 3:
                System.out.println("Enter number of years you would like to set as a target");
                result = scanner.nextInt();

                System.out.println("Deadline: " + diary1.getCurrentDate().plusYears(result));

                scanner.nextLine();
                break;
        }


    }
}
