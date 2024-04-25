package net.jazbelt.springboot3webapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    public String getLogin() {
        return "login";
    }

    @PostMapping
    public String postLogin(@RequestParam String name,
                            @RequestParam String password,
                            ModelMap model) {
        model.put("name", name);
        model.put("password", password);

        logger.info(model.toString());

        return "welcome";
    }
}
