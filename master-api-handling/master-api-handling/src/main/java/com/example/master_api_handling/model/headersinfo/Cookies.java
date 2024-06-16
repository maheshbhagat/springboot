package com.example.master_api_handling.model.headersinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cookies {

    @JsonProperty("ext_name")
    public String extName;

    @JsonProperty("connect.sid")
    public String connectSid;

    @JsonProperty("foo")
    public String foo;
}
