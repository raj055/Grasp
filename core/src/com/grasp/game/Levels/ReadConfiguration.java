package com.grasp.game.Levels;

import com.badlogic.gdx.Gdx;
import com.grasp.game.Util.JSONUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.grasp.game.Util.MathUtils.asFloat;

/**
 * Created by HP on 12-01-2018.
 */

public class ReadConfiguration {


    public static List layoutArray;
    Random RAND = new Random();

    public static void readLayoutArray() {
        try {
            InputStream fin = Gdx.files.internal("skin/test.json").read();
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));

            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            fin.close();
            layoutArray = JSONUtils.listFromJSONString(buffer.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static ReadConfiguration layoutForLevel (int level) {
        try {
            if (layoutArray == null) readLayoutArray();
            Map layoutMap = (Map)layoutArray.get(level - 1);
            return new ReadConfiguration(layoutMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    static int numberOfLevels () {
        return layoutArray.size();
    }

    float width;
    float height;
    float targetTimeRatio;
    Map allParameters;
    public ReadConfiguration (Map layoutMap) {
        this.width = asFloat(layoutMap.get("width"), 20.0f);
        this.height = asFloat(layoutMap.get("height"), 30.0f);
        this.targetTimeRatio = asFloat(layoutMap.get("targetTimeRatio"));
        this.allParameters = layoutMap;
    }
}
