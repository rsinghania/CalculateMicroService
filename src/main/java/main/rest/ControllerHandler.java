package main.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import main.model.InputNumbers;

@Controller
public class ControllerHandler
{
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String index(Model model)
  {
    model.addAttribute("inputNumbers", new InputNumbers());
    return "index";
  }
  
  @RequestMapping(value = "/addNumbers", method = RequestMethod.POST)
  public String addEmployee(@ModelAttribute InputNumbers num,Model model){
    
    RestTemplate restTemplate = new RestTemplate();
    Integer sum= restTemplate.getForObject("http://localhost:9090/addNumbers", Integer.class);
    model.addAttribute("sum", sum);
    return "index";
  }
}