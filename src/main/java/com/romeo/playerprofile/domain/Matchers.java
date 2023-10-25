package com.romeo.playerprofile.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "matchers")
@NoArgsConstructor
@Data
public class Matchers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "matchers", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private Level level;

    @OneToOne(mappedBy = "matchers", cascade = CascadeType.ALL)
    @JsonIgnore
    private Has has;

    @OneToOne(mappedBy = "matchers", cascade = CascadeType.ALL)
    @JsonIgnore
    private DoesNotHave doesNotHave;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "matchers")
    private CampaignData campaignData;

}
