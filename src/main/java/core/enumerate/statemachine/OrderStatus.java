package core.enumerate.statemachine;

public enum OrderStatus {
    PAYMENT_WAITING {
        @Override
        public boolean canChangeTo(OrderStatus nextStatus) {
            return nextStatus == PAYMENT_COMPLETED;
        }
    },
    PAYMENT_COMPLETED {
        @Override
        public boolean canChangeTo(OrderStatus nextStatus) {
            return nextStatus == SHIPPING;
        }
    },
    SHIPPING {
        @Override
        public boolean canChangeTo(OrderStatus nextStatus) {
            return nextStatus == DELIVERY_COMPLETED;
        }
    },
    DELIVERY_COMPLETED {
        @Override
        public boolean canChangeTo(OrderStatus nextStatus) {
            return false; // 더이상 상태변경 불가
        }
    };


    public abstract boolean canChangeTo(OrderStatus nexㄷtStatus);
}
