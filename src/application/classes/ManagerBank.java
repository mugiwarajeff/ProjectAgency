package application.classes;

public class ManagerBank {
    private int index;
    private Manager[] bank;

    public ManagerBank(){
        index = 0;
        bank = new Manager[5];
    }

    public void insert(Manager a){
        bank[index] = a;
        index++;
    }

    public void remove(Manager a){
        for(int i = 0; i < index; i++){
            if(bank[i] == a){
                bank[i] = bank[index-1];
                bank[index-1] = null;
                index--;
            }
        }
    }

    public Manager search(String a){
        for(int i = 0; i < index; i++){
            if(bank[i].getName() == a){
                return bank[i];
            }
        }
        return null;
    }

    public void report(){
        for(int i = 0; i < index; i++){
            bank[i].showManager();
            //System.out.println("===============");
        }
    }

    public String[] getManagersNames(){
        String[] arrayOfNames = new String[index];

        for (int i = 0; i < index; i++){
            arrayOfNames[i] = bank[i].name;
        }
        
        return arrayOfNames;
    }
}
