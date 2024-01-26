package com.nuist.medical.Constant;

public enum ModelType {
    XGBoost("xgboost"),

    MLP("MLP");


    private String type;

    private ModelType(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }
}
