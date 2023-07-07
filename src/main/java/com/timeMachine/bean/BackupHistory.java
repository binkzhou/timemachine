package com.timeMachine.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackupHistory
{
    int id;
    long backupfileid;
    long filesize;
    long motifytime;
    String backuptargetpath;
    String backuptargetfullpath;
    int backuptargetrootid;
    String md5;
}
