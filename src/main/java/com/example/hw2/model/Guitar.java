package com.example.hw2.model;

public class Guitar {
    private String serialNumber;
    private double price;
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public Guitar(String serialNumber, double price, Builder builder, String model,Type type, Wood backWood, Wood topWood){
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public enum Builder{
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

        public String toString(){
            switch(this){
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON: return "Olson";
                case RYAN: return "Ryan";
                case PRS: return "PRS";
                default: return "Unspecified";
            }
        }
    }

    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

        public String toString(){
            switch(this){
                case INDIAN_ROSEWOOD: return "Indian Rosewood";
                case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
                case MAHOGANY: return "Mahogany";
                case MAPLE: return "Maple";
                case COCOBOLO: return "Cocobolo";
                case CEDAR: return "Cedar";
                case ADIRONDACK: return "Adirondack";
                case ALDER: return "Alder";
                case SITKA: return "Sitka";
                default: return "Unspecified";
            }
        }
    }

    public enum Type{
        ACOUSTIC, ELECTRIC;
        public String toString(){
            switch(this){
                case ACOUSTIC: return "Acoustic";
                case ELECTRIC: return "Electric";
                default: return "Unspecified";
            }
        }
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(float newPrice){
        this.price = newPrice;
    }

    public Builder getBuilder(){
        return builder;
    }

    public String getModel(){
        return model;
    }

    public Type getType(){
        return type;
    }

    public Wood getBackWood(){
        return backWood;
    }

    public Wood getTopWood(){
        return topWood;
    }
}
