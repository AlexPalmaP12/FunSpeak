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
            "Animals",
            "Food",
            "Verbs"
    };
    private static String[] animalsPhrases = {
            "The _____ bark",
            "The _____ meows",
            "The cowboy rides _____",
            "The _____ has a blowhole in his head",
            "The _____ has big ears",
            "The _____ is the best friend of the men",
            "The _____ flies away",
            "The _____ has a long neck"
    };
    private static String[] animalsAnswers = {
            "Dog",
            "Cat",
            "Horses",
            "Dolphin",
            "Rabbit",
            "Dog",
            "Bird",
            "Giraffe"
    };
    private static String[] foodPhrases = {
            "The monkey eats _____",
            "Cows make _____",
            "I eat _____ on my birthday",
            "The _____ is cow meat",
            "SpongeBob makes _____ in the Krusty Krabs"
    };
    private static String[] foodAnswers = {
            "Banana",
            "Milk",
            "Cake",
            "Beef",
            "Burgers"
    };
    private static String[] verbPhrases = {
            "Jhon _____ because he is angry",
            "The plane _____ away",
            "Tommi loves _____ comics with his pencil",
            "Chester _____ biggest musical hits"
    };
    private static String[] verbAnswers = {
            "Punches",
            "Flies",
            "To Draw",
            "Sings"
    };

    //Data necessary for translation
    private static String[] englishPhrases = {
            "The _____ bark",
            "The _____ meows",
            "The cowboy rides _____",
            "The _____ has a blowhole in his head",
            "The _____ has big ears",
            "The _____ is the best friend of the men",
            "The _____ flies away",
            "The _____ has a long neck",
            "The monkey eats _____",
            "Cows make _____",
            "I eat _____ on my birthday",
            "The _____ is cow meat",
            "SpongeBob makes _____ in the Krusty Krabs",
            "Jhon _____ because he is angry",
            "The plane _____ away",
            "Tommi loves _____ comics with his pencil",
            "Chester _____ biggest musical hits"
    };
    private static String[] englishAnswers = {
            "Dog",
            "Cat",
            "Horses",
            "Dolphin",
            "Rabbit",
            "Dog",
            "Bird",
            "Giraffe",
            "Banana",
            "Milk",
            "Cake",
            "Beef",
            "Burgers",
            "Punches",
            "Flies",
            "To Draw",
            "Sings"
    };
    private static String[] spanishPhrases = {
            "El _____ ladra",
            "El _____ maulla",
            "El vaquero cabalga _____",
            "El _____ tiene un orificio en su cabeza",
            "El _____ tiene orejas grandes",
            "El _____ es el mejor amigo del hombre",
            "El _____ se va volando",
            "El _____ tiene cuello largo",
            "El mono come _____",
            "Las vacas producen _____",
            "Comi _____ en mi cumpleaños",
            "El _____ es carne de vaca",
            "Bob Esponja hace _____ en el Crustaceo",
            "Jhon _____ porque está enojado",
            "El avión _____ lejos",
            "A Tommi le encantan _____ comics con su lápiz",
            "Chester _____ los mayores éxitos musicales"
    };
    private static String[] spanishAnswers = {
            "Perro",
            "Gato",
            "Caballos",
            "Delfín",
            "Conejo",
            "Perro",
            "Pájaro",
            "Jirafa",
            "Banana",
            "Leche",
            "Pastel",
            "Bistec",
            "Hamburguesas",
            "Golpeo",
            "Vuela",
            "Dibujar",
            "Canta"
    };
    static{
        String[][] answers = {animalsAnswers, foodAnswers, verbAnswers};
        String[][] phrases = {animalsPhrases, foodPhrases, verbPhrases};
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
