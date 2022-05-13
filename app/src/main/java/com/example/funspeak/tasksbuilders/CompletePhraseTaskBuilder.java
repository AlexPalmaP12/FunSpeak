package com.example.funspeak.tasksbuilders;

import android.util.ArrayMap;

import com.example.funspeak.tasksmodels.CompletePhraseTaskModel;
import com.example.funspeak.views.tasks.CompletePhraseTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompletePhraseTaskBuilder {

    private final static ArrayMap<String, ArrayMap<Integer, String>> phraseslanguageMapping = new ArrayMap<>();
    private final static ArrayMap<String, ArrayMap<Integer, String>> answerslanguageMapping = new ArrayMap<>();
    private static ArrayMap<String, ArrayMap<String, String>> typeMapping = new ArrayMap<>();

    //Data necessary for mapping
    private final static String[] types = {
            "multiplication",
            "division",
            "addition2",
            "subtraction2",
            "multiplication3",
            "division3",
            "addition3",
            "subtraction3"
    };
    private static String[] multiplicationPhrases = {
            "5 x 1: ",
            "9 x 2: ",
            "2 x 4: ",
            "4 x 3: ",
            "8 x 4: ",
            "5 x 6: ",
            "6 x 9: ",
            "7 x 7: ",
            "10 x 1: ",
            "6 x 3: "
    };
    private static String[] multiplicationAnswers = {
            "5",
            "18",
            "8",
            "12",
            "32",
            "30",
            "54",
            "49",
            "10",
            "18"
    };
    private static String[] divisionPhrases = {
            "2 ÷ 1: ",
            "8 ÷ 2: ",
            "9 ÷ 3: ",
            "14 ÷ 2: ",
            "6 ÷ 2: ",
            "18 ÷ 3: ",
            "12 ÷ 4: ",
            "16 ÷ 4: ",
            "8 ÷ 4: ",
            "12 ÷ 6: "

    };
    private static String[] divisionAnswers = {
            "2",
            "4",
            "3",
            "7",
            "3",
            "6",
            "3",
            "4",
            "2",
            "2"
    };
    private static String[] addition2Phrases = {
            "156 + 36 + 2: ",
            "64 + 96: ",
            "256 + 128 + 64: ",
            "400 + 2 + 2: ",
            "60 + 6 + 3: ",
            "256 + 143: ",
            "489 + 64: ",
            "150 + 250: ",
            "89 + 32 + 15: ",
            "1000 + 250 + 250: "
    };
    private static String[] addition2Answers = {
            "194",
            "160",
            "448",
            "404",
            "69",
            "399",
            "553",
            "400",
            "136",
            "1500"
    };
    private static String[] subtraction2Phrases = {
            "156 - 36 - 2: ",
            "96 - 64: ",
            "256 - 128 - 64: ",
            "400 - 2 - 2: ",
            "60 - 6 - 3: ",
            "256 - 143: ",
            "489 - 64: ",
            "250 - 150: ",
            "89 - 32 - 15: ",
            "1000 - 250 - 250: "
    };
    private static String[] subtraction2Answers = {
            "118",
            "32",
            "64",
            "396",
            "51",
            "113",
            "425",
            "100",
            "42",
            "500"
    };

    //Elementary3

    private static String[] multiplication3Phrases = {
            "505 x 2: ",
            "96 x 20: ",
            "21 x 4: ",
            "48 x 3: ",
            "621 x 2: ",
            "57 x 17: ",
            "6 x 19: ",
            "73 x 2: ",
            "1234 x 1: ",
            "64 x 3: "
    };
    private static String[] multiplication3Answers = {
            "1010",
            "1920",
            "84",
            "144",
            "1242",
            "969",
            "114",
            "146",
            "1",
            "192"
    };
    private static String[] division3Phrases = {
            "505 ÷ 5: ",
            "129 ÷ 3: ",
            "848 ÷ 16: ",
            "1000 ÷ 200: ",
            "848 ÷ 424: ",
            "500 ÷ 250: ",
            "128 ÷ 32: ",
            "999 ÷ 3: ",
            "682 ÷ 31: ",
            "735 ÷ 35: "
    };
    private static String[] division3Answers = {
            "101",
            "43",
            "53",
            "5",
            "2",
            "2",
            "4",
            "333",
            "22",
            "21"
    };
    private static String[] addition3Phrases = {
            "505 + 5 + 878: ",
            "129 + 3 + 645: ",
            "848 + 16 + 137: ",
            "1000 + 200 + 798: ",
            "848 + 424 + 369: ",
            "500 + 250 + 425: ",
            "128 + 32 + 864: ",
            "999 + 3 + 327: ",
            "682 + 31 + 789: ",
            "735 + 35 + 645: "
    };
    private static String[] addition3Answers = {
            "1388",
            "777",
            "1001",
            "1998",
            "1641",
            "1175",
            "1024",
            "1329",
            "1502",
            "1415"
    };
    private static String[] subtraction3Phrases = {
            "878 - 505 - 5: ",
            "645 - 129 - 3: ",
            "848 - 137 - 16: ",
            "1000 - 798 - 200: ",
            "848 - 424 - 369: ",
            "800 - 425 - 250: ",
            "864 - 128 - 32: ",
            "999 - 327 - 3: ",
            "789 - 682 - 31: ",
            "735 - 645 - 35: "
    };
    private static String[] subtraction3Answers = {
            "368",
            "513",
            "695",
            "2",
            "55",
            "125",
            "704",
            "669",
            "76",
            "55"
    };
    //Data necessary for translation
    private static String[] englishPhrases = {
            "5 x 1: ",
            "9 x 2: ",
            "2 x 4: ",
            "4 x 3: ",
            "8 x 4: ",
            "5 x 6: ",
            "6 x 9: ",
            "7 x 7: ",
            "10 x 1: ",
            "6 x 3: ",
            "2 ÷ 1: ",
            "8 ÷ 2: ",
            "9 ÷ 3: ",
            "14 ÷ 2: ",
            "6 ÷ 2: ",
            "18 ÷ 3: ",
            "12 ÷ 4: ",
            "16 ÷ 4: ",
            "8 ÷ 4: ",
            "12 ÷ 6: ",
            "156 + 36 + 2: ",
            "64 + 96: ",
            "256 + 128 + 64: ",
            "400 + 2 + 2: ",
            "60 + 6 + 3: ",
            "256 + 143: ",
            "489 + 64: ",
            "150 + 250: ",
            "89 + 32 + 15: ",
            "1000 + 250 + 250: ",
            "156 - 36 - 2: ",
            "96 - 64: ",
            "256 - 128 - 64: ",
            "400 - 2 - 2: ",
            "60 - 6 - 3: ",
            "256 - 143: ",
            "489 - 64: ",
            "250 - 150: ",
            "89 - 32 - 15: ",
            "1000 - 250 - 250: ",
            "505 x 2: ",
            "96 x 20: ",
            "21 x 4: ",
            "48 x 3: ",
            "621 x 2: ",
            "57 x 17: ",
            "6 x 19: ",
            "73 x 2: ",
            "1234 x 1: ",
            "64 x 3: ",
            "505 ÷ 5: ",
            "129 ÷ 3: ",
            "848 ÷ 16: ",
            "1000 ÷ 200: ",
            "848 ÷ 424: ",
            "500 ÷ 250: ",
            "128 ÷ 32: ",
            "999 ÷ 3: ",
            "682 ÷ 31: ",
            "735 ÷ 35: ",
            "505 + 5 + 878: ",
            "129 + 3 + 645: ",
            "848 + 16 + 137: ",
            "1000 + 200 + 798: ",
            "848 + 424 + 369: ",
            "500 + 250 + 425: ",
            "128 + 32 + 864: ",
            "999 + 3 + 327: ",
            "682 + 31 + 789: ",
            "735 + 35 + 645: ",
            "878 - 505 - 5: ",
            "645 - 129 - 3: ",
            "848 - 137 - 16: ",
            "1000 - 798 - 200: ",
            "848 - 424 - 369: ",
            "800 - 425 - 250: ",
            "864 - 128 - 32: ",
            "999 - 327 - 3: ",
            "789 - 682 - 31: ",
            "735 - 645 - 35: "

    };
    private static String[] englishAnswers = {
            "5",
            "18",
            "8",
            "12",
            "32",
            "30",
            "54",
            "49",
            "10",
            "18",
            "2",
            "4",
            "3",
            "7",
            "3",
            "6",
            "3",
            "4",
            "2",
            "2",
            "194",
            "160",
            "448",
            "404",
            "69",
            "399",
            "553",
            "400",
            "136",
            "1500",
            "118",
            "32",
            "64",
            "396",
            "51",
            "113",
            "425",
            "100",
            "42",
            "500",
            "1010",
            "1920",
            "84",
            "144",
            "1242",
            "969",
            "114",
            "146",
            "1",
            "192",
            "101",
            "43",
            "53",
            "5",
            "2",
            "2",
            "4",
            "333",
            "22",
            "21",
            "1388",
            "777",
            "1001",
            "1998",
            "1641",
            "1175",
            "1024",
            "1329",
            "1502",
            "1415",
            "368",
            "513",
            "695",
            "2",
            "55",
            "125",
            "704",
            "669",
            "76",
            "55"

    };
    private static String[] spanishPhrases = {
            "5 x 1: ",
            "9 x 2: ",
            "2 x 4: ",
            "4 x 3: ",
            "8 x 4: ",
            "5 x 6: ",
            "6 x 9: ",
            "7 x 7: ",
            "10 x 1: ",
            "6 x 3: ",
            "2 ÷ 1: ",
            "8 ÷ 2: ",
            "9 ÷ 3: ",
            "14 ÷ 2: ",
            "6 ÷ 2: ",
            "18 ÷ 3: ",
            "12 ÷ 4: ",
            "16 ÷ 4: ",
            "8 ÷ 4: ",
            "12 ÷ 6: ",
            "156 + 36 + 2: ",
            "64 + 96: ",
            "256 + 128 + 64: ",
            "400 + 2 + 2: ",
            "60 + 6 + 3: ",
            "256 + 143: ",
            "489 + 64: ",
            "150 + 250: ",
            "89 + 32 + 15: ",
            "1000 + 250 + 250: ",
            "156 - 36 - 2: ",
            "96 - 64: ",
            "256 - 128 - 64: ",
            "400 - 2 - 2: ",
            "60 - 6 - 3: ",
            "256 - 143: ",
            "489 - 64: ",
            "250 - 150: ",
            "89 - 32 - 15: ",
            "1000 - 250 - 250: ",
            "505 x 2: ",
            "96 x 20: ",
            "21 x 4: ",
            "48 x 3: ",
            "621 x 2: ",
            "57 x 17: ",
            "6 x 19: ",
            "73 x 2: ",
            "1234 x 1: ",
            "64 x 3: ",
            "505 ÷ 5: ",
            "129 ÷ 3: ",
            "848 ÷ 16: ",
            "1000 ÷ 200: ",
            "848 ÷ 424: ",
            "500 ÷ 250: ",
            "128 ÷ 32: ",
            "999 ÷ 3: ",
            "682 ÷ 31: ",
            "735 ÷ 35: ",
            "505 + 5 + 878: ",
            "129 + 3 + 645: ",
            "848 + 16 + 137: ",
            "1000 + 200 + 798: ",
            "848 + 424 + 369: ",
            "500 + 250 + 425: ",
            "128 + 32 + 864: ",
            "999 + 3 + 327: ",
            "682 + 31 + 789: ",
            "735 + 35 + 645: ",
            "878 - 505 - 5: ",
            "645 - 129 - 3: ",
            "848 - 137 - 16: ",
            "1000 - 798 - 200: ",
            "848 - 424 - 369: ",
            "800 - 425 - 250: ",
            "864 - 128 - 32: ",
            "999 - 327 - 3: ",
            "789 - 682 - 31: ",
            "735 - 645 - 35: "

    };
    private static String[] spanishAnswers = {
            "5",
            "18",
            "8",
            "12",
            "32",
            "30",
            "54",
            "49",
            "10",
            "18",
            "2",
            "4",
            "3",
            "7",
            "3",
            "6",
            "3",
            "4",
            "2",
            "2",
            "194",
            "160",
            "448",
            "404",
            "69",
            "399",
            "553",
            "400",
            "136",
            "1500",
            "118",
            "32",
            "64",
            "396",
            "51",
            "113",
            "425",
            "100",
            "42",
            "500",
            "1010",
            "1920",
            "84",
            "144",
            "1242",
            "969",
            "114",
            "146",
            "1",
            "192",
            "101",
            "43",
            "53",
            "5",
            "2",
            "2",
            "4",
            "333",
            "22",
            "21",
            "1388",
            "777",
            "1001",
            "1998",
            "1641",
            "1175",
            "1024",
            "1329",
            "1502",
            "1415",
            "368",
            "513",
            "695",
            "2",
            "55",
            "125",
            "704",
            "669",
            "76",
            "55"

    };
    static{
        String[][] answers = {multiplicationAnswers, divisionAnswers,addition2Answers,subtraction2Answers,multiplication3Answers, division3Answers, addition3Answers,subtraction3Answers};
        String[][] phrases = {multiplicationPhrases, divisionPhrases, addition2Phrases, subtraction2Phrases ,multiplication3Phrases, division3Phrases,addition3Phrases,subtraction3Phrases};
        String[][] answersLanguage = {englishAnswers, spanishAnswers};
        String[][] phrasesLanguage = {englishPhrases, spanishPhrases};

        for(int i = 0; i < answers.length; i++){
            ArrayMap<String, String> map = new ArrayMap<>();
            for(int j = 0; j < answers[i].length; j++){
                map.put(phrases[i][j], answers[i][j]);
            }
            typeMapping.put(types[i], map);
        }

        for(int i = 0; i < answersLanguage[0].length; i++){
            ArrayMap<Integer, String> map = new ArrayMap<>();
            for(int j = 0; j < answersLanguage.length; j++){
                map.put(j, answersLanguage[j][i]);
            }
            answerslanguageMapping.put(answersLanguage[0][i], map);
        }

        for(int i = 0; i < phrasesLanguage[0].length; i++){
            ArrayMap<Integer, String> map = new ArrayMap<>();
            for(int j = 0; j < phrasesLanguage.length; j++){
                map.put(j, phrasesLanguage[j][i]);
            }
            phraseslanguageMapping.put(phrasesLanguage[0][i], map);
        }
    }

    public static CompletePhraseTaskModel generateCompletePhraseTaskModel(String type, int language){
        ArrayMap<String, String> map = typeMapping.get(type);
        int r = (int)(Math.random()*map.size());
        String phrase = map.keyAt(r);
        String answer = map.get(phrase);
        List<String> options = new ArrayList<>();
        options.add(answer);
        Object[] values = map.values().toArray();
        while(true){
            r = (int)(Math.random()*map.size());
            if(!options.contains(values[r])){
                options.add((String)values[r]);
                if(options.size() == 4){
                    break;
                }
            }
        }
        Collections.shuffle(options);

        return CompletePhraseTaskModel.builder()
            .phrase(phraseslanguageMapping.get(phrase).get(language))
            .correctOption(answerslanguageMapping.get(answer).get(language))
            .option1(answerslanguageMapping.get(options.get(0)).get(language))
            .option2(answerslanguageMapping.get(options.get(1)).get(language))
            .option3(answerslanguageMapping.get(options.get(2)).get(language))
            .option4(answerslanguageMapping.get(options.get(3)).get(language))
            .build();
    }
}
