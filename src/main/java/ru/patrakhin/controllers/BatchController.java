package ru.patrakhin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.patrakhin.dao.PersonDAO;


@Controller
@RequestMapping("/test-batch-update")
public class BatchController {
    private final PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index() { //share string where 2 button
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBatch() { // action to click on first button
        personDAO.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch() { // action to click on second button
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }
}
