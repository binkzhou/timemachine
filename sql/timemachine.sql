-- ----------------------------
-- Table structure for tb_backfilehistory
-- ----------------------------
DROP TABLE IF EXISTS `tb_backfilehistory`;
CREATE TABLE `tb_backfilehistory`
(
    `id`                 INTEGER PRIMARY KEY AUTOINCREMENT,
    `backupfileid`       INTEGER,
    `motifytime`         INTEGER,
    `filesize`           INTEGER,
    `copystarttime`      TEXT,
    `copyendtime`        TEXT,
    `backuptargetpath`   TEXT,
    `backuptargetrootid` INTEGER,
    `md5`                TEXT,
    `backupid`           INTEGER
);

-- ----------------------------
-- Table structure for tb_backfiles
-- ----------------------------
DROP TABLE IF EXISTS `tb_backfiles`;
CREATE TABLE `tb_backfiles`
(
    `id`                INTEGER PRIMARY KEY AUTOINCREMENT,
    `backuprootid`      INTEGER,
    `filepath`          TEXT,
    `versionhistorycnt` INTEGER,
    `lastbackuptime`    TEXT
);

-- ----------------------------
-- Table structure for tb_backup
-- ----------------------------
DROP TABLE IF EXISTS `tb_backup`;
CREATE TABLE `tb_backup`
(
    `id`            INTEGER PRIMARY KEY AUTOINCREMENT,
    `begintime`     TEXT,
    `endtime`       TEXT,
    `filecopycount` INTEGER,
    `datacopycount` INTEGER
);

-- ----------------------------
-- Table structure for tb_backuproot
-- ----------------------------
DROP TABLE IF EXISTS `tb_backuproot`;
CREATE TABLE `tb_backuproot`
(
    `id`       INTEGER PRIMARY KEY AUTOINCREMENT,
    `rootpath` TEXT
);

-- ----------------------------
-- Table structure for tb_backuptargetroot
-- ----------------------------
DROP TABLE IF EXISTS `tb_backuptargetroot`;
CREATE TABLE `tb_backuptargetroot`
(
    `id`            INTEGER PRIMARY KEY AUTOINCREMENT,
    `tagetrootpath` TEXT
);
