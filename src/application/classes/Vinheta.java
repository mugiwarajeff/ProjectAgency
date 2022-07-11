package application.classes;

public class Vinheta extends Campaign{
    private double time;

    public Vinheta(String description, double value, int code, double time){
        super(description, value, code);
        this.time = time;
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

    @Override
    public String getTime(){
        return String.valueOf(this.time);
    }

    public String toString(){
        return "Descrição:" + this.description + " | Valor:" + this.value + " | Código:" + this.code + " | Tempo:" + this.time;
    }

    public void showCampaign(){
        //System.out.printf("Descrição: %s\nValor: %s\nCódigo: %s\nVinheta: %s\n", description, value, code, time);
    }
}
