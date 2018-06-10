package com.semakula;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    /*Only one instance of a class should be called in main
    *  Identify and implement alternative methods to call DeadlineManager class*/
    public static Scanner scanner = new Scanner(System.in);
    public static SurahList diary1;
    static DeadlineManager deadlineManager;

    public static void main(String[] args) {
	// write your code here
        diary1 = new SurahList("Senna's Deen Diary");

        Deadline time = new Deadline();
        LocalDate new_date = LocalDate.now();
        time.setDays(12);
        System.out.println(time.returnDeadline());

        defaultOptions();

    }

    public static void defaultOptions(){
        boolean quit = false;
        int choice = 0;

        printMenu();

        while(!quit){
            choice = scanner.nextInt();
            if(choice < 0 || choice > 7){
                System.out.println(choice + " is not a valid option. Please insert one of the options from the following: ");
                printMenu();
            }

            switch(choice){
                case 0:
                    printMenu();
                    break;
                case 1:
                    System.out.println("Enter Surah Name: ");
                    String name = scanner.next();
                    scanner.nextLine();

                    System.out.println("Enter Surah Contents: ");
                    String contents = scanner.next();
                    scanner.nextLine();

                    System.out.println("Enter Surah Chapter: ");
                    int chapter = scanner.nextInt();
                    scanner.nextLine();

                    addSurah(name, contents, chapter);
                    printMenu();
                    break;
                case 2:
                    if(diary1.getChecklist().isEmpty()){
                        System.out.println("No Surahs to update!");
                    }else{
                        System.out.println("Enter Surah name to update: ");
                        String old_surah_name = scanner.next();
                        scanner.nextLine();

                        if(diary1.checkSurahExists(old_surah_name)){
                            //Prompt user to enter new surah name
                            System.out.println("Enter new Surah name");
                            String new_surah_name = scanner.next();
                            scanner.nextLine();

                            //Prompt user to enter the new chapter number
                            System.out.println("Enter contents of Surah");
                            String surah_contents = scanner.next();
                            scanner.nextLine();

                            //Prompt user to enter the new surah contents
                            System.out.println("Enter chapter no. ");
                            int chapter_no = scanner.nextInt();
                            scanner.nextLine();

                            updateSurah(old_surah_name, new_surah_name, surah_contents, chapter_no);


                        }else{
                            System.out.println("Surah does not exist! Please enter a valid Surah to update");
                        }

                    }

                    printMenu();
                    break;
                case 3:
                    //check if surah is empty
                    if(diary1.getChecklist().isEmpty()){
                        System.out.println("No Surahs to remove!");
                    }else{
                        System.out.println("Enter Surah name to remove: ");
                        String name_removal = scanner.next();
                        removeSurah(name_removal);
                        scanner.nextLine();
                    }
                    printMenu();
                    break;
                case 4:
                    diary1.getSurah();
                    printMenu();
                    break;
                case 5:
                    //move following code to another method

                    //select surah
                    if(diary1.getChecklist().isEmpty()){
                        System.out.println("Please insert surahs into diary first.");
                        printMenu();
                    }else{
                        System.out.println("Select surah from below\n");
                        int index = 0;

                        for(int i = 0; i<diary1.getChecklist().size(); i++){
                            index = i;
                            String surah_name = diary1.getChecklist().get(i).getName();
                            System.out.println("\t" + index + "- " + surah_name);
                        }
                        String surah_choice = scanner.next();

                        deadlineManager = new DeadlineManager(diary1);
                        deadlineManager.setMilestone();

                        printMenu();
                    }

                    break;
                case 6:
                    System.out.println("You have completed " + diary1.getProgress() + " of the Quran" +
                                        "\n" + diary1.getRemainingChapters() + " Surahs left to complete");
                    printMenu();
                    break;
                case 7:
                    System.out.println("Exiting diary. Have a good day Insha'Allah");
                    quit = true;
                    break;
            }
        }

    }

    private static void updateSurah(String old_name, String new_name, String contents, int chapter){
        diary1.updateSurah(old_name, new_name, contents, chapter);
    }

    private static void addSurah(String name, String contents, int chapter){
        if(chapter > 114){
            System.out.println("Unable to create surah notes\n");
            System.out.println("Invalid surah chapter no." + " Please insert a range from surah 1-114");
        }else{
            diary1.addSurah(name, contents, chapter);
        }
    }

    private static void removeSurah(String name){
        diary1.removeSurah(name);
    }


    public static void printMenu(){
        System.out.println("\nEnter a option from the following menu: ");

        System.out.println("\t 0 - View options" + "\t" +
                            "1 - Add Surah" + "\t " +
                            "2 - Update Surah" + "\t" +
                            "3 - Remove Surah" + "\t" +
                            "4 - View completed Surahs" + "\n" +
                            "\t 5 - Set milestones" + "\t" +
                            "6 - View progress" + "\t " +
                            "7 - Quit Application");
    }
}