package com.sjdevs.project_neotools;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {
    
    @Test
    public void testBCrypt() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String password = "1234";
        String storedHash = "$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6";
        
        boolean matches = encoder.matches(password, storedHash);
        System.out.println("\n=== BCrypt Test ===");
        System.out.println("Password: " + password);
        System.out.println("Stored Hash: " + storedHash);
        System.out.println("MATCHES: " + matches);
        System.out.println("Hash length: " + storedHash.length());
        
        // Generar un nuevo hash para comparar
        String newHash = encoder.encode(password);
        System.out.println("New Hash: " + newHash);
        System.out.println("New Hash Matches: " + encoder.matches(password, newHash));
        System.out.println("====================\n");
    }
}
