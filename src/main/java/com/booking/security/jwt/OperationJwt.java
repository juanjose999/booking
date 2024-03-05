package com.booking.security.jwt;

import com.booking.dto.user.TokenDto;
import com.booking.model.user.User;

public interface OperationJwt {
    TokenDto generateTokenDto(User user);
}
