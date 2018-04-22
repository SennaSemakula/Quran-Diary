package com.semakula;

import java.lang.reflect.Type;

public class Surah {
    private String name;
    private String content;
    private int chapter;

    public Surah(String name, String content, int chapter) {
        this.name = name;
        this.content = content;

        if(chapter > 0 && chapter <= 114){
            this.chapter = chapter;
        }else{
            System.out.println("Unable to create surah notes\n");
            System.out.println("Invalid surah no." + " Please insert a range from surah 1-114");
            System.exit(-1);
        }
    }


    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getChapter(){
        return chapter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChapter(int chapter_no){
        if(chapter_no > 0 && chapter_no <= 114){
            this.chapter = chapter_no;
        }else{
            System.out.println("Invalid surah no." + "Please insert a range from surah 1-114");
        }

    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "Name of Surah: " + this.name + "\n" +
                "Chapter: " + this.content + "\n" +
                "Content: " + this.chapter;
    }
}
