package com.Sk09Team.Doctor.controller;

import com.Sk09Team.Doctor.entity.Patient;
import com.Sk09Team.Doctor.model.CalendarRequest;
import com.Sk09Team.Doctor.model.ConsultationResponseForDoctor;
import com.Sk09Team.Doctor.model.DoctorFullProfileRequest;
import com.Sk09Team.Doctor.model.DoctorRequest;
import com.Sk09Team.Doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor



public class DoctorController {

//    private final AuthenticationService service;

    @Autowired
    DoctorService doctorService;

//    @PreAuthorize("hasAuthority('doctor:update')")
    @PutMapping("/{consultationId}/{doctorId}/approve")
    public ResponseEntity<Long> approveConsultation(@PathVariable("consultationId") Long consultationId,
                                                      @PathVariable("doctorId") Long doctorId) {

        return doctorService.approveConsultation(consultationId,doctorId);
    }
    @PostMapping("/register")
    public ResponseEntity<Long> registerDoctor(@RequestBody DoctorRequest doctorRequest){
        long doctorId =doctorService.registerDoctor(doctorRequest);
        return new ResponseEntity<>(doctorId,HttpStatus.CREATED);
    }
//    @PreAuthorize("hasAuthority('doctor:write')")
    @GetMapping("/{doctorId}/listConsultationsForDoctor")
    public ResponseEntity<List<ConsultationResponseForDoctor>> getAllConsultationsForDoctor(@PathVariable("doctorId") long doctorId){
        return (ResponseEntity<List<ConsultationResponseForDoctor>>) doctorService.getAllConsultationsForDoctor(doctorId);
    }
    @GetMapping("/{doctorId}/patients")
    public ResponseEntity<List<Patient>> getAllPatients(@PathVariable("doctorId") long doctorId ) {
        List<Patient> patients = doctorService.getAllPatientsByDoctorId(doctorId);
        return ResponseEntity.ok(patients);
    }



}
