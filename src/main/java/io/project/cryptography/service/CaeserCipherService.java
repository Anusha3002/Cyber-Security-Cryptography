/**
 * 
 */
package io.project.cryptography.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import io.project.cryptography.ceaser.cipher.CaesarCipherProcessor;
import io.project.cryptography.persistence.dao.CaeserCipherRepository;
import io.project.cryptography.persistence.model.CaeserCipher;
import io.project.cryptography.persistence.model.User;
import io.project.cryptography.web.dto.CaeserCipherDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vipink
 *
 */
@Service
public class CaeserCipherService {

	@Autowired
	private CaeserCipherRepository caeserCipherRepository;
	
	public String process(int shift, String plaintext) {
		return new CaesarCipherProcessor().shiftText(shift, plaintext);
	}
	
	public List<CaeserCipher> findByUserId (long userId) {
		return caeserCipherRepository.findByUserId(userId); 
	}

	public Optional<CaeserCipher> findById(long id) {
		return caeserCipherRepository.findById(id);
	}
	
	public void delete(long id) {
		caeserCipherRepository.deleteById(id);
	}

	public CaeserCipher update(CaeserCipherDto caeser, User user) {
		
		// TODO Auto-generated method stub
		CaeserCipher caeserEntity = new CaeserCipher();
		caeserEntity.setTitle(caeser.getTitle());
		caeserEntity.setText(caeser.getText());
		caeserEntity.setShift(caeser.getShift());
		caeserEntity.setUser(user);
		String shiftedText = process (caeser.getShift(),caeser.getText() );
		caeserEntity.setCaesertext(shiftedText);
		caeserEntity.setModified(new Date());
		caeserEntity.setId(caeser.getId());
		return caeserCipherRepository.save(caeserEntity);
		
	}
	
	public CaeserCipher add(CaeserCipherDto caeser, User user) {
		
		// TODO Auto-generated method stub
		CaeserCipher caeserEntity = new CaeserCipher();
		caeserEntity.setTitle(caeser.getTitle());
		caeserEntity.setText(caeser.getText());
		caeserEntity.setShift(caeser.getShift());
		caeserEntity.setUser(user);
		String shiftedText = process (caeser.getShift(),caeser.getText() );
		caeserEntity.setCaesertext(shiftedText);
		
		caeserEntity.setCreated(new Date());
		caeserEntity.setModified(new Date());
		
		return caeserCipherRepository.save(caeserEntity);
		
	}
}
