package application.classes;

public class EspecialAgency extends Agency{
    private Vinheta vinheta;

    public EspecialAgency(String name, String cnpj, Adress adress, Manager manager, Vinheta vinheta){
        super(name, cnpj, adress, manager);
        this.vinheta = vinheta;
    }
    public String getName(){
        return this.name;
    }

    public void showAgency(){
        System.out.printf("NOME: %s\nCNPJ: %s\nENDEREÇO: %s\nGERENTE: %s\nCAMPANHA: %s\n", name, cnpj, adress, manager, vinheta);
    }

    @Override
    public Campaign getCampaign(){
        return this.vinheta;
    }
}
