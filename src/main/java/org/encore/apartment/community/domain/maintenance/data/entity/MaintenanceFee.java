package org.encore.apartment.community.domain.maintenance.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.encore.apartment.community.domain.user.data.entity.User;

import java.io.Serializable;
import java.util.Date;

@Getter
@Entity
@Table(name = "maintenanceFee")
public class MaintenanceFee {

    @Data
    @Embeddable
    public static class PaymentDate implements Serializable{
        @Column(insertable = false, updatable = false, name = "payment_date")
        private Date paymentDate;

        @Column(insertable = false, updatable = false, name = "user_id")
        private String userId;
    }

//    @Id
//    @NotNull
//    @Column(name = "payment_date")
//    private Date paymentDate ;
//
//    @ManyToOne
//    @NotNull
//    @JoinColumn(name = "user_id")
//    private String maintenanceId ;

    @EmbeddedId
    private PaymentDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @NotNull
    @Column(name = "general_maintenance_fee")
    private Integer generalMaintenanceFee ;

    @NotNull
    @Column(name = "security_service_fee")
    private Integer securityServiceFee ;

    @NotNull
    @Column(name = "disinfection_fee")
    private Integer disinfectionFee ;

    @NotNull
    @Column(name = "elevator_maintenance_fee")
    private Integer elevatorMaintenanceFee ;

    @NotNull
    @Column(name = "intelligent_maintenance_fee")
    private Integer intelligentMaintenanceFee ;

    @NotNull
    @Column(name = "heating_maintenance_fee")
    private Integer heatingMaintenanceFee ;

    @NotNull
    @Column(name = "hot_water_supply_fee")
    private Integer hotWaterSupplyFee ;

    @NotNull
    @Column(name = "repair_fee")
    private Integer repairFee ;

    @NotNull
    @Column(name = "entrusted_management_fee")
    private Integer entrustedManagementFee ;

    @NotNull
    @Column(name = "cleaning_fee")
    private Integer cleaningFee ;

    public MaintenanceFee() {
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_idx", referencedColumnName = "userId")
//    private User user;

    @Builder

    public MaintenanceFee(PaymentDate paymentDate, User user, Integer generalMaintenanceFee, Integer securityServiceFee, Integer disinfectionFee, Integer elevatorMaintenanceFee, Integer intelligentMaintenanceFee, Integer heatingMaintenanceFee, Integer hotWaterSupplyFee, Integer repairFee, Integer entrustedManagementFee, Integer cleaningFee) {
        this.paymentDate = paymentDate;
        this.user = user;
        this.generalMaintenanceFee = generalMaintenanceFee;
        this.securityServiceFee = securityServiceFee;
        this.disinfectionFee = disinfectionFee;
        this.elevatorMaintenanceFee = elevatorMaintenanceFee;
        this.intelligentMaintenanceFee = intelligentMaintenanceFee;
        this.heatingMaintenanceFee = heatingMaintenanceFee;
        this.hotWaterSupplyFee = hotWaterSupplyFee;
        this.repairFee = repairFee;
        this.entrustedManagementFee = entrustedManagementFee;
        this.cleaningFee = cleaningFee;
    }
}
