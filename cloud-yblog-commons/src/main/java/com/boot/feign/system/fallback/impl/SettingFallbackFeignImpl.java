package com.boot.feign.system.fallback.impl;

import com.boot.feign.system.fallback.SettingFallbackFeign;
import com.boot.pojo.Setting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SettingFallbackFeignImpl implements SettingFallbackFeign {
    @Override
    public Setting selectUserSetting(String name) {
        return null;
    }
}
