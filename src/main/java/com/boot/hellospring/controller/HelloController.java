package com.boot.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // localhost:8080/hello
    public String hello(Model model){
        model.addAttribute("data", "김영한!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // localhost:8080/hello-mvc?name=spring
  public String helloMvc(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello-template";
    }

    @GetMapping("hello-string") // localhost:8080/hello-string?name=spring
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api") // localhost:8080/hello-api?name=spring
    @ResponseBody//json이 default임
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static  class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
