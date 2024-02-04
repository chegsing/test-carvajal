package co.com.carvajal.transversal.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Profile
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile", schema = "livebook")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @ColumnTransformer(read = "livebook.PGP_SYM_DECRYPT(password::bytea, 'AES_KEY')",
                       write = "livebook.PGP_SYM_ENCRYPT(?, 'AES_KEY')")
    @Column(name = "password",
            columnDefinition = "bytea",
            nullable = false)
    private String password;
    
    @Basic(optional = false)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;    
    
    @Column(name = "active")
    private boolean active;

    private static final long serialVersionUID = 8094153480314794704L;

}
