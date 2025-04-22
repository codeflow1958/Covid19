/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.programacion3.proyecto.covid.config;

import umg.edu.programacion3.proyecto.covid.service.CovidApiService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    private final CovidApiService service;

    public Scheduler(CovidApiService service) {
        this.service = service;
    }

    public void iniciar() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.schedule(() -> {
            System.out.println("[Scheduler] Starting API fetch...");
            service.fetchAndPersistCovidData();
        }, 15, TimeUnit.SECONDS); // <-- espera 15 segundos
    }
}

