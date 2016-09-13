package main.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.model.InputNumbers;

@Controller
public class HelloWorldRest
{

  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String index(Model model)
  {
    model.addAttribute("inputNumbers", new InputNumbers());
    return "index";
  }
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String calculate(
      @RequestParam(value = "firstNumber", required = true) String firstNumber,
      @RequestParam(value = "secondNumber", required = true) String secondNumber)
  {
    System.out.println(firstNumber);
    return "index";
  }
  
  
  @RequestMapping(value = "/addNumbers", method = RequestMethod.POST)
  public String addEmployee(@ModelAttribute InputNumbers num,Model model){
    
   int aa= num.getFirstNumber()+num.getSecondNumber();
   model.addAttribute("sum", aa);
    return "index";
  }
}