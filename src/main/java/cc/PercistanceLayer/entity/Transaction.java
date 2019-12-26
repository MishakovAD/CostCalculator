package cc.PercistanceLayer.entity;

import cc.PercistanceLayer.entity.users.User;

import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private User user;
    private String transactionDate;
    private int amount;
    private Entity from; //Если не получится, то тут тогда просто уникальные айдишники.
    private Entity to; //Можно просто вытаскивать из сущности, передаваемой сюда.
    private boolean deleted;
    private String deletedDate;
}
