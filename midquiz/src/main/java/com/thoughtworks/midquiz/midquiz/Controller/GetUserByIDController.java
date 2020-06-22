package com.thoughtworks.midquiz.midquiz.Controller;

import com.thoughtworks.midquiz.midquiz.Model.User;
import com.thoughtworks.midquiz.midquiz.Serveice.GetUserByIdServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class GetUserByIDController {
    
    private final GetUserByIdServeice getNameByIdServeice;

    public GetUserByIDController(GetUserByIdServeice getNameByIdServeice) {
        this.getNameByIdServeice = getNameByIdServeice;
    }

    // GET /Users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return getNameByIdServeice.getAllUsers();
    }

    // GET /Users/1
    @GetMapping("/{id}")
    public User getUserByIdRestful(@PathVariable("id") long id) {
        User User = getNameByIdServeice.getUserById(id);
       /* if (User == null) {
//      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            throw new UserNotFoundException("User not found");
        }*/
        return User;
    }

    // POST /Users
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User User) {
        System.out.println("++successful create new user");
        getNameByIdServeice.createUser(User);
    }
    
}
