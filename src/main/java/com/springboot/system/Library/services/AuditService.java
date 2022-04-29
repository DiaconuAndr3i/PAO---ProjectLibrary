package com.springboot.system.Library.services;

import com.springboot.system.Library.entities.Audit;
import com.springboot.system.Library.repository.AuditRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AuditService implements AuditInterfaceService {

    @Autowired
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }
    @Override
    public List<Audit> getAllRecords() {
        return this.auditRepository.findAll();
    }

    @Override
    public Audit createRecord(Audit audit) {
        return this.auditRepository.save(audit);
    }

    @Override
    public Audit createAction(String string){
        return this.auditRepository.save(new Audit(string, new Timestamp(System.currentTimeMillis())));
    }

}
