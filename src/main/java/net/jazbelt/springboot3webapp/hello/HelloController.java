package net.jazbelt.springboot3webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello webapp!";
    }

    @GetMapping
    @ResponseBody
    public String htmlHello() {
        return """
                <!doctype heml>
                <html>
                    <head>
                        <title>Webapp test HTML</title>
                    <body>
                    <h1>Hello world from HTML!</h1>
                    </body>
                </html>
                """;
    }

    @RequestMapping("/view")
    public String jspHello() {
        return "hello";
    }
}
