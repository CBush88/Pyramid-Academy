public interface Move {
    default void move(Humanoid humanoid, char direction){
        switch (direction){
            case 'w':
                if(humanoid.getYPos() != 0) {
                    humanoid.setYPos(humanoid.getYPos() - 1);
                }
                break;
            case 's':
                if(humanoid.getYPos() != 9) {
                    humanoid.setYPos(humanoid.getYPos() + 1);
                }
                break;
            case 'd':
                if(humanoid.getXPos() != 9) {
                    humanoid.setXPos(humanoid.getXPos() + 1);
                }
                break;
            case 'a':
                if(humanoid.getXPos() != 0) {
                    humanoid.setXPos(humanoid.getXPos() - 1);
                }
                break;
            default:
                break;
        }
    }
}
