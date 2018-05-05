package com.semakula;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class SurahAPI implements ISurah {
    private static JSONArray jsonArray;
    private static Map<String, String> surahs;

    public static void main(String[] args){
        loadJSON("/home/dinopc/Desktop/GitRepos/Quran-Diary/input/surah.json");
        setSurahs();
        System.out.println(getSurahList().get("Al - Jinn"));
    }

    //loadJSON("/home/dinopc/Desktop/GitRepos/Quran-Diary/input/surah.json")
    private static void loadJSON(String file){
        JSONParser parser = new JSONParser();
        try{
            Object object = parser.parse(new FileReader(file));

            //convert array to json array
            jsonArray = (JSONArray)object;

            /*Loop through json array*/
            for(int i = 0; i<jsonArray.size(); i++){
                Object current_obj = jsonArray.get(i);
                JSONObject title = (JSONObject) current_obj;
            }

        }catch(FileNotFoundException fe){
            fe.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void setSurahs(){
        surahs = new HashMap<String, String>();
        for(int i = 0; i<jsonArray.size(); i++){
            Object current_obj = jsonArray.get(i);
            JSONObject json_obj = (JSONObject) current_obj;
            Object surah_title = json_obj.get("title");
            Object surah_index = json_obj.get("index");

            surahs.put((String)surah_index, (String)surah_title);
        }

    }

    public static Map<String, String> getSurahList(){
        return surahs;
    }

    @Override
    public String getSurahTitle() {
        for(int i = 0; i<jsonArray.size(); i++){

        }
        return null;
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public int getPages() {
        return 0;
    }
}
