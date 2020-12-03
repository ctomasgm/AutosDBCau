package model;

import org.json.JSONObject;

public class ModelDetails {

    private int modelId;
    private int maker;
    private String model;

    public ModelDetails() {
    }

    public ModelDetails(JSONObject json) {
        if (json.has("modelid")) {
            this.modelId = Integer.parseInt(json.get("modelid").toString());
        }
        if (json.has("maker")) {
            this.maker = Integer.parseInt(json.get("maker").toString());
        }
        if (json.has("model")) {
            this.model = json.get("model").toString();
        }
    }
    
    public ModelDetails(int modelId, int maker, String model) {
        this.modelId = modelId;
        this.maker = maker;
        this.model = model;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getMaker() {
        return maker;
    }

    public void setMaker(int maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
