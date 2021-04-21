package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

//    @GetMapping(value = "")
//    public String index() {
//        List<User> users = userRepository.findAll();
//        System.out.println("############### Find All User (In Console) ###############");
//        System.out.println(users);
//        return "Method GET, Function : index => SHOW data list on page";
//    }


    @GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console) ###############");
        System.out.println(user);

        return "Method Get, Function : show, ID : " + id + " => SHOW data by id on page with path";
    }
//    @GetMapping(value = "")
//    public List<User> index() {
//        List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 18);
//        return users;
//    }

    //    @GetMapping(value = "")
//    public List<User> index() {
//        List<Integer> ages = new ArrayList<Integer>(Arrays.asList(18, 19, 22) );
//        List<User> users = userRepository.findByAgeIn(ages);
//        return users;
//    }
    // Example for findAllByQuery
//    @GetMapping(value = "/test1")
//    public List<User> test1() {
//        return userRepository.findAllByQuery();
//    }
//
//    // Example for findAllByParamsQuery
//    @GetMapping(value = "/test2")
//    public List<User> test2() {
//        return userRepository.findAllByParamsQuery(0, "nakornpathom");
//    }
//
//    // Example for findAllByJpqlQuery
//    @GetMapping(value = "/test3")
//    public List<User> test3() {
//        return userRepository.findAllByJpqlQuery();
//    }
//
//    // Example for findAllByJpqlParamsQuery
//    @GetMapping(value = "/test4")
//    public List<User> test4() {
//        return userRepository.findAllByJpqlParamsQuery(0, "bangkok");
//    }
//
    @GetMapping(value = "")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }

    @GetMapping(value = "/t1")
    public List<User> getAgeByParam(@RequestParam(name = "age") List<Integer> listAge){
        return userService.findByAgeIn(listAge);
    }

    @GetMapping(value = "/t2")
    public List<User> getAgeByParam(@RequestBody Map<String, Object> dataInput) {
        return userService.findByAgeIn((List<Integer>) dataInput.get("age"));
    }

    @GetMapping(value = "/t3")
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/t4")
    public Optional<User> findById(@RequestParam String id){
        return userService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/t5")
    public Page<User> findAllByLimit(@RequestParam String start, @RequestParam String limit, @RequestParam String field){
        return userService.findAllByLimit(Integer.parseInt(start),Integer.parseInt(limit),field);
    }
    @GetMapping(value = "/t6")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city, @RequestParam String active,@RequestParam String age){
        return userService.findByCityAndActiveAndAge(city,Integer.parseInt(active),Integer.parseInt(age));
    }
    @GetMapping(value = "/7")
    public List<User> findAllByQuery(){
        return userService.findAllByQuery();
    }
    @GetMapping(value = "/8")
    public List<User> findAllByParamsQuery(@RequestParam String active, @RequestParam String city){
        return userService.findAllByParamsQuery(Integer.parseInt(active), city);
    }
    @GetMapping(value = "/9")
    public List<User> findAllByJpqlQuery(){
        return userService.findAllByJpqlQuery();
    }
    @GetMapping(value = "/10")
    public List<User> findByCity(@RequestParam String city){
        return userRepository.findByCity(city);
    }
    @GetMapping(value = "/11")
    public List<User> findByMobileAndActive(@RequestParam String mobile, @RequestParam String active){
        return userRepository.findByMobileAndActive(mobile,Integer.parseInt(active));
    }


}







