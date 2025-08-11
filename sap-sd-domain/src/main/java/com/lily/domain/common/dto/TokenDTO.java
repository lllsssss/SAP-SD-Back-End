package com.lily.domain.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lll
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class TokenDTO {

    private String token;

    private CurrentLoginUserDTO currentUser;

}
