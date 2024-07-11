package dev.huli.zcrystals.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.huli.zcrystals.adapters.CobbleTransformationsConfigAdapter;
import dev.huli.zcrystals.config.CobbleTransformationsConfig;

import java.lang.reflect.Modifier;

public class Adapters {
    public static Gson MAIN_CONFIG_GSON = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT)
            .registerTypeAdapter(CobbleTransformationsConfig.class,new CobbleTransformationsConfigAdapter())
            .create();
}
