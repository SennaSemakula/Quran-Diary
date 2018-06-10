package com.semakula;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class SurahList {
    private String name;
    private ArrayList<Surah> checklist;
    private final int total_surahs = 114;

    public SurahList(String name) {
        this.name = name;
        checklist = new ArrayList<Surah>();
    }

    public boolean addSurah(String name, String content, int chapter_no){
        Surah surah = new Surah(name, content, chapter_no);
        //if findItem()
        if(!findItem(name) ){
            System.out.println("Adding Surah: " + name + " to Diary");
            checklist.add(surah);
            return true;
        }else{
            System.out.println("Surah: " + name + " already exists in your Diary. Unable to add");
            return false;
        }
    }

    public boolean removeSurah(String name){
        if(findItem(name)){
            //find index of given surah name
            int index = getSurahIndex(name);
            System.out.println("Removing surah: " + name + " from checklist");
            checklist.remove(index);
            return true;
        }else{
            System.out.println("Unable to remove Surah " + "'" + name + "'" + " as it does not exist in checklist");
            return false;
        }
    }
    /*chapter remains static*/
    public boolean updateSurah(String old_name, String name, String content, int chapter){
        //find index of old surah
        int old_surah_index = getSurahIndex(old_name);
        Surah old_surah = checklist.get(old_surah_index);

        //check if surah exists
        if(old_surah_index >= 0){
            System.out.println("Updating surah: " + old_surah.getName());
            old_surah.setName(name);
            old_surah.setContent(content);
            old_surah.setChapter(chapter);

            return true;
        }else{
            System.out.println("Unable to update Surah: " + "'" + old_surah.getName() + "'" +  " as it currently does not exist in your Diary");
            return false;
        }

    }

    public Date getDeadline(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date current_date = new Date();

        System.out.println(dateFormat.format(current_date));

        return current_date;
    }

    public LocalDate getCurrentDate(){
        LocalDate date = LocalDate.now();
        return date;
    }

    private int getSurahIndex(String name){

        for(int i = 0; i < checklist.size(); i++){
            String surah_name = checklist.get(i).getName();
            if(surah_name.equals(name)){
                return i;
            }else{
                return -1;
            }
        }

        return -1;
    }

    public boolean checkSurahExists(String name){
        if(getSurahIndex(name) >= 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean findItem(String name){
        for(Surah surah: checklist){
            if(surah.getName().equals(name)){
                return true;
            }
        }
        return false;
    }


    public String getSurah(){

        if(checklist.isEmpty()){
            System.out.println("You have not completed any Surahs!");
        }else{
            System.out.println("=========List of Completed Surahs===========");
            for(Surah surah: checklist){
                System.out.println(surah);
                System.out.println("===========================================");
            }
        }

        return "";
    }

    public String getProgress(){
        System.out.println(calculateProgress());
        DecimalFormat df = new DecimalFormat("#.##");
        String progress = df.format(calculateProgress());

        return progress + "%";
    }

    private int completedSurahs(){
        int count = 0;

        for(Surah surah: checklist){
            count++;
        }

        return count;
    }

    public int getSurahPosition(String surah_name){
        int index = 0;

        for(int i = 0; i<=checklist.size(); i++){
            if(surah_name == checklist.get(i).getName()){
                index = i;
                return index;
            }
        }

        return -1;

    }

    public String getRemainingChapters(){
        return Integer.toString(calculateRemainingChapters());
    }

    private int calculateRemainingChapters(){
        int count = 0;
        int surahs_left;

        if(completedSurahs() == 0){
            surahs_left = total_surahs;
        }else{
            surahs_left = (total_surahs - completedSurahs());
        }

        return surahs_left;
    }

    private float calculateProgress(){
        float count = 0f;
        float percentage;

        for(Surah surah: checklist){
            count++;
        }

        percentage = (count / total_surahs) * 100;

        return percentage;

    }

    @Override
    public String toString() {
        System.out.println("Surah Diary: " + this.name);
        for(Surah surah : checklist) {
            String chapter_no = String.valueOf(surah.getChapter());
            String test = "" + surah.getChapter();
            System.out.println(
                    "\t" + "Name: " + surah.getName() + "\n" +
                            "\t" + "Content " + surah.getContent() + "\n" +
                            "\t" + "Chapter " + "" + surah.getChapter() + "\n" +
                            "\t" + "===========================");

        }

       return "End of list";

    }

    public ArrayList<Surah> getChecklist() {
        return checklist;
    }
}
