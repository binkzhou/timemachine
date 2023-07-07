package com.timeMachine.dao;

import com.timeMachine.bean.Backuproot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BackuprootDao {

    public static ObservableList<Backuproot> all() {
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
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

    public static boolean add(String content){
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        return mysqlHelper.exeSql("insert into tb_backuproot ( rootpath ) values ( \"" + content + "\" );");
    }

    public static boolean edit(String id, String content){
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        // UPDATE runoob_tbl SET runoob_title='学习 C++' WHERE runoob_id=3;
        return mysqlHelper.exeSql("update tb_backuproot set rootpath = '" + content + "' where id = "+ id);
    }
}
