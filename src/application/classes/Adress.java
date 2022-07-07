package application.classes;

public class Adress {
    String publicPlace;
    int number;
    String postalCode;

    public Adress(String publicPlace, int number, String postalCode){
        this.publicPlace = publicPlace;
        this.number = number;
        this.postalCode = postalCode;
    }

    public String getPlace(){
        return this.publicPlace;
    }

    public int getNumber(){
        return this.number;
    }

    public String getCode(){
        return this.postalCode;
    }

    public String toString(){
        return "Espaço público:" + this.publicPlace + " | Número:" + this.number + " | Código Postal:" + this.postalCode;
    }

    public void showAdress(){
        //System.out.printf("Lugar público: %s\nNúmero: %s\nCódigo postal: %s\n", publicPlace, number, postalCode);
    }
}
