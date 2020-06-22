package com.thoughtworks.midquiz.midquiz.Serveice;

import com.thoughtworks.midquiz.midquiz.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetUserByIdServeice {

    private Map<Long, User> userMap = new HashMap<>();

    public GetUserByIdServeice() {
        userMap.put((long)1, new User((long)1, "KAMIL", (long)24, "https://inews.gtimg.com/newsapp_match/0/3581582328/0",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio " +
                        "magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi."
        ));

        userMap.put((long)2, new User((long)2, "Zhonghao", (long)24, "https://inews.gtimg.com/newsapp_match/0/3581582328/0",
                "Happy to join TW"
        ));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void createUser(User car) {
            userMap.put(car.getId(), car);
    }

    public User getCarById(Integer id) {
        return userMap.get(id);
    }

}
