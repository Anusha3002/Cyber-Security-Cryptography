package io.project.cryptography.web.controller;

import io.project.cryptography.persistence.model.CaeserCipher;
import io.project.cryptography.persistence.model.User;
import io.project.cryptography.service.CaeserCipherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaesarCipherWebController {

	private final static Logger LOGGER = LoggerFactory.getLogger("io.cryptograpy");
	 
	@Autowired
	private CaeserCipherService caeserCipherService;
	
    
	
    @GetMapping("/caesar-cipher")
    public ModelAndView login(final HttpServletRequest request, final ModelMap model) {
        Locale locale = request.getLocale();

        List<CaeserCipher> tasks = new ArrayList<CaeserCipher>();
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CaeserCipher> caeserCiphers = caeserCipherService.findByUserId(user.getId());
        model.addAttribute("caeserCiphers", caeserCiphers);
        return new ModelAndView("caeserCipher", model);
    }
    
    @GetMapping("/caesar-cipher/add")
    public ModelAndView add(final HttpServletRequest request, final ModelMap model) {
    	CaeserCipher cc = new CaeserCipher();
        model.addAttribute("caeserCipher", cc);
        return new ModelAndView("caeserCipherAdd", model);
    }
    
    @GetMapping("/caesar-cipher/decrypt")
    public ModelAndView decrypt(final HttpServletRequest request, final ModelMap model) {
    	CaeserCipher cc = new CaeserCipher();
        model.addAttribute("caeserCipher", cc);
        return new ModelAndView("caeserCipherdecrypt", model);
    }
    
    @GetMapping("/caesar-cipher/decrypt/{id}")
    public ModelAndView decrypt(final HttpServletRequest request, @PathVariable("id") long id, final ModelMap model) {
    	Optional<CaeserCipher> optionalCaser= caeserCipherService.findById(id);
    	if (optionalCaser.isPresent()) {
    		 model.addAttribute("caeserCipher", optionalCaser.get());
    	}
        return new ModelAndView("caeserCipherdecrypt", model);
    }
    
    @GetMapping("/caesar-cipher/update/{id}")
    public ModelAndView update(final HttpServletRequest request, @PathVariable("id") long id, final ModelMap model) {
    	Optional<CaeserCipher> optionalCaser= caeserCipherService.findById(id);
    	if (optionalCaser.isPresent()) {
    		 model.addAttribute("caeserCipher", optionalCaser.get());
    	}
        return new ModelAndView("caeserCipherUpdate", model);
    }
    
    @GetMapping("/caesar-cipher/delete/{id}")
    public ModelAndView delete(final HttpServletRequest request, @PathVariable("id") long id , final ModelMap model) {
    	caeserCipherService.delete(id);
        return new ModelAndView("redirect:/caesar-cipher", model);
    }
}
