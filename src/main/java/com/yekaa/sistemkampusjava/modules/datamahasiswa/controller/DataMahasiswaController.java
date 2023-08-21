package com.yekaa.sistemkampusjava.modules.datamahasiswa.controller;

import com.yekaa.sistemkampusjava.modules.datamahasiswa.dto.DataMahasiswaRequestDto;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.dto.DataMahasiswaResponseDto;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.model.DataMahasiswaModel;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.service.DataMahasiswaService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DataMahasiswaController {

    @Autowired
    private final DataMahasiswaService service;

    @GetMapping("/getAllDataMahasiswa")
    public ResponseEntity<?> getAllDataMahasiswa(){
        List<DataMahasiswaResponseDto> result =
                service.findAllDataMahasiswa();

        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/getDataMahasiswaById/{id}")
    public ResponseEntity<?> getDataMahasiswaById(
            @PathVariable Long id
    ){
        Optional<DataMahasiswaResponseDto> result =
                service.findOneDataMahasiswaById(id);

        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/getDataMahasiswaByNrp/{nrp}")
    public ResponseEntity<?> getDataMahasiswaById(
            @PathVariable String nrp
    ){
        Optional<DataMahasiswaResponseDto> result =
                service.findOneDataMahasiswaByNrp(nrp);

        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping("/addDataMahasiswa")
    public ResponseEntity<?> addDataMahasiswa(
            @Valid @RequestBody DataMahasiswaRequestDto requestBody,
            HttpServletRequest request
    ){

        DataMahasiswaModel result = service.createDataMahasiswa(requestBody);

        URI location = ServletUriComponentsBuilder
                .fromRequestUri(request)
                .path("/{id}")
                .buildAndExpand(result.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
