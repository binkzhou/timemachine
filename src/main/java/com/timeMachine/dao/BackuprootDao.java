package com.timeMachine.dao;

import com.timeMachine.bean.Backuproot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

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


    public static boolean delete(String id) {
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        return mysqlHelper.exeSql("delete from tb_backuproot where id=" + id);
    }
}
