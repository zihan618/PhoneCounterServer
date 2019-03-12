package com.phonecounter.server.dao;

import com.phonecounter.server.model.DailyRecord;
import com.phonecounter.server.model.User;
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
        Map<String, Object> map = new HashMap<>();
        map.put("list", dailyRecords);
        map.put("userId", userId);
        SqlSession session = sqlSessionFactory.openSession();
        session.insert(namespace + "upload", map);
    }

    public List<DailyRecord> gerRecord(Long userId) {
        SqlSession session = sqlSessionFactory.openSession();
        List<DailyRecord> records = session.selectList(namespace + "download", userId);
        return records;
    }

}
