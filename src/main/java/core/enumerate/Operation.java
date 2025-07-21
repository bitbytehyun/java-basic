package core.enumerate;

public enum Operation {
    PLUS {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    /*
    매서드 구현
     */
    public abstract int apply(int x, int y);
}
