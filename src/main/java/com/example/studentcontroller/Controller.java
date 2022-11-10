package com.example.studentcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
   static ArrayList<Student> list = new ArrayList<Student>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // http://localhost:8080/users?name=()&age=()
    @GetMapping("/users")
    public String addStudent1(@RequestParam String name, @RequestParam int age){
        list.add(new Student(name, age));
        String res = "";
        for (int i = 0 ; i < list.size() ; i++){
            res += list.get(i).getName() + list.get(i).getAge() + "\n";
        }
        String json = gson.toJson(list);
        return json;
    }

    // http://localhost:8080/users/()/()
    @GetMapping("/users/{name}/{age}")
    public String addStudent2(@PathVariable("name") String name, @PathVariable("age") int age){
        list.add(new Student(name, age));
        String res = "";
        for (int i = 0 ; i<list.size(); i++){
            res += list.get(i).getName() + list.get(i).getAge() + "\n";
        }
        String json = gson.toJson(list);
        return json;
    }

    // chọn raw và chọn json và nhập dưới
    /*
    {
    "name":"le",
    "age":21,
    "age":22,
    "name":"thanh"
    }
     */
    @GetMapping("/user")
    public Object addStudent3(@RequestBody Student student){
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        list.add(student1);
        String json = gson.toJson(list);
        return json;
    }
}
