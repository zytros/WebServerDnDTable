package JSON;

public class Character {

    public Character(String name, int currentHP, int maxHP) {
        this.name = name;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
    }

    public Character() {
    }

    public Character(int id) {
        this.id = id;
        name = Integer.toString(id);
    }

    private int id;
    private String name;
    private int currentHP;
    private int maxHP;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    @Override
    public String toString() {
        String s = "{\n";
        s += "\"name\": \"" + name + "\",\n";
        s += "\"currentHP\": \"" + currentHP + "\",\n";
        s += "\"maxHP\": \"" + maxHP + "\"\n";
        s +="}";
        return s;
    }
}
