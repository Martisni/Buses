package com.sanvalero.buses.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "buses_lines")
public class BusLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column
    private int rate;

    @OneToMany(mappedBy = "line")
    @JsonBackReference(value = "busline_buses")
    private List<Bus> buses;

    @ManyToMany
    @JoinTable(name = "lines_stops",
            joinColumns = @JoinColumn(name = "line_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    private List<BusStop> stops;
}
