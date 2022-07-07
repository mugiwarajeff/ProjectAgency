package application.classes;

public abstract class Campaign {
    protected String description;
    protected double value;
    protected int code;

    public Campaign(String description, double value, int code){
        this.description = description;
        this.value = value;
        this.code = code;
    }

    public abstract void showCampaign();
}
