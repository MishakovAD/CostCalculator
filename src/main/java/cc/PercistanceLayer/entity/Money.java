package cc.PercistanceLayer.entity;

import cc.PercistanceLayer.entity.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Money extends Entity {
    private long id;
    private String moneyId;
    private User user;
    private String description;
    private int amount;
    private boolean deleted;
    private String createdDate;
    private String deletedDate;
}
