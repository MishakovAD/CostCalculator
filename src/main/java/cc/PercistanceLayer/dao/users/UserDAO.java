package cc.PercistanceLayer.dao.users;

import cc.PercistanceLayer.entity.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAO implements UserDA{
    @Override
    public boolean registration(User user) {
        return false;
    }

    @Override
    public User getUserById(long userId) {
        return null;
    }
}
