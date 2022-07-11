package application.classes;

public abstract class Agency {
    protected String name;
    protected String cnpj;
    protected Adress adress;
    protected Manager manager;

    public Agency(String name, String cnpj, Adress adress, Manager manager){
        this.name = name;
        this.cnpj = cnpj;
        this.adress = adress;
        this.manager = manager;
    }

    public abstract void showAgency();

    public String getName() {
        return this.name;
    }

    public String getCNPJ(){
        return this.cnpj;
    }

    public Adress getAdress(){
        return this.adress;
    }

    public Manager getManager(){
        return this.manager;
    }

    public String getManagerName(){
        return this.manager.getName();
    }

    public abstract Campaign getCampaign();

    
}
