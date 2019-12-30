package cc.PercistanceLayer.dao.hibernate.users;

import cc.PercistanceLayer.entity.users.User;

public interface UserDA {
    boolean registration(User user);
    User getUserById(long userId);
}
