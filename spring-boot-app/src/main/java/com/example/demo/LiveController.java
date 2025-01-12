package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class LiveController {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @GetMapping("/live")
    public String liveCheck() {
        try (Connection connection = DriverManager.getConnection(databaseUrl)) {
            return "Well done";
        } catch (SQLException e) {
            return "Maintenance";
        }
    }
}

