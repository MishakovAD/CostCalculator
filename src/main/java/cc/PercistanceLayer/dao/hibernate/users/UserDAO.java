package cc.PercistanceLayer.dao.hibernate.users;

import cc.PercistanceLayer.entity.users.User;

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
