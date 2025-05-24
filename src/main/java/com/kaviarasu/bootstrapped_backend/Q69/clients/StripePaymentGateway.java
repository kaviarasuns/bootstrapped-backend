package com.kaviarasu.bootstrapped_backend.Q69.clients;

import com.kaviarasu.bootstrapped_backend.Q69.dtos.Webhook;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StripePaymentGateway {
//    @Value("${stripe.key}")
//    public String apiKey;
//
//    public Webhook createWebhook(String url, List<String> events) {
//        try {
//            Stripe.apiKey = apiKey;
//            WebhookEndpointCreateParams params = WebhookEndpointCreateParams.builder()
//                    .setUrl(url)
//                    .addAllEnabledEvents(events)
//                    .build();
//
//            WebhookEndpoint endpoint = WebhookEndpoint.create(params);
//
//            Webhook webhook = new Webhook();
//            webhook.setId(endpoint.getId());
//            webhook.setSecret(endpoint.getSecret());
//            webhook.setEvents(events);
//            webhook.setUrl(url);
//            webhook.setStatus(WebhookStatus.enabled);
//
//            return webhook;
//        } catch (StripeException e) {
//            throw new RuntimeException("Failed to create webhook: " + e.getMessage());
//        }
//    }
//
//    public Boolean deleteWebhook(String webhookId) {
//        try {
//            Stripe.apiKey = apiKey;
//            WebhookEndpoint endpoint = WebhookEndpoint.retrieve(webhookId);
//            WebhookEndpoint deletedEndpoint = endpoint.delete();
//            return deletedEndpoint.getDeleted();
//        } catch (StripeException e) {
//            throw new RuntimeException("Failed to delete webhook: " + e.getMessage());
//        }
//    }
//
//    public Webhook updateWebhook(String updatedUrl, List<String> events, String webhookId) {
//        try {
//            Stripe.apiKey = apiKey;
//            WebhookEndpointUpdateParams params = WebhookEndpointUpdateParams.builder()
//                    .setUrl(updatedUrl)
//                    .addAllEnabledEvents(events)
//                    .build();
//
//            WebhookEndpoint endpoint = WebhookEndpoint.retrieve(webhookId);
//            endpoint = endpoint.update(params);
//
//            Webhook webhook = new Webhook();
//            webhook.setId(endpoint.getId());
//            webhook.setSecret(endpoint.getSecret());
//            webhook.setEvents(events);
//            webhook.setUrl(updatedUrl);
//            webhook.setStatus(WebhookStatus.enabled);
//
//            return webhook;
//        } catch (StripeException e) {
//            throw new RuntimeException("Failed to update webhook: " + e.getMessage());
//        }
//    }
}

