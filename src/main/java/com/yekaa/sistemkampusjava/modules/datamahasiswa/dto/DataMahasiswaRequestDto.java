package com.yekaa.sistemkampusjava.modules.datamahasiswa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DataMahasiswaRequestDto {

    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @NotBlank(message = "NRP tidak boleh kosong")
    @Size(min = 9, max = 9, message = "NRP harus memiliki panjang 9 karakter")
    private String nrp;

    @NotBlank(message = "Jurusan tidak boleh kosong")
    private String jurusan;

}
