package application.classes;

public class AgencyBank {
    private int index;
    private Agency[] bank;

    public AgencyBank(){
        index = 0;
        bank = new Agency[10];
    }

    public void insert(Agency a){
        bank[index] = a;
        index++;
    }

    public void remove(Agency a){
        for(int i = 0; i < index; i++){
            if(bank[i] == a){
                bank[i] = bank[index-1];
                bank[index-1] = null;
                index--;
            }
        }
    }

    public Agency search(String a){
        for(int i = 0; i < index; i++){
            if(bank[i].getName() == a){
                return bank[i];
            }
        }
        return null;
    }

    public void report(){
        for(int i = 0; i < index; i++){
            bank[i].showAgency();
            //System.out.println("=======================================================");
        }
    }

    public int getBankLenght(){
        return index;
    }

    public int getBankEspecialLenght(){
        int quantReturn = 0;

        for(int i = 0; i < index; i++){
            if (bank[i] instanceof EspecialAgency){
                quantReturn++;
            }
        }

        return quantReturn;
    }

    public int getBankCommumLenght(){
        int quantReturn = 0;
        for(int i = 0; i < index; i++){
            if (bank[i] instanceof CommumAgency){
                quantReturn++;
            }
        }
        
        return quantReturn;
    }

    public Agency[] getBankItens(){
        return bank;
    }
}
