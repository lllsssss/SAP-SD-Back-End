package com.lily.infrastructure.user.app;

import com.lily.infrastructure.user.base.BaseLoginUser;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lll
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class AppLoginUser extends BaseLoginUser {

    private static final long serialVersionUID = 1L;

    private boolean isVip;


    public AppLoginUser(Long userId, Boolean isVip, String cachedKey) {
        this.cachedKey = cachedKey;
        this.userId = userId;
        this.isVip = isVip;
    }


}

