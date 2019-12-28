package com.marki.mipan.model;

import java.util.List;

public class question {
    private Integer q_id;
    private String q_type;
    private String title;
    private String description;
    private boolean is_required;
    private List<String> check_values;
    private long create_date;
    private long end_date;
}
