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
            "count",
            "count1",
            "addition",
            "subtraction",
            "geometry",
            "addition1",
            "subtraction1"
    };
    private final static String[] count = {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten"
    };
    private final static int[] countImagesId = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten
    };
    private final static String[] count1 = {
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
            "Twenty"
    };
    private final static int[] count1ImagesId = {
            R.drawable.diez10,
            R.drawable.once11,
            R.drawable.doce12,
            R.drawable.trece13,
            R.drawable.catorce14,
            R.drawable.quince15,
            R.drawable.dieciseis16,
            R.drawable.diecisiete17,
            R.drawable.dieciocho18,
            R.drawable.diecinueve19,
            R.drawable.veinte20
    };
    private final static String[] addition = {
            "4 + 4",
            "2 + 2",
            "3 + 6",
            "9 + 1",
            "2 + 5",
            "7 + 2",
            "1 + 7",
            "6 + 2",
            "7 + 3",
            "3 + 2"};
    private final static int[] additionImagesId = {
            R.drawable.ocho8,
            R.drawable.cuatro4,
            R.drawable.nueve9,
            R.drawable.diez10,
            R.drawable.siete7,
            R.drawable.nueve9,
            R.drawable.ocho8,
            R.drawable.ocho8,
            R.drawable.diez10,
            R.drawable.cinco5
    };
    private final static String[] subtraction = {
            "5 - 3",
            "2 - 1",
            "6 - 3",
            "9 - 1",
            "5 - 2",
            "7 - 2",
            "7 - 1",
            "10 - 1",
            "7 - 3",
            "3 - 2"

    };
    private final static int[] subtractionImagesId = {
            R.drawable.dos2,
            R.drawable.uno1,
            R.drawable.tres3,
            R.drawable.ocho8,
            R.drawable.tres3,
            R.drawable.cinco5,
            R.drawable.seis6,
            R.drawable.nueve9,
            R.drawable.cuatro4,
            R.drawable.uno1
    };
    private final static String[] geometry = {
            "Circle",
            "Triangle",
            "Pentagon",
            "Square",
            "Octagon",
            "Hexagon"

    };
    private final static int[] geometryImagesId = {
            R.drawable.circulo,
            R.drawable.triangulo,
            R.drawable.pentagono,
            R.drawable.cuadrado,
            R.drawable.octagono,
            R.drawable.hexagono
    };
    private final static String[] addition1 = {
            "16 + 4",
            "8 + 4",
            "4 + 6",
            "9 + 9",
            "10 + 5",
            "14 + 2",
            "1 + 17",
            "16 + 2",
            "7 + 13",
            "3 + 2"
    };
    private final static int[] addition1ImagesId = {
            R.drawable.ocho8,
            R.drawable.cuatro4,
            R.drawable.nueve9,
            R.drawable.diez10,
            R.drawable.siete7,
            R.drawable.nueve9,
            R.drawable.ocho8,
            R.drawable.ocho8,
            R.drawable.diez10,
            R.drawable.cinco5
    };
    private final static String[] subtraction1 = {
            "15 - 3",
            "12 - 1",
            "16 - 3",
            "19 - 1",
            "15 - 2",
            "17 - 2",
            "17 - 1",
            "10 - 1",
            "17 - 3",
            "13 - 2"

    };
    private final static int[] subtraction1ImagesId = {
            R.drawable.doce12,
            R.drawable.once11,
            R.drawable.trece13,
            R.drawable.dieciocho18,
            R.drawable.trece13,
            R.drawable.quince15,
            R.drawable.dieciseis16,
            R.drawable.nueve9,
            R.drawable.catorce14,
            R.drawable.once11
    };
    //Data necessary for translation
    private final static String[] english = {

            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
            "Twenty",
            "4 + 4",
            "2 + 2",
            "3 + 6",
            "9 + 1",
            "2 + 5",
            "7 + 2",
            "1 + 7",
            "6 + 2",
            "7 + 3",
            "3 + 2",
            "5 - 3",
            "2 - 1",
            "6 - 3",
            "9 - 1",
            "5 - 2",
            "7 - 2",
            "7 - 1",
            "10 - 1",
            "7 - 3",
            "3 - 2",
            "Circle",
            "Triangle",
            "Pentagon",
            "Square",
            "Octagon",
            "Hexagon",
            "16 + 4",
            "8 + 4",
            "4 + 6",
            "9 + 9",
            "10 + 5",
            "14 + 2",
            "1 + 17",
            "16 + 2",
            "7 + 13",
            "3 + 2",
            "15 - 3",
            "12 - 1",
            "16 - 3",
            "19 - 1",
            "15 - 2",
            "17 - 2",
            "17 - 1",
            "10 - 1",
            "17 - 3",
            "13 - 2"
    };
    private final static String[] spanish = {
            "Uno",
            "Dos",
            "Tres",
            "Cuatro",
            "Cinco",
            "Seis",
            "Siete",
            "Ocho",
            "Nueve",
            "Diez",
            "Diez",
            "Once",
            "Doce",
            "Trece",
            "Catorce",
            "Quince",
            "Dieciséis",
            "Diecisiete",
            "Dieciocho",
            "Diecinueve",
            "Veinte",
            "4 + 4",
            "2 + 2",
            "3 + 6",
            "9 + 1",
            "2 + 5",
            "7 + 2",
            "1 + 7",
            "6 + 2",
            "7 + 3",
            "3 + 2",
            "5 - 3",
            "2 - 1",
            "6 - 3",
            "9 - 1",
            "5 - 2",
            "7 - 2",
            "7 - 1",
            "10 - 1",
            "7 - 3",
            "3 - 2",
            "Círculo",
            "Triángulo",
            "Pentágono",
            "Cuadrado",
            "Octágono",
            "Hexágono",
            "16 + 4",
            "8 + 4",
            "4 + 6",
            "9 + 9",
            "10 + 5",
            "14 + 2",
            "1 + 17",
            "16 + 2",
            "7 + 13",
            "3 + 2",
            "15 - 3",
            "12 - 1",
            "16 - 3",
            "19 - 1",
            "15 - 2",
            "17 - 2",
            "17 - 1",
            "10 - 1",
            "17 - 3",
            "13 - 2"
    };

    static{
        String[][] options = {count,count1,addition,subtraction,geometry,addition1,subtraction1};
        int[][] optionsImagesIds = {countImagesId, count1ImagesId, additionImagesId,subtractionImagesId,geometryImagesId,addition1ImagesId,subtraction1ImagesId};
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
