package com.thoughtworks.midquiz.midquiz.Controller;

import com.thoughtworks.midquiz.midquiz.Model.Education;
import com.thoughtworks.midquiz.midquiz.Model.User;
import com.thoughtworks.midquiz.midquiz.Serveice.GetEducationByIdService;
import com.thoughtworks.midquiz.midquiz.Serveice.GetUserByIdServeice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GetEduByIdController {


    private final GetEducationByIdService getEducationByIdService;

    public GetEduByIdController(GetEducationByIdService getEducationByIdService) {
        this.getEducationByIdService = getEducationByIdService;
    }

    // GET /Users/1/Educations
    @GetMapping("/users/{id}/educations")
    public List<Education> getEducationByIdRestful(@PathVariable("id") long id) {
        return getEducationByIdService.getEducationById(id);
    }

    // POST /Users/user_id/educations
    @PostMapping("/users/user_{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Education education,@PathVariable long id) {
        System.out.println("++successful create new education info");
        getEducationByIdService.createEducation(education,id);
    }
}
