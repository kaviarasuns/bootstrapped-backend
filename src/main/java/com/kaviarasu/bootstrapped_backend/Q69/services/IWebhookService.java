package com.kaviarasu.bootstrapped_backend.Q69.services;

import com.kaviarasu.bootstrapped_backend.Q69.dtos.Webhook;

import java.util.List;


public interface IWebhookService {
    Webhook createWebhook(String url, List<String> events);
    Boolean deleteWebhook(String webhookId);
    Webhook updateWebhook(String updatedUrl, List<String> events, String webhookId);
}

