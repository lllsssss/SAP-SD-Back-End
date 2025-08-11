package com.lily.domain.common.dto;

import com.lily.domain.system.user.dto.UserDTO;
import java.util.Set;
import lombok.Data;

/**
 * @author lll
 * @version 1.0
 */
@Data
public class CurrentLoginUserDTO {

    private UserDTO userInfo;
    private String roleKey;
    private Set<String> permissions;


}
