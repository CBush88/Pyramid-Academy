public class Goblin extends Humanoid implements Move{
    private int hp = 10;
    private int damage = 1;
    public Goblin(){
        this.setHp(hp);
        this.setDamage(damage);
    }
    public String toString(){
        String s = String.format("Enemy Goblin%n"+
                    "HP: %d", this.getHp());

        return s;
    }
}
