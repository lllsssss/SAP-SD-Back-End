package com.lily.admin.controller.common;

import cn.hutool.core.util.StrUtil;
import com.lily.admin.customize.service.login.LoginService;
import com.lily.admin.customize.service.login.UserApplicationService;
import com.lily.admin.customize.service.login.command.LoginCommand;
import com.lily.common.config.SapSdConfig;
import com.lily.common.core.dto.ResponseDTO;
import com.lily.domain.common.dto.CurrentLoginUserDTO;
import com.lily.domain.common.dto.TokenDTO;
import com.lily.domain.system.menu.MenuApplicationService;
import com.lily.infrastructure.annotations.ratelimit.RateLimit;
import com.lily.infrastructure.annotations.ratelimit.RateLimit.CacheType;
import com.lily.infrastructure.annotations.ratelimit.RateLimit.LimitType;
import com.lily.infrastructure.annotations.ratelimit.RateLimitKey;
import com.lily.infrastructure.user.AuthenticationUtils;
import com.lily.infrastructure.user.web.SystemLoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lll
 * @version 1.0
 * 首页+登录
 */
@Tag(name = "登录API",description = "登陆相关接口")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final SapSdConfig sapSdConfig;

    private final LoginService loginService;

    private final MenuApplicationService menuApplicationService;

    private final UserApplicationService userApplicationService;

    /**
     * 访问首页，提示语
     */
    @Operation(summary = "首页")//在 API 文档中为该接口添加简短描述（显示为“首页”）
    @GetMapping("/")//将 HTTP GET 请求映射到根路径 /，触发 index()方法。
    @RateLimit(key = RateLimitKey.TEST_KEY, time = 10, maxCount = 5, cacheType = CacheType.Map,
        limitType = LimitType.GLOBAL)
    public String index() {
        return StrUtil.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。",
            sapSdConfig.getName(), sapSdConfig.getVersion());
    }

    /**
     * 登录方法
     *
     * @param loginCommand 登录信息
     * @return 结果
     */
    @Operation(summary = "登录")
    @PostMapping("/login")
    public ResponseDTO<TokenDTO> login(@RequestBody LoginCommand loginCommand) {
        // 生成令牌
        String token = loginService.login(loginCommand);
        SystemLoginUser loginUser = AuthenticationUtils.getSystemLoginUser();
        CurrentLoginUserDTO currentUserDTO = userApplicationService.getLoginUserInfo(loginUser);

        return ResponseDTO.ok(new TokenDTO(token, currentUserDTO));
    }

}
