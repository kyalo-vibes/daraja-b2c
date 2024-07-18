package com.kyalo.daraja_b2c.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class AccessTokenResponse {

    @JsonProperty
    private String access_token;
    @JsonProperty
    private String expires_in;

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }
}
