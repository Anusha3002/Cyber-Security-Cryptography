package io.project.cryptography.web.controller;

import io.project.cryptography.persistence.model.User;
import io.project.cryptography.service.CaeserCipherService;
import io.project.cryptography.web.dto.CaeserCipherDto;
import io.project.cryptography.web.util.GenericResponse;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaesarCipherRestController {

	private final static Logger LOGGER = LoggerFactory.getLogger("io.cryptograpy");
	 
	@Autowired
	private CaeserCipherService caeserCipherService;
	
  
    @PostMapping("/caesar-cipher/add")
    public GenericResponse addData(final HttpServletRequest request, final CaeserCipherDto caeser) {
        LOGGER.debug("Encrypt my information: {}", caeser);
        System.out.println(caeser);
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);

        try {
        	caeserCipherService.add(caeser, user);
        } catch (Throwable e) {
        	e.printStackTrace();
        }
        return new GenericResponse("success"); 
    }
    
    @PostMapping("/caesar-cipher/update")
    public GenericResponse updateData(final HttpServletRequest request, final CaeserCipherDto caeser) {
        LOGGER.debug("Encrypt my information: {}", caeser);
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
        	caeserCipherService.update(caeser, user);
        } catch (Throwable e) {
        	e.printStackTrace();
        }
        return new GenericResponse("success"); 
    }
 }
