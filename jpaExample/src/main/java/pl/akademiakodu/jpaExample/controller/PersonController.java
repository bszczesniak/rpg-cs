package pl.akademiakodu.jpaExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.jpaExample.dao.PersonDao;
import pl.akademiakodu.jpaExample.model.Person;

@Controller
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/person/add")
    public String add(PersonDao personDao, ModelMap modelMap) {
        return "person/add";
    }
    @RequestMapping("/person/{id}")
    public String showById(@PathVariable Long id, ModelMap modelMap)
    {
        if (personDao.findById(id).isPresent()) {
            modelMap.addAttribute("person", personDao.findById(id).get());
            return "person/all";
        }
        else {
            return "person/add";
        }

    }

    @RequestMapping("/person/delete/{id}")
    public String removeById(@PathVariable Long id, ModelMap modelMap)
    {
        if (personDao.findById(id).isPresent()) {
            personDao.deleteById(id);
            return "person/all";
        }
        else {
            return "person/all";
        }

    }


    @RequestMapping ("/person/all")
    public String showAll (@ModelAttribute Person person, ModelMap modelMap) {
        modelMap.addAttribute("person", personDao.findAll());
        return "person/all";
    }

    @PostMapping("/person/create")
    public String show(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        personDao.save(person);
        redirectAttributes.addFlashAttribute("message", "Person doesn't exist");
        return "redirect:/person/"+person.getId();
    }

    @GetMapping("/person/surname/{surname}")
    public String showBySurname(@PathVariable String surname, ModelMap modelMap) {
        modelMap.addAttribute("person", personDao.findBySurname(surname));

            return "person/all";


    }


//    @RequestMapping("/person/{surname}")
//    public String showBySurname(@PathVariable String surname, ModelMap modelMap)
//    {
//        if (personDao.findById(id).isPresent()) {
//            modelMap.addAttribute("person", personDao.);
//            return "person/show";
//        }
//        else {
//            return "person/add";
//        }
}
