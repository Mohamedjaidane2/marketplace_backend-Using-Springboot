package com.example.marketplace.service.Impl;

import com.example.marketplace.Enum.EAdvertisementSoldStats;
import com.example.marketplace.Enum.EAdvertisementStats;
import com.example.marketplace.Enum.EOrderStatus;
import com.example.marketplace.dto.OrderDtos.OrderDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.entity.*;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IAdvertisementRepository;
import com.example.marketplace.repository.IOrderRepository;
import com.example.marketplace.service.IOrderServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderServices {
    private final IAccountRepository accountRepository;
    private final IAdvertisementRepository advertisementRepository;
    private final IOrderRepository orderRepository;
    @Override
    public SuccessDto toOrder(Integer accountId, Integer advertisementId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND));

        Advertisement advertisement = advertisementRepository.findById(advertisementId)
                .orElseThrow(() -> new EntityNotFoundException("Advertisement not found", ErrorCodes.ADVERTISEMENT_NOT_FOUND));

        // Check if the account has already placed an order for the specified advertisement
        boolean hasPlacedOrder = orderRepository.existsByAccountAndAdvertisement(account, advertisement);

        if (hasPlacedOrder) {
            throw new InvalidOperationException("You have already placed an order for this advertisement", ErrorCodes.ORDER_ALREADY_IN_USE);
        }

        // Check if the advertisement belongs to the same account
        if (advertisement.getAccount().getAccountId().equals(accountId)) {
            throw new InvalidOperationException("You can't place an order on your own advertisement", ErrorCodes.CANNOT_ORDER_OWN_ADVERTISEMENT);
        }

        // Check if someone else has already ordered this advertisement
        if (advertisement.getOrder() != null) {
            throw new InvalidOperationException("Someone else has already ordered this advertisement", ErrorCodes.ADVERTISEMENT_ALREADY_ORDERED);
        }

        // Create a new Order using the builder pattern
        Order order = Order.builder()
                .account(account)
                .advertisement(advertisement)
                .orderStatus(EOrderStatus.AWAITING_CONFIRMATION)
                .build();

        // Save the created Order
        orderRepository.save(order);

        // Update the AdvertisementSoldStatus to IN_PROGRESS
        advertisement.setAdvertisementSoldStats(EAdvertisementSoldStats.IN_PROGRESS);
        advertisement.setOrder(order); // Set the order for the advertisement
        advertisementRepository.save(advertisement);

        return SuccessDto.builder()
                .message("Order placed successfully")
                .build();
    }

    @Override
    public List<OrderDto> getOrderByAccount(Integer accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);

        if (accountOptional.isEmpty()) {
            throw new EntityNotFoundException("Account not found", ErrorCodes.ACCOUNT_NOT_FOUND);
        }

        Account account = accountOptional.get();

        return account.getOrders().stream()
                .map(OrderDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public SuccessDto cancelOrderById(Integer orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty()) {
            throw new InvalidOperationException("Order not found in orders", ErrorCodes.ORDER_NOT_FOUND);
        }

        Order order = orderOptional.get();

        // Check if the order is already canceled
        if (order.getOrderStatus() == EOrderStatus.CANCELLED) {
            throw new InvalidOperationException("Order is already canceled", ErrorCodes.ORDER_ALREADY_CANCELLED);
        }

        // Update the orderStatus to EOrderStatus.CANCELLED
        order.setOrderStatus(EOrderStatus.CANCELLED);
        orderRepository.save(order);

        // Remove the order from the advertisement
        Advertisement advertisement = order.getAdvertisement();
        advertisement.setOrder(null); // Remove the order from the advertisement
        advertisement.setAdvertisementSoldStats(EAdvertisementSoldStats.AVAILABLE);
        advertisementRepository.save(advertisement);

        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CANCELLED)
                .build();
    }


    @Override
    public OrderDto getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isEmpty()) {
            throw new EntityNotFoundException("Order not found", ErrorCodes.ORDER_NOT_FOUND);
        }
        return OrderDto.customMapping(order.get());
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDto::customMapping)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getAllOrdersByOwner(Integer idOwner) {
        return orderRepository.findAllOrdersByAccountId(idOwner)
                .stream()
                .map(OrderDto::customMapping)
                .collect(Collectors.toList());
    }

}
