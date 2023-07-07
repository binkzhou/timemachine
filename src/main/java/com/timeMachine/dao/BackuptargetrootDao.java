package com.timeMachine.dao;

import com.timeMachine.bean.Backuptargetroot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BackuptargetrootDao {
    public static ObservableList<Backuptargetroot> all() {
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        ObservableList<Backuptargetroot> BackupRootList = FXCollections.observableArrayList();
        ResultSet ret=mysqlHelper.querySql("select * from tb_backuptargetroot");

        while(true)
        {
            try {
                if (!(ret!=null&&ret.next())) break;
                Backuptargetroot backuproot=new Backuptargetroot();
                backuproot.setId(ret.getInt("id"));
                backuproot.setTagetrootpath(ret.getString("tagetrootpath"));
                BackupRootList.add(backuproot);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return BackupRootList;
    }


    public static boolean delete(String id) {
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        return mysqlHelper.exeSql("delete from tb_backuptargetroot where id=" + id);
    }

    public static boolean add(String content){
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        return mysqlHelper.exeSql("insert into tb_backuptargetroot ( tagetrootpath ) values ( \"" + content + "\" );");
    }

    public static boolean edit(String id, String content){
        MySQLHelper mysqlHelper = new MySQLHelper("dbconfig");
        // UPDATE runoob_tbl SET runoob_title='学习 C++' WHERE runoob_id=3;
        return mysqlHelper.exeSql("update tb_backuptargetroot set tagetrootpath = '" + content + "' where id = "+ id);
    }
}
