package application.classes;

public class CommumAgency extends Agency{
    private Commum commum;

    public CommumAgency(String name, String cnpj, Adress adress, Manager manager, Commum commum){
        super(name, cnpj, adress, manager);
        this.commum = commum;
    }

    public void showAgency(){
        System.out.printf("NOME: %s\nCNPJ: %s\nENDEREÇO: %s\nGERENTE: %s\nCAMPANHA: %s\n", name, cnpj, adress, manager, commum);
    }
}
