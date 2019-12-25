package cc.PercistanceLayer.dao.users;

import cc.PercistanceLayer.entity.users.User;

public interface UserDA {
    boolean registration(User user);
    User getUserById(long userId);
}
