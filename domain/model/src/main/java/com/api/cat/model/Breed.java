package com.api.cat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Breed{
    public Weight weight;
    public String id;
    public String name;
    public String cfa_url;
    public String vetstreet_url;
    public String vcahospitals_url;
    public String temperament;
    public String origin;
    public String country_codes;
    public String country_code;
    public String description;
    public String life_span;
    public int indoor;
    public int lap;
    public String alt_names;
    public int adaptability;
    public int affection_level;
    public int child_friendly;
    public int dog_friendly;
    public int energy_level;
    public int grooming;
    public int health_issues;
    public int intelligence;
    public int shedding_level;
    public int social_needs;
    public int stranger_friendly;
    public int vocalisation;
    public int experimental;
    public int hairless;
    public int natural;
    public int rare;
    public int rex;
    public int suppressed_tail;
    public int short_legs;
    public String wikipedia_url;
    public int hypoallergenic;
    public String reference_image_id;
    public Image image;
}

