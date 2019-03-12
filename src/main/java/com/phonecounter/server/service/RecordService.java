package com.phonecounter.server.service;

import com.phonecounter.server.dao.RecordDao;
import com.phonecounter.server.model.DailyRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordDao recordDao;

    public void saveRecord(List<DailyRecord> dailyRecords, Long userId) {
        recordDao.saveRecord(dailyRecords, userId);
    }

    public List<DailyRecord> gerRecord(Long userId) {
        return recordDao.gerRecord(userId);
    }
}
