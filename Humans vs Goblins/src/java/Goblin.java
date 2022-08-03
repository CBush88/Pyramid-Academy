public class Goblin extends Humanoid implements Move{
    protected int hp = 10;
    protected int damage = 1;
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
