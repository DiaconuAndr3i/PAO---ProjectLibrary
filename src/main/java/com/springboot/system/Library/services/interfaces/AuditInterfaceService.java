package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Audit;

import java.util.List;

public interface AuditInterfaceService {
    List<Audit> getAllRecords();

    Audit createRecord(Audit audit);
    Audit createAction(String string);
}
