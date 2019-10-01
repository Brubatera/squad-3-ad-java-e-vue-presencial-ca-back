package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO save(@RequestBody UserDTO user) throws MessageException {
        return userService.save(user);
    }

    @GetMapping("/{code}")
    public User findByCode(@PathVariable String code) throws MessageException {
        return userService.findByCode(code);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", required = true, paramType = "header")
    })

    @PutMapping
    public UserDTO edit(@RequestBody UserDTO user) throws MessageException {
        return userService.update(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable Long userId) throws MessageException {
        return userService.delete(userId);
    }

    @GetMapping("/validate/{code}")
    public String validate(@PathVariable String code) throws MessageException {
        return userService.validateCode(code);
    }
}
