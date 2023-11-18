package com.project.Security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public static String hashPassword(String password) {
        try {
            // Usando SHA-256 como algoritmo de hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Obtendo a representação de bytes da senha
            byte[] encodedHash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));

            // Convertendo bytes para hexadecimal
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
            // Tratar a exceção adequadamente, como lançar uma exceção personalizada ou retornar null
            return null;
        }
    }
    public static boolean checkPassword(String password, String hashedPassword) {
        // Aplica o mesmo algoritmo de hash à senha fornecida pelo usuário
        String hashedInput = hashPassword(password);

        // Compara o resultado com a senha armazenada no banco de dados
        return hashedInput != null && hashedInput.equals(hashedPassword);
    }
}
