public abstract class Humanoid implements Attack, Move {
    protected int hp;
    protected int damage;

    protected int xPos = (int)(Math.random() * 10);
    protected int yPos = (int)(Math.random() * 10);

    public Humanoid(){
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public String attack(Humanoid defender){
        return attack(this, defender);
    }

    public void move(char direction) {
        move(this, direction);
    }
}
