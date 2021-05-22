/**
 * 
 */
package io.project.cryptography.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author vipink
 *
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(final Locale locale, final Model model) {
        return "index";
    }
    
    @GetMapping("/index")
    public String home(final Locale locale, final Model model) {
        return "index";
    }
    
    @GetMapping("/about-us")
    public String about(final Locale locale, final Model model) {
        return "about";
    }
    
    @GetMapping("/contact-us")
    public String contact(final Locale locale, final Model model) {
        return "contact";
    }
    
    @GetMapping("/chat-bot")
    public String chat(final Locale locale, final Model model) {
        return "chat";
    }
}
