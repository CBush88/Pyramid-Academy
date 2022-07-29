public class Human extends Humanoid implements Move {
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

    public void run(){
        this.setXPos((int)(Math.random() * 10));
        this.setYPos((int)(Math.random() * 10));
    }
}
