package starbuzz.abstracts;


public abstract class Beverage {
    public String desc = "Unknown Beverage";
    public String getDescription(){
	    return desc;
    }
    public abstract double cost();

}