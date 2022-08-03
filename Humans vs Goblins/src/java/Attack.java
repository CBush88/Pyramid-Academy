public interface Attack {
    default String attack(Humanoid attacker, Humanoid defender){

        int turnDamage = (int)(Math.random() * 5) + attacker.getDamage();
        defender.setHp(defender.getHp() - turnDamage);

        String result = String.format("%s attacks %s for %d damage.%n",
                attacker.getClass().getSimpleName(),
                defender.getClass().getSimpleName(),
                turnDamage);

        if(defender.getHp() <= 0){
            result += String.format("%s dies.", defender.getClass().getSimpleName());
        }

        return result;
    }
}
