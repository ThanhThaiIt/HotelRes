package com.HotelRes.HotelRes.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthenRequest(
        @NotNull(message = "Email Không được Null")
                @NotEmpty(message = "Email không đc phép rỗng")
                @Email(message = "Không phải định dạng email")
        String email,
        @NotNull(message = "password Không được Null")
        @NotEmpty(message = "password không đc phép rỗng")
        String password) {
}
