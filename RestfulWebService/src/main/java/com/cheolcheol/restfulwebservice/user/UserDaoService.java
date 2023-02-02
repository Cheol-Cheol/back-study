package com.cheolcheol.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    // 메모리 DB 사용 (DB는 나중에 연결할 예정)
    private static List<UserDomain> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new UserDomain(1, "cheolwon", new Date(), "pass1", "701010-1111111"));
        users.add(new UserDomain(2, "john", new Date(), "pass2", "801010-1111111"));
        users.add(new UserDomain(3, "tomas", new Date(), "pass3", "901010-1111111"));
    }

    public List<UserDomain> findAll() {
        return users;
    }

    public UserDomain save(UserDomain user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public UserDomain findOne(int id) {
        for (UserDomain user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public UserDomain deleteById(int id) {
        Iterator<UserDomain> iterator = users.iterator();

        while (iterator.hasNext()) {
            UserDomain user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
