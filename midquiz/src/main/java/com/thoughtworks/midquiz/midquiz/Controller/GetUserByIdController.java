package com.thoughtworks.midquiz.midquiz.Controller;

import com.thoughtworks.midquiz.midquiz.Model.User;
import com.thoughtworks.midquiz.midquiz.Serveice.GetUserByIdServeice;
import com.thoughtworks.midquiz.midquiz.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/users")
public class GetUserByIdController {
    
    private final GetUserByIdServeice getNameByIdServeice;

    public GetUserByIdController(GetUserByIdServeice getNameByIdServeice) {
        this.getNameByIdServeice = getNameByIdServeice;
    }

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
        long age = user.getAge();
        System.out.println("++successful create new user");
        getNameByIdServeice.createUser(user);
    }
    
}
