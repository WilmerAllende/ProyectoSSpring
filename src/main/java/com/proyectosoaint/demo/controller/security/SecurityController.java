package com.proyectosoaint.demo.controller.security;

import com.proyectosoaint.demo.entity.general.Constante;
import com.proyectosoaint.demo.entity.general.ResponseLoginDTO;
import com.proyectosoaint.demo.entity.general.UserCsv;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SecurityController {
    
    private static final String SAMPLE_CSV_FILE_PATH = "./Credenciales.csv";
    
    /*@Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration}")
    private int expiration;*/

    @PostMapping("user")
    public ResponseLoginDTO login(@RequestBody UserCsv usuario) {
            ResponseLoginDTO response = new ResponseLoginDTO();

            try {

                    boolean validaCredenciales = leerCredenciales(usuario.getUser(), usuario.getPass());

                    if (validaCredenciales) {

                            String token = getJWTToken(usuario.getUser());

                            response.setTipoMensaje("debug");
                            response.setMensaje("Logueo exitoso");
                            response.setToken(token);


                    } else {
                            response.setTipoMensaje("info");
                            response.setMensaje("datos incorrectos en el logueo");
                    }


            } catch (Exception e) {

                    response.setTipoMensaje("error");
                    response.setMensaje("error");

            } finally {
                    response.setFechayHora(java.util.Calendar.getInstance().getTime());
                    response.setUsuario(usuario.getUser());
            }
            return response;

    }

    private String getJWTToken(String username) {
            // String secretKey = SECRET;
            String secretKey = Constante.scretToken;
            Integer expirationToken = Constante.tiempoToken;
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

            String token = Jwts.builder().setId("softtekJWT").setSubject(username)
                            .claim("authorities",
                                            grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                            .setIssuedAt(new Date(System.currentTimeMillis()))
                            //.setExpiration(new Date(System.currentTimeMillis() + 600000))
                            .setExpiration(new Date(new Date().getTime() + expirationToken * 1000))
                            .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

            return "Bearer " + token;
    }

    private boolean leerCredenciales(String username, String pwd) throws IOException {

            boolean valida = false;
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("USUARIO", "CONTRASENIA")
                    .withIgnoreHeaderCase()
                    .withTrim());

            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by the names assigned to each column
                String user = csvRecord.get("USUARIO");
                String contra = csvRecord.get("CONTRASENIA");

                if (username.equalsIgnoreCase(user) && pwd.equalsIgnoreCase(contra)) {
                    valida = true;
                    break;
                }
            }

            return valida;

    }
}
