package com.yekaa.sistemkampusjava.modules.datamahasiswa.dto;

import lombok.Data;

@Data
public class DataMahasiswaResponseDto {
    private Long id;
    private String nama;
    private String nrp;
    private String jurusan;
}
