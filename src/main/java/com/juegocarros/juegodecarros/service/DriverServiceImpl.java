package com.juegocarros.juegodecarros.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juegocarros.juegodecarros.entity.Driver;
import com.juegocarros.juegodecarros.repository.DriverRepository;
import java.util.List;
/**
 *
 * @author dickdelv
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Driver> findAll() {

        return driverRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Driver> findAll(Pageable pageable) {

        return driverRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Driver> findById(Long id) {

        return driverRepository.findById(id);
    }

    @Override
    @Transactional
    public Driver Save(Driver driver) {

        return driverRepository.save(driver);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        driverRepository.deleteById(id);

    }

    @Override
    public int latestIdDriver() {
        List <Driver> maxvalue = driverRepository.latestIdDriver();

        if (maxvalue == null) {
            return 0;
        }
        
        return maxvalue.size();
        
        

    }

}
