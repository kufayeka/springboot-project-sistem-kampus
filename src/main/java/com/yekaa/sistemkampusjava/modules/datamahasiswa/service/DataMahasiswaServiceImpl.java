package com.yekaa.sistemkampusjava.modules.datamahasiswa.service;

import com.yekaa.sistemkampusjava.modules.datamahasiswa.dto.DataMahasiswaRequestDto;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.dto.DataMahasiswaResponseDto;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.model.DataMahasiswaModel;
import com.yekaa.sistemkampusjava.modules.datamahasiswa.repository.DataMahasiswaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataMahasiswaServiceImpl implements DataMahasiswaService {

    @Autowired
    private final DataMahasiswaRepository repository;

    @Autowired
    private final ModelMapper modelMapper;


    @Override
    public List<DataMahasiswaResponseDto> findAllDataMahasiswa() {
        List<DataMahasiswaModel> query = repository.findAll();

        List<DataMahasiswaResponseDto> result = new ArrayList<>();
        for(DataMahasiswaModel mhs: query){
            result.add(modelMapper.map(mhs, DataMahasiswaResponseDto.class));
        }

        return result;
    }

    @Override
    public Optional<DataMahasiswaResponseDto> findOneDataMahasiswaByNrp(String nrp) {
        Optional<DataMahasiswaModel> query = repository.findDataMahasiswaModelByNrp(nrp);

        Optional<DataMahasiswaResponseDto> result =
                query.map(dataMahasiswaModel
                        -> modelMapper.map(dataMahasiswaModel, DataMahasiswaResponseDto.class));

        return result;
    }

    @Override
    public Optional<DataMahasiswaResponseDto> findOneDataMahasiswaById(Long id) {
        Optional<DataMahasiswaModel> query = repository.findById(id);

        Optional<DataMahasiswaResponseDto> result =
                query.map(dataMahasiswaModel
                        -> modelMapper.map(dataMahasiswaModel, DataMahasiswaResponseDto.class));

        return result;
    }

    @Override
    public DataMahasiswaModel createDataMahasiswa(DataMahasiswaRequestDto requestBody) {
        DataMahasiswaModel query = DataMahasiswaModel.builder()
                .nama(requestBody.getNama())
                .nrp(requestBody.getNrp())
                .jurusan(requestBody.getJurusan())
                .build();

        return repository.save(query);
    }

    @Override
    public DataMahasiswaModel updateDataMahasiswaByNrp(String nrp, DataMahasiswaModel dataMahasiswaModel) {
        return null;
    }

    @Override
    public DataMahasiswaModel deleteDataMahasiswaByNrp(String nrp) {
        return null;
    }
}
