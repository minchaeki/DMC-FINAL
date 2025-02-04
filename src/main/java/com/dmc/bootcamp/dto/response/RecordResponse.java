package com.dmc.bootcamp.dto.response;

import com.dmc.bootcamp.domain.Record;
import lombok.Getter;

@Getter
public class RecordResponse {
    private Long recordId;
    private String foodId;
    private String image;
    private String content;
    private  float score;
    private String userId;

    public RecordResponse(Record record){
        this.recordId = record.getRecordId();
        this.foodId = record.getFoodId();
        this.image=record.getImage();
        this.content=record.getContent();
        this.score=record.getScore();
        this.userId=record.getAppUser().getUserId();
    }

}
