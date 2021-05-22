package io.project.cryptography.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);

}
