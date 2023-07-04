package com.timemachine.dao;

import com.timemachine.bean.Backuproot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BackuprootDao {

    public static ObservableList<Backuproot> all() {
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
//        List<Backuproot> BackupRootList=new ArrayList<>();
        ObservableList<Backuproot> BackupRootList = FXCollections.observableArrayList();
        ResultSet ret=mysqlHelper.querySql("select * from tb_backuproot");

        while(true)
        {
            try {
                if (!(ret!=null&&ret.next())) break;
                Backuproot backuproot=new Backuproot();
                backuproot.setId(ret.getInt("id"));
                backuproot.setRootpath(ret.getString("rootpath"));
                BackupRootList.add(backuproot);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return BackupRootList;
    }
}
