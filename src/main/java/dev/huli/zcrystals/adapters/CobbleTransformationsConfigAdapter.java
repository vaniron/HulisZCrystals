package dev.huli.zcrystals.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.huli.zcrystals.config.CobbleTransformationsConfig;
import dev.huli.zcrystals.manager.CobbleTransformationsConfigDataManager;

import java.io.IOException;

public class CobbleTransformationsConfigAdapter extends TypeAdapter<CobbleTransformationsConfig> {
    @Override
    public void write(JsonWriter out, CobbleTransformationsConfig config) throws IOException {
        Gson gson = new Gson();
        CobbleTransformationsConfigDataManager dataManager = config.cobbleTransformationsConfigDataManager;
        out.beginObject();
            out.name("COMMAND_Z_RING_PERMISSION_LEVEL");
            out.value(dataManager.Z_RING_PERMISSION_LEVEL);
            out.name("SERVERSIDE");
            out.value(dataManager.SERVERSIDE);
        out.endObject();
    }

    @Override
    public CobbleTransformationsConfig read(JsonReader in) throws IOException{
        CobbleTransformationsConfig conf = new CobbleTransformationsConfig();
        CobbleTransformationsConfigDataManager dataManager = new CobbleTransformationsConfigDataManager();
        in.beginObject();
        while (in.hasNext()){
            String fieldName = in.nextName();

            switch (fieldName){
                case "COMMAND_Z_RING_PERMISSION_LEVEL":
                    dataManager.Z_RING_PERMISSION_LEVEL = in.nextInt();
                    break;
                case "SERVERSIDE":
                    dataManager.SERVERSIDE = in.nextBoolean();
                    break;
                default:
                    break;
            }
        }
        in.endObject();
        conf.cobbleTransformationsConfigDataManager = dataManager;
        return conf;
    }
}
