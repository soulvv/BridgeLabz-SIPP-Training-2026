class Order {
    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() { return orderId; }
    public String getOrderDate() { return orderDate; }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() { return trackingNumber; }

    @Override
    public String getOrderStatus() {
        return "Order Shipped. Tracking Number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() { return deliveryDate; }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD100", "2026-06-20");
        ShippedOrder shippedOrder = new ShippedOrder("ORD101", "2026-06-21", "TRK987654321");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD102", "2026-06-15", "TRK123456789", "2026-06-23");

        System.out.println("--- Order Statuses ---");
        System.out.println(order.getOrderId() + ": " + order.getOrderStatus());
        System.out.println(shippedOrder.getOrderId() + ": " + shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderId() + ": " + deliveredOrder.getOrderStatus());
    }
}
