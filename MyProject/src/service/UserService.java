package service;

import dao.UserDao;
import entityLayer.User;

/**
 * Created by DMITRIUS on 29.01.2017.
 */
public class UserService {

    private static UserService INSTANCE;
    private UserService() {}

    private static UserService getInst() {
        if(INSTANCE == null) {
            synchronized (UserService.class) {
                if(INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public static void addUser(String firstName, String lastName, String middleName, String email, String password) {
        UserDao userDao = new UserDao();
        userDao.initDB();
        userDao.addUsers(new User(firstName, lastName, middleName, email, password));
    }
}
