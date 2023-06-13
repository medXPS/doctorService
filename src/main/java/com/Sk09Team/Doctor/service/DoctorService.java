package com.Sk09Team.Doctor.service;

import com.Sk09Team.Doctor.entity.Patient;
import com.Sk09Team.Doctor.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface DoctorService {
    ResponseEntity<Long> approveConsultation(long consultationId, long doctorId);

    List<DoctorResponse> getDoctorsByCity(String city);

    List<DoctorResponse> getDoctorsBySpecialty(String specialty);

    List<DoctorResponse> getAllDoctors();

    List<DoctorResponse> getDoctorsByCityAndSpecialty(String city, String specialty);

    long registerDoctor(DoctorRequest doctorRequest);

    List<DoctorResponse> getDoctorsByLastName(String lastName);

     ResponseEntity<List<ConsultationResponseForDoctor>>getAllConsultationsForDoctor(long doctorId);

    List<Patient> getAllPatientsByDoctorId(long doctorId);

    void updateDoctor(long doctorId, DoctorFullProfileRequest doctorRequest);
    DoctorResponse getDoctorByDoctorId(long doctorId);

    void updateCalendar(long doctorId, CalendarRequest calendar);
}

