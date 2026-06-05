package com.project.Security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public static String hashPassword(String password) {
        try {
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            byte[] encodedHash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));

         
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
         
            return null;
        }
    }
    public static boolean checkPassword(String password, String hashedPassword) {
        // Aplica o mesmo algoritmo de hash à senha fornecida pelo usuário
        String hashedInput = hashPassword(password);

      
        return hashedInput != null && hashedInput.equals(hashedPassword);
    }
}
