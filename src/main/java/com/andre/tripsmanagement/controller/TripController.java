package com.andre.tripsmanagement.controller;

import com.andre.tripsmanagement.model.Trip;
import com.andre.tripsmanagement.repositories.TripRepository;
import com.andre.tripsmanagement.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("/")
    public String getTripCRUDPage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("trips", tripRepository.findAll(
                PageRequest.of(page, 4)
        ));
        return "index";
    }

    @PostMapping("/save")
    public String save(Trip trip) {
        LocalDate date = DateUtil.getLocalDate(trip.getDate());
        trip.setDate(DateUtil.getDateUtil(date.plusDays(1)));
        tripRepository.save(trip);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(Integer id) {
        tripRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Trip getOneTrip(Integer id) {
        return tripRepository.getOne(id);
    }
}
