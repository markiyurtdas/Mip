package com.marki.mipan.model;

import java.util.List;

public class Survey {
    private Long survey_id;
    private Long creator_username;
    private String title;
    private String description;
    private long created_date;
    private long end_date;
    private List<String> answers;
}
