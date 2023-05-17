package com.example.webbanhanggiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_role",referencedColumnName = "ID")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "Id_user",referencedColumnName = "ID")
    private User user;

    @Column(name = "status")
    private String status;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_fix")
    private Date dateFix;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<Cart> listOder;
}
