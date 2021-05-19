package com.thoughtworks.midquiz.midquiz.Controller;

import com.thoughtworks.midquiz.midquiz.Model.User;
import com.thoughtworks.midquiz.midquiz.Model.UserTest;
import com.thoughtworks.midquiz.midquiz.Serveice.GetUserByIdService;
import com.thoughtworks.midquiz.midquiz.exception.NotFoundException;
import com.thoughtworks.midquiz.midquiz.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class GetUserByIdController {
    
    private final GetUserByIdService getNameByIdServeice;

    private final UserJpaRepo userJpaRepo;

    // GET /Users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return getNameByIdServeice.getAllUsers();
    }

    // GET /Users/1
    @GetMapping("/{id}")
    public User getUserByIdRestful(@PathVariable("id") @Min((long)1)long id) {
        User User = getNameByIdServeice.getUserById(id);
        if (User == null) {
            throw new NotFoundException("User not found");
        }
        return User;
    }

    // POST /Users
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        getNameByIdServeice.createUser(user);
    }

    @PostMapping("/JPA")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserTest user) {
        userJpaRepo.save(user);
    }


    
}
