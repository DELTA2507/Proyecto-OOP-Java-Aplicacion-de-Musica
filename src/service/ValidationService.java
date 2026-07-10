package service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class ValidationService {

    private static final String DEFAULT_AVATAR = "default_avatar.png";

    private List<String> nacionalidadesPermitidas = Arrays.asList(
            "Costa Rica",
            "Panama",
            "Nicaragua",
            "Honduras",
            "El Salvador",
            "Guatemala",
            "Mexico",
            "Colombia",
            "Estados Unidos",
            "Canada",
            "España"
    );

    public boolean esMayorDeEdad(LocalDate birthDate) {
        if (birthDate == null) {
            return false;
        }

        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }

    public boolean nacionalidadPermitida(String nationality) {
        if (nationality == null) {
            return false;
        }

        for (String permitida : nacionalidadesPermitidas) {
            if (permitida.equalsIgnoreCase(nationality.trim())) {
                return true;
            }
        }

        return false;
    }

    public boolean passwordValida(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8 || password.length() > 12) {
            return false;
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (int i = 0; i < password.length(); i++) {
            char caracter = password.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(caracter)) {
                tieneNumero = true;
            } else {
                tieneEspecial = true;
            }
        }

        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneEspecial;
    }

    public boolean passwordsCoinciden(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            return false;
        }

        return password.equals(confirmPassword);
    }

    public LocalDate parseFechaNacimiento(String birthDateText) {
        try {
            return LocalDate.parse(birthDateText);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public String normalizarAvatar(String avatar) {
        if (avatar == null || avatar.trim().isEmpty()) {
            return DEFAULT_AVATAR;
        }

        return avatar.trim();
    }

    public List<String> getNacionalidadesPermitidas() {
        return nacionalidadesPermitidas;
    }
}