package org.example.task3;

public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean processOrder(Order order) {
// Логика обработки заказа, например, расчет скидок и отправка на выполнение
// В данном примере мы просто вызываем метод processPayment из PaymentService
        return paymentService.processPayment(order);
    }
}