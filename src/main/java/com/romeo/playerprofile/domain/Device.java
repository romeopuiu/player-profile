package com.romeo.playerprofile.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Entity
@Table(name = "device")
@NoArgsConstructor
@Data
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "firmware")
    private String firmware;

    @ToString.Exclude
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "playerId")
    private PlayerProfile playerProfile;
}
