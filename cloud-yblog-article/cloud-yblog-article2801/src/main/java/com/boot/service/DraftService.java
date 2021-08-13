package com.boot.service;

import com.boot.pojo.Article;
import com.boot.pojo.Draft;

import java.util.List;

public interface DraftService {


    List<Draft> selectAllDraft(String username);

    int selectDraftCount(String username);

    Draft selectDraftByID(long id);

    void deleteDraftByID(long id);

    void publishDraft(Article article, long draftid);

    void modifyDraft(Draft draft);

    void addDraft(Draft draft);

    List<Draft> selectDraftByTitle(String title);
}
