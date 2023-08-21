package com.yekaa.sistemkampusjava.modules.datamahasiswa.service;

import com.yekaa.sistemkampusjava.modules.datamahasiswa.dto.DataMahasiswaRequestDto;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.dto.DataMahasiswaResponseDto;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.model.DataMahasiswaModel;

import java.util.List;
import java.util.Optional;

public interface DataMahasiswaService {
    List<DataMahasiswaResponseDto> findAllDataMahasiswa();
    Optional<DataMahasiswaResponseDto> findOneDataMahasiswaByNrp(String npr);
    Optional<DataMahasiswaResponseDto> findOneDataMahasiswaById(Long id);
    DataMahasiswaModel createDataMahasiswa(DataMahasiswaRequestDto requestBody);
    DataMahasiswaModel updateDataMahasiswaByNrp(String nrp, DataMahasiswaModel dataMahasiswaModel);
    DataMahasiswaModel deleteDataMahasiswaByNrp(String nrp);
}
