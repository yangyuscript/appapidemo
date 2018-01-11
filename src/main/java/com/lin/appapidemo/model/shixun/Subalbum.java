package com.lin.appapidemo.model.shixun;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_subalbum")
public class Subalbum {
    @Id
    @Column(name = "sid")
    private int sid;
    @Column(name = "aid")
    private int adi;
    @Column(name = "number")
    private String number;
    @Column(name = "condi")
    private int condi;
    @Column(name = "time")
    private String time;
    @Transient
    private Album album;

    public Subalbum(int adi, String number, int condi, String time) {
        this.adi = adi;
        this.number = number;
        this.condi = condi;
        this.time = time;
    }
}
