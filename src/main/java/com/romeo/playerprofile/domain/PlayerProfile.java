package com.romeo.playerprofile.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;

import static jakarta.persistence.FetchType.EAGER;


@Entity
@Table(name = "player_profile")
@NoArgsConstructor
@Data
public class PlayerProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name = "UUID",
            type = org.hibernate.id.uuid.UuidGenerator.class
    )
    @Column(name = "player_id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID playerId;

    @Column(name = "credential")
    private String credential;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "last_session")
    private String lastSession;

    @Column(name = "total_spent")
    private Integer totalSpent;

    @Column(name = "total_refund")
    private Integer totalRefund;

    @Column(name = "total_transactions")
    private Integer totalTransactions;

    @Column(name = "last_purchase")
    private String lastPurchase;

    @ElementCollection(fetch = EAGER)
    @Column(name = "active_campaigns")
    private Collection<String> activeCampaigns = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "playerProfile", cascade = CascadeType.ALL)
    private Collection<Device> devices = new HashSet<>();

    @Column(name = "level")
    private Integer level;

    @Column(name = "xp")
    private Integer xp;

    @Column(name = "total_playtime")
    private int totalPlaytime;

    @Column(name = "country")
    private String country;

    @Column(name = "language")
    private String language;

    @Column(name = "birth_date")
    private Date birthdate;

    @Column(name = "gender")
    private String gender;

    @ElementCollection(fetch = EAGER)
    @Column(name = "inventory")
    private Map<String, Integer> inventory = new HashMap<>();

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "clan_id", referencedColumnName = "id")
    private Clan clan;

    @Column(name = "custom_field")
    private String customField;

    }
