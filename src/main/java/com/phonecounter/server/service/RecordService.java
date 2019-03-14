package com.phonecounter.server.service;

import com.phonecounter.server.dao.RecordDao;
import com.phonecounter.server.model.DailyRecord;
import com.phonecounter.server.model.PackageApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecordService {

    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public void saveRecord(List<DailyRecord> dailyRecords, Long userId) {
        List<DailyRecord> existed = this.gerRecord(userId);
        Set<DailyRecord> set = new HashSet<>(existed);
        List<DailyRecord> newAdded = dailyRecords.stream().filter(x -> !set.contains(x)).collect(Collectors.toList());
        System.out.println("要插入的数据有:" + newAdded.size());
        recordDao.saveRecord(newAdded, userId);
    }

    public List<DailyRecord> gerRecord(Long userId) {
        return recordDao.gerRecord(userId);
    }

    public void saveKV(List<PackageApp> dailyRecords, Long userId) {
        List<PackageApp> existed = this.gerKV(userId);
        Set<String> set = existed.stream().map(PackageApp::getPackageName).collect(Collectors.toSet());
        List<PackageApp> newAdded = dailyRecords.stream().filter(x -> !set.contains(x.getPackageName())).collect(Collectors.toList());
        System.out.println("要插入的app有:" + newAdded.size());
        recordDao.saveKV(newAdded, userId);
    }

    public List<PackageApp> gerKV(Long userId) {
        return recordDao.gerKV(userId);
    }

}
