package com.example.funspeak.tasksbuilders;

import android.util.ArrayMap;

import com.example.funspeak.R;
import com.example.funspeak.tasksmodels.SelectPhotoTaskModel;

import java.util.ArrayList;
import java.util.List;


public class SelectPhotoTaskBuilder {

    private final static ArrayMap<String, ArrayMap<Integer, String>> languagesMapping = new ArrayMap<>();
    private final static ArrayMap<String, ArrayMap<String, Integer>> typesMapping = new ArrayMap<>();

    //Data necessary for mapping images
    private final static String[] types = {
            "Animals",
            "Food",
            "Verbs"
    };
    private final static String[] animals = {
            "Horse",
            "Bird",
            "Dog",
            "Cat",
            "Wolf",
            "Lion",
            "Tiger",
            "Monkey",
            "Chimp",
            "Dolphin",
            "Shark"
    };
    private final static int[] animalsImagesId = {
            R.drawable.horse,
            R.drawable.bird,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.wolf,
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.chimp,
            R.drawable.dolphin,
            R.drawable.shark};
    private final static String[] food = {
            "Banana",
            "Apple",
            "Mango",
            "Beef",
            "Cake",
            "Burger",
            "Soap",
            "Milk",
            "Cheese",
            "Tomato"};
    private final static int[] foodImagesId = {
            R.drawable.banana,
            R.drawable.apple,
            R.drawable.mango,
            R.drawable.beef,
            R.drawable.cake,
            R.drawable.burger,
            R.drawable.soap,
            R.drawable.milk,
            R.drawable.cheese,
            R.drawable.tomato
    };
    private final static String[] verbs = {
            "Punch",
            "Jump",
            "Draw",
            "Run",
            "Fly",
            "Sing"
    };
    private final static int[] verbsImagesId = {
            R.drawable.punch,
            R.drawable.jump,
            R.drawable.draw,
            R.drawable.run,
            R.drawable.fly,
            R.drawable.sing
    };
    //Data necessary for translation
    private final static String[] english = {
            "Horse",
            "Bird",
            "Dog",
            "Cat",
            "Wolf",
            "Lion",
            "Tiger",
            "Banana",
            "Apple",
            "Mango",
            "Beef",
            "Cake",
            "Burger",
            "Monkey",
            "Chimp",
            "Shark",
            "Dolphin",
            "Soap",
            "Milk",
            "Cheese",
            "Tomato",
            "Punch",
            "Jump",
            "Draw",
            "Run",
            "Fly",
            "Sing"
    };
    private final static String[] spanish = {
            "Caballo",
            "Pajaro",
            "Perro",
            "Gato",
            "Lobo",
            "Leon",
            "Tigre",
            "Platano",
            "Manzana",
            "Mango",
            "Bistec",
            "Pastel",
            "Hamburguesa",
            "Mono",
            "Chimpance",
            "Tiburon",
            "Delfin",
            "Sopa",
            "Leche",
            "Queso",
            "Tomate",
            "Puñetazo",
            "Saltar",
            "Dibujar",
            "Correr",
            "Volar",
            "Cantar"
    };

    static{
        String[][] options = {animals,food,verbs};
        int[][] optionsImagesIds = {animalsImagesId, foodImagesId, verbsImagesId};
        String[][] languages = {english,spanish};

        //Types Mapping
        for(int i = 0; i < options.length; i++){
            ArrayMap<String, Integer> map = new ArrayMap<>();
            for(int j = 0; j < options[i].length; j++){
                map.put(options[i][j], optionsImagesIds[i][j]);
            }
            typesMapping.put(types[i], map);
        }

        //LanguageMapping
        for(int i = 0; i < languages[0].length; i++){
            ArrayMap<Integer, String> map = new ArrayMap<>();
            for(int j = 0; j < languages.length; j++){
                map.put(j, languages[j][i]);
            }
            languagesMapping.put(languages[0][i], map);
        }
    }

    public static SelectPhotoTaskModel generateSelectPhotoTaskModel(String type, int language){
        ArrayMap<String, Integer> map = typesMapping.get(type);
        List<String> keys = new ArrayList<>();
        while(true){
            int option = (int) (Math.random() * map.keySet().size());
            String optionKey = map.keyAt(option);
            if(!keys.contains(optionKey)){
                keys.add(optionKey);
                if(keys.size() == 4){
                    break;
                }
            }
        }
        int correctOption = (int) (Math.random() * 4);
        String correctOptionKey = keys.get(correctOption);
        SelectPhotoTaskModel selectPhotoTaskModel = SelectPhotoTaskModel.builder()
                .correctOptionName(languagesMapping.get(correctOptionKey).get(language))
                .correctImageId(map.get(correctOptionKey))
                .option1ImageId(map.get(keys.get(0)))
                .option2ImageId(map.get(keys.get(1)))
                .option3ImageId(map.get(keys.get(2)))
                .option4ImageId(map.get(keys.get(3)))
                .build();
        return selectPhotoTaskModel;
    }

}
