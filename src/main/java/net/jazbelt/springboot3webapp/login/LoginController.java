package net.jazbelt.springboot3webapp.login;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
@RequestMapping("/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final AuthService authService;

    @Autowired
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLogin(ModelMap model) {
        model.put("loginData", new LoginData());
        return "login";
    }

    @PostMapping
    public String postLogin(ModelMap model,
                            @Valid LoginData loginData,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        String name = loginData.getUser();
        String password = loginData.getPassword();

        if (authService.authenticate(name, password)) {
            model.put("name", name);
            model.put("password", password);

            logger.info(model.toString());

            return "welcome";
        }

        model.put("error", "Invalid user name or password");
        return "login";
    }
}
