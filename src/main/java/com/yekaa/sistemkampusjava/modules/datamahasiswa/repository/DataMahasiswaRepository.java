package com.yekaa.sistemkampusjava.modules.datamahasiswa.repository;

import com.yekaa.sistemkampusjava.modules.datamahasiswa.model.DataMahasiswaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DataMahasiswaRepository extends
        JpaRepository<DataMahasiswaModel, Long>
{
    Optional<DataMahasiswaModel> findDataMahasiswaModelByNrp(String nrp);
}
