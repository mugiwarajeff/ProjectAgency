package application.classes;

public class Manager {
    protected String name;
    protected String lastName;
    protected String cpf;

    public Manager(String name, String lastName, String cpf){
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String toString(){
        return this.name + " " + this.lastName + " | CPF:" + this.cpf;
    }

    public void showManager(){
        //System.out.printf("Nome: %s\nSobrenome: %s\nCPF: %s\n", name, lastName, cpf);
    }
}
