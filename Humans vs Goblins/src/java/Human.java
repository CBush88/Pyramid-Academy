public class Human extends Humanoid implements Attack, Move {
    protected int hp = 20;
    protected int damage = 1;
    public Human(){
        this.setHp(hp);
        this.setDamage(damage);
    }
    public String toString(){
        String s = String.format("Player%n" +
                    "HP: %d", this.getHp());
        return s;
    }
}
