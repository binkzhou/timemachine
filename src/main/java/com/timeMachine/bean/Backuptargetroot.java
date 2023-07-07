package com.timeMachine.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Backuptargetroot {
    int id;
    String tagetrootpath;
    String targetrootdir;
    long spaceRemain;
}
