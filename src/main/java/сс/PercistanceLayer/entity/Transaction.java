package сс.PercistanceLayer.entity;

import сс.PercistanceLayer.entity.users.User;

import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private User user;
    private int amount;
    private Entity entityFrom;
    private Entity entityTo;
    private LocalDateTime time;
}
