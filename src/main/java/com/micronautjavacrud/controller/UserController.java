package com.micronautjavacrud.controller;

import com.micronautjavacrud.model.User;
import com.micronautjavacrud.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<User> createUser(@Body @Valid  User user) {
        return HttpResponse.created(userService.createUser(user));
    }

    @Get
    public HttpResponse<List<User>> getAllUsers() {
        return HttpResponse.ok(userService.getAllUsers());
    }

    @Get("/{id}")
    public HttpResponse<User> getUser(@PathVariable int id) {
        return HttpResponse.ok(userService.getUser(id));
    }

    @Put("/{id}")
    public HttpResponse<User> editUser(@PathVariable int id, @Body User user) {
        return HttpResponse.ok(userService.editUser(id, user));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deletetUser(@PathVariable int id) {
        userService.deleteUser(id);
        return HttpResponse.ok();
    }
}
