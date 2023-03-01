package com.project.questapp.services;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.questapp.entities.RefreshToken;
import com.project.questapp.entities.User;
import com.project.questapp.repository.RefreshTokenRepository;

@Service
public class ReFreshTokenService {

	@Value("${refresh.token.expires.in}")
	Long expireSeconds;
	
	private RefreshTokenRepository reFreshTokenRepository;

	public ReFreshTokenService(RefreshTokenRepository reFreshTokenRepository) {
		super();
		this.reFreshTokenRepository = reFreshTokenRepository;
	}
	
	public String  createRefreshToken(User user) {
		RefreshToken token = reFreshTokenRepository.findByUserId(user.getId());
		if(token == null) {
			token =	new RefreshToken();
			token.setUser(user);
		}
		token.setToken(UUID.randomUUID().toString());
		token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
		reFreshTokenRepository.save(token);
		return token.getToken();
		
		
	}
	
	public RefreshToken getByUser(Integer userId) {
		return reFreshTokenRepository.findByUserId(userId);	
	}
	
	
	
	public boolean isRefreshTokenExpired(RefreshToken token) {
		
		return token.getExpiryDate().before(new Date());
	}
}
