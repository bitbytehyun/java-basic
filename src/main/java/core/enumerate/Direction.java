package core.enumerate;

public enum Direction implements Printable {
    /*
    필드 추가
     */
    NORTH(0), SOUTH(90), EAST(180), WEST(270);

    private final int degrees;

    Direction(int degrees) {
        this.degrees = degrees;
    }

    // 아래와 동일하다
//    private Direction(String name, int ordinal, int degrees) {
//        super(name, ordinal);
//        this.degrees = degrees;
//    }

    public int getDegrees() {
        return degrees;
    }


    /*
    매서드 추가
     */
    public Direction opposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
        }
        throw new AssertionError("Unknown Direction " + this);
    }

    /*
    인터페이스 구현
     */
    @Override
    public void print() {
        System.out.println("Direction is " + this.name());
    }
}
