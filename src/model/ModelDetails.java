package model;

public class ModelDetails {

    private int modelId;
    private int maker;
    private double model;

    public ModelDetails() {
    }

    public ModelDetails(int modelId, int maker, double model) {
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

    public double getModel() {
        return model;
    }

    public void setModel(double model) {
        this.model = model;
    }

}
