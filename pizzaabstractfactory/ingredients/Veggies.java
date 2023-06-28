package pizzaabstractfactory.ingredients;

public abstract class Veggies {

    String desc = "Veggies";

    public void setDesc(String name){
        desc = name;
    }

    public String getDesc(){
        return desc;
    }
}