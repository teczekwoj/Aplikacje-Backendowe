package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.Map;

@Controller
public class UsersController {

    private final Map<Long, UserEntity> users = new HashMap<>();

    //Create default users map
    @PostConstruct
    private final void Create() {

        users.put(1L, new UserEntity(1L, "Stanislaw", "stachu@op.pl"));
        users.put(2L, new UserEntity(2L, "Sylwia", "sylwia@xoxo.com"));
        users.put(3L, new UserEntity(3L, "Jurek", "jureczek123@wp.pl"));
    }
    //Get all users     //api/users?page-number=1&page-size=20
    @RequestMapping("/api/users")
    @ResponseBody

    public Object ApiUsers(
            @RequestParam(required = false) Long pageNumber,
            @RequestParam(required = false) Long pageSize

    ) {
        if (pageNumber < 1)
        {
            return ("min wartość pageNumber to 1");
        }
        if ( pageSize > 100 || pageSize < 1){
            return  ("wartosc pageSzie ma byc miedzy 1 a 100");
        }

        return users;
    }





}

