package com.example.funspeak.tasksbuilders;

import android.util.ArrayMap;

import com.example.funspeak.tasksmodels.SynonymsTaskModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynonymsTaskBuilder {
    private static ArrayMap<Integer, String[][]> synonyms = new ArrayMap<>();
    private static String[][] englishSynonyms = {
            {"single-minded", "stubborn", "obdurate", "adamant"},
            {"sideways", "sideward", "alongside", "flanking"},
            {"captain", "skipper", "boat master"}
    };
    private static String[][] spanishSynonyms = {
            {"Decidido", "terco", "irreductible", "categórico"},
            {"de lado", "hacia los lados", "junto a", "flanqueando"},
            {"capitán", "navegante", "patrón de barcaza"}
    };
    static{
        synonyms.put(0,englishSynonyms);
        synonyms.put(1,spanishSynonyms);
    }
    public static SynonymsTaskModel generateSynonymsTaskModel(int language){
        String[][] synonyms = SynonymsTaskBuilder.synonyms.get(language);
        int r = (int)(Math.random() * synonyms.length);
        int r1, r2;
        while(true) {
            r1 = (int) (Math.random() * synonyms[r].length);
            r2 = (int)(Math.random() * synonyms[r].length);
            if(r1 != r2) break;
        }
        String synonym = synonyms[r][r1];
        String correctSynonym = synonyms[r][r2];
        List<String> options = new ArrayList<>();
        options.add(correctSynonym);
        while(true){
            int r3 = (int)(Math.random() * synonyms.length);
            if(r3 == r) continue;
            int r4 = (int)(Math.random() * synonyms[r3].length);
            String option = synonyms[r3][r4];
            if(!options.contains(option)) options.add(option);
            if(options.size() == 4) break;
        }
        Collections.shuffle(options);
        return SynonymsTaskModel.builder()
                .synonym(synonym)
                .correctSynonym(correctSynonym)
                .synonym1(options.get(0))
                .synonym2(options.get(1))
                .synonym3(options.get(2))
                .synonym4(options.get(3))
                .build();
    }
}
