package com.kaviarasu.bootstrapped_backend.Q69.dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WebhookDto {
    String url;
    List<String> events;
}

