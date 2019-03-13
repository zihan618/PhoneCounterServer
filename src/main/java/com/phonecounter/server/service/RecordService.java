package com.phonecounter.server.service;

import com.phonecounter.server.dao.RecordDao;
import com.phonecounter.server.model.DailyRecord;
import com.phonecounter.server.model.PackageApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public void saveRecord(List<DailyRecord> dailyRecords, Long userId) {
        recordDao.saveRecord(dailyRecords, userId);
    }

    public List<DailyRecord> gerRecord(Long userId) {
        return recordDao.gerRecord(userId);
    }

    public void saveKV(List<PackageApp> dailyRecords, Long userId) {
        recordDao.saveKV(dailyRecords, userId);
    }

    public List<PackageApp> gerKV(Long userId) {
        return recordDao.gerKV(userId);
    }

}
