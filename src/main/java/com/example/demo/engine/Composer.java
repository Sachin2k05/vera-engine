package com.example.demo.engine;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;

@Service
public class Composer {

    public Response compose(Input input) {

        String category = input.category.name;
        String trigger = input.trigger.type;
        int search = input.trigger.searchCount;

        // 🔥 1. CUSTOMER LOGIC (HIGHEST PRIORITY)
        if (input.customer != null && "inactive".equals(input.customer.segment)) {
            return new Response(
                "Win back inactive customers with a ₹199 offer now?",
                "Start campaign",
                "system",
                "reactivation",
                "Customer inactivity detected"
            );
        }

        // 🔥 2. CATEGORY → SERVICE MAPPING
        String service = "services";

        if ("dentist".equals(category)) service = "dental checkups";
        else if ("gym".equals(category)) service = "fitness plans";
        else if ("salon".equals(category)) service = "grooming services";
        else if ("restaurant".equals(category)) service = "dining options";
        else if ("pharmacy".equals(category)) service = "medicines";

        // 🔥 3. CATEGORY-SPECIFIC SPIKE LOGIC

        if ("dentist".equals(category) && "spike".equals(trigger) && search > 100) {
            return new Response(
                search + " people nearby searched for dental checkups. Launch ₹299 cleaning offer now to capture demand?",
                "Send offer",
                "system",
                "dentist_spike",
                "High demand detected from " + search + " recent searches"
            );
        }

        if ("gym".equals(category) && "spike".equals(trigger) && search > 100) {
            return new Response(
                search + " people nearby searched for gyms. Launch ₹999 membership now to capture demand?",
                "Send offer",
                "system",
                "gym_spike",
                "High demand detected from " + search + " recent searches"
            );
        }

        if ("salon".equals(category) && "spike".equals(trigger) && search > 100) {
            return new Response(
                search + " people nearby searched for salons. Offer ₹499 grooming package now to attract nearby customers?",
                "Send offer",
                "system",
                "salon_spike",
                "High demand detected from " + search + " recent searches"
            );
        }

        if ("restaurant".equals(category) && "spike".equals(trigger) && search > 100) {
            return new Response(
                search + " people nearby searched for restaurants. Launch ₹199 combo offer now to boost orders?",
                "Send offer",
                "system",
                "restaurant_spike",
                "Food demand spike detected"
            );
        }

        if ("pharmacy".equals(category) && "spike".equals(trigger) && search > 100) {
            return new Response(
                search + " people nearby searched for medicines. Promote essential items now to meet demand?",
                "Send offer",
                "system",
                "pharmacy_spike",
                "Healthcare demand spike detected"
            );
        }

        // 🔥 4. GENERAL SPIKE
        if ("spike".equals(trigger) && search > 100) {
            return new Response(
                search + " people nearby searched for " + service + ". Launch ₹299 offer now to capture demand?",
                "Send offer",
                "system",
                "spike_offer",
                "High demand detected from " + search + " recent searches"
            );
        }

        // 🔥 5. DIP LOGIC
        if ("dip".equals(trigger)) {
            return new Response(
                "Your bookings dropped this week. Bring customers back with a ₹199 offer now?",
                "Start campaign",
                "system",
                "dip_recovery",
                "Performance dip detected"
            );
        }

        // 🔥 6. DEFAULT
        return new Response(
            "Customers nearby are active. Engage them with a new offer now?",
            "Send message",
            "system",
            "default",
            "General engagement opportunity"
        );
    }
}