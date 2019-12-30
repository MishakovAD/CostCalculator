package cc.PercistanceLayer.entity.users;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Пользователь.
 */
@Getter
@Setter
public class User {
    private long userId;
    private String email; //TODO: Возможно длдя емайла и пароля сделать одельные сущности, где в них будет вся обработка.
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String sex;
}
