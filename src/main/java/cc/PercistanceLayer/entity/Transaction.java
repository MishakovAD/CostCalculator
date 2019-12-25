package cc.PercistanceLayer.entity;

import cc.PercistanceLayer.entity.users.User;

import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private User user;
    private int amount;
    private Entity from;
    private Entity to;
    private String transactionDate;
}
