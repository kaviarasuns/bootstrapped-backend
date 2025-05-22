package com.kaviarasu.bootstrapped_backend.Q69.controllers;

import com.kaviarasu.bootstrapped_backend.Q69.services.IWebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @Autowired
    private IWebhookService webhookService;

    //Add your APIs here
}