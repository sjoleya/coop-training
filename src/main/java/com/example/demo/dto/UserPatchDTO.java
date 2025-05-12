package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserPatchDTO {

    @Schema(description = "User name", example = "Alice", required = false)
    private String name;

    @Schema(description = "User email", example = "alice@example.com", required = false)
    private String email;

    @Schema(description = "User password", example = "newSecurePassword123", required = false)
    private String password;
}
