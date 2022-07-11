package application.classes;

public class Commum extends Campaign{
    
    public Commum(String description, double value, int code){
        super(description, value, code);
    }

    public String getDescription(){
        return this.description;
    }

    public String getValue(){
        return String.valueOf(this.value);
    }

    public String getCode(){
        return String.valueOf(this.code);
    }

    public String toString(){
        return "Descrição:" + this.description + " | Valor:" + this.value + " | Código:" + this.code;
    }

    public void showCampaign(){
        //System.out.printf("Descrição: %s\nValor: %s\nCódigo: %s\n", description, value, code);
    }
}
