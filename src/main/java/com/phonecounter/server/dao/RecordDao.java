package com.phonecounter.server.dao;

import com.phonecounter.server.model.DailyRecord;
import com.phonecounter.server.model.PackageApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public class RecordDao {
    String namespace = "record.";

    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public RecordDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void saveRecord(List<DailyRecord> dailyRecords, Long userId) {
        if (!dailyRecords.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("list", dailyRecords);
            map.put("userId", userId);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                session.insert(namespace + "upload", map);
            }
        }
    }

    public List<DailyRecord> gerRecord(Long userId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<DailyRecord> records = session.selectList(namespace + "download", userId);
            return records;
        }
    }

    public void saveKV(List<PackageApp> dailyRecords, Long userId) {
        if (!dailyRecords.isEmpty()) {

            Map<String, Object> map = new HashMap<>();
            map.put("list", dailyRecords);
            map.put("userId", userId);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                session.insert(namespace + "uploadKV", map);
            }
        }
    }

    public List<PackageApp> gerKV(Long userId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<PackageApp> records = session.selectList(namespace + "downloadKV", userId);
            return records;
        }
    }

}
