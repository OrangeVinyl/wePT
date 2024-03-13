package org.encore.apartment.community.domain.admin.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;

@Getter
@Entity
@Table(name = "admin_tbl")
public class Admin {

    @Id
    @NotNull
    @Column(name = "admin_id")
    private String adminId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartmentId;

    @NotNull
    @Column(name = "admin_password")
    private String adminPassword ;

    @NotNull
    @Column(name = "admin_contact_number")
    private String adminContactNumber ;

    public Admin(){

    }

    @Builder
    public Admin(String adminId, Apartment apartmentId, String adminPassword, String adminContactNumber) {
        this.adminId = adminId;
        this.apartmentId = apartmentId;
        this.adminPassword = adminPassword;
        this.adminContactNumber = adminContactNumber;
    }

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "apartment_id", referencedColumnName = "apartmentId")
//    private Apartment apartment;
}
