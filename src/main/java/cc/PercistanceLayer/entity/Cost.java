package cc.PercistanceLayer.entity;

import cc.PercistanceLayer.entity.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cost extends Entity {
    private long id;
    private String costId;
    private User user;
    private String description;
    private int amount;
    private boolean deleted;
    private String createdDate;
    private String deletedDate;
}
