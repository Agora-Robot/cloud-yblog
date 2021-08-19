package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.DraftFallbackFeign;
import com.boot.pojo.Draft;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DraftFallbackFeignImpl implements DraftFallbackFeign {


    @Override
    public List<Draft> selectDraftByTitle(String title) {
        return null;
    }

    @Override
    public List<Draft> selectAllDraft(String username) {
        return null;
    }

    @Override
    public int selectDraftCount(String username) {
        return 0;
    }

    @Override
    public Draft selectDraftByID(long draftid) {
        return null;
    }
}
