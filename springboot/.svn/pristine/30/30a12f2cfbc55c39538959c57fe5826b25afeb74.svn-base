drop table OA_NOTIFY cascade constraints;
drop table OA_NOTIFY_RECORD cascade constraints;
drop table SYS_DEPT cascade constraints;
drop table SYS_DICT cascade constraints;
drop table SYS_FILE cascade constraints;
drop table SYS_LOG cascade constraints;
drop table SYS_MENU cascade constraints;
drop table SYS_ROLE cascade constraints;
drop table SYS_ROLE_MENU cascade constraints;
drop table SYS_TASK cascade constraints;
drop table SYS_TASK_LOG cascade constraints;
drop table SYS_USER cascade constraints;
drop table SYS_USER_PLUS cascade constraints;
drop table SYS_USER_ROLE cascade constraints;

DROP TABLE quartz_FIRED_TRIGGERS cascade constraints;
DROP TABLE quartz_PAUSED_TRIGGER_GRPS cascade constraints;
DROP TABLE quartz_SCHEDULER_STATE cascade constraints;
DROP TABLE quartz_LOCKS cascade constraints;
DROP TABLE quartz_SIMPLE_TRIGGERS cascade constraints;
DROP TABLE quartz_SIMPROP_TRIGGERS cascade constraints;
DROP TABLE quartz_CRON_TRIGGERS cascade constraints;
DROP TABLE quartz_BLOB_TRIGGERS cascade constraints;
DROP TABLE quartz_TRIGGERS cascade constraints;
DROP TABLE quartz_job_DETAILS cascade constraints;
DROP TABLE quartz_CALENDARS cascade constraints;

/*==============================================================*/
/* Table: OA_NOTIFY                                             */
/*==============================================================*/
create table OA_NOTIFY 
(
   ID                   NVARCHAR2(64)           not null,
   TYPE                 NVARCHAR2(20),
   TITLE                NVARCHAR2(200),
   CONTENT              CLOB,
   FILES                CLOB,
   STATUS               NVARCHAR2(20),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_OA_NOTIFY primary key (ID)
);

comment on table OA_NOTIFY is
'通知通告';

comment on column OA_NOTIFY.ID is
'编号';

comment on column OA_NOTIFY.TYPE is
'类型';

comment on column OA_NOTIFY.TITLE is
'标题';

comment on column OA_NOTIFY.CONTENT is
'内容';

comment on column OA_NOTIFY.FILES is
'附件';

comment on column OA_NOTIFY.STATUS is
'状态';

comment on column OA_NOTIFY.CREATE_BY is
'创建者';

comment on column OA_NOTIFY.CREATE_DATE is
'创建时间';

comment on column OA_NOTIFY.UPDATE_BY is
'更新者';

comment on column OA_NOTIFY.UPDATE_DATE is
'更新时间';

comment on column OA_NOTIFY.REMARKS is
'备注信息';

comment on column OA_NOTIFY.DEL_FLAG is
'删除标记';

/*==============================================================*/
/* Table: OA_NOTIFY_RECORD                                      */
/*==============================================================*/
create table OA_NOTIFY_RECORD 
(
   ID                   NVARCHAR2(64)           not null,
   NOTIFY_ID            NVARCHAR2(64),
   USER_ID              NVARCHAR2(64),
   IS_READ              NUMBER(4),
   READ_DATE            DATE,
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_OA_NOTIFY_RECORD primary key (ID)
);

comment on table OA_NOTIFY_RECORD is
'通知通告发送记录';

comment on column OA_NOTIFY_RECORD.ID is
'编号';

comment on column OA_NOTIFY_RECORD.NOTIFY_ID is
'通知通告ID';

comment on column OA_NOTIFY_RECORD.USER_ID is
'接受人';

comment on column OA_NOTIFY_RECORD.IS_READ is
'阅读标记';

comment on column OA_NOTIFY_RECORD.READ_DATE is
'阅读时间';

/*==============================================================*/
/* Table: SYS_DEPT                                              */
/*==============================================================*/
create table SYS_DEPT 
(
   ID              		NVARCHAR2(64)           not null,
   PARENT_ID            NVARCHAR2(64),
   NAME                 NVARCHAR2(50),
   ORDER_NUM            NUMBER(11),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_DEPT primary key (ID)
);

comment on table SYS_DEPT is
'机构管理';

comment on column SYS_DEPT.PARENT_ID is
'上级机构ID，一级机构为0';

comment on column SYS_DEPT.NAME is
'机构名称';

comment on column SYS_DEPT.ORDER_NUM is
'排序';

/*==============================================================*/
/* Table: SYS_DICT                                              */
/*==============================================================*/
create table SYS_DICT 
(
   ID                   NVARCHAR2(64)           not null,
   NAME                 NVARCHAR2(100),
   VALUE                NVARCHAR2(100),
   TYPE                 NVARCHAR2(100),
   DESCRIPTION          NVARCHAR2(100),
   SORT                 NUMBER,
   PARENT_ID            NVARCHAR2(64),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_DICT primary key (ID)
);

comment on table SYS_DICT is
'字典表';

comment on column SYS_DICT.ID is
'编号';

comment on column SYS_DICT.NAME is
'标签名';

comment on column SYS_DICT.VALUE is
'数据值';

comment on column SYS_DICT.TYPE is
'类型';

comment on column SYS_DICT.DESCRIPTION is
'描述';

comment on column SYS_DICT.SORT is
'排序（升序）';

comment on column SYS_DICT.PARENT_ID is
'父级编号';

comment on column SYS_DICT.CREATE_BY is
'创建者';

comment on column SYS_DICT.CREATE_DATE is
'创建时间';

comment on column SYS_DICT.UPDATE_BY is
'更新者';

comment on column SYS_DICT.UPDATE_DATE is
'更新时间';

comment on column SYS_DICT.REMARKS is
'备注信息';

comment on column SYS_DICT.DEL_FLAG is
'删除标记';

/*==============================================================*/
/* Table: SYS_FILE                                              */
/*==============================================================*/
create table SYS_FILE 
(
   ID                   NVARCHAR2(64)           not null,
   TYPE                 NUMBER(11),
   URL                  NVARCHAR2(200),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_FILE primary key (ID)
);

comment on table SYS_FILE is
'文件上传';

comment on column SYS_FILE.TYPE is
'文件类型';

comment on column SYS_FILE.URL is
'URL地址';

/*==============================================================*/
/* Table: SYS_LOG                                               */
/*==============================================================*/
create table SYS_LOG 
(
   ID                   NVARCHAR2(64)           not null,
   USER_ID              NVARCHAR2(64),
   USERNAME             NVARCHAR2(50),
   OPERATION            NVARCHAR2(50),
   TIME                 NUMBER(11),
   METHOD               NVARCHAR2(200),
   PARAMS               CLOB,
   IP                   NVARCHAR2(64),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_LOG primary key (ID)
);

comment on table SYS_LOG is
'系统日志';

comment on column SYS_LOG.USER_ID is
'用户id';

comment on column SYS_LOG.USERNAME is
'用户名';

comment on column SYS_LOG.OPERATION is
'用户操作';

comment on column SYS_LOG.TIME is
'响应时间';

comment on column SYS_LOG.METHOD is
'请求方法';

comment on column SYS_LOG.PARAMS is
'请求参数';

comment on column SYS_LOG.IP is
'IP地址';

/*==============================================================*/
/* Table: SYS_MENU                                              */
/*==============================================================*/
create table SYS_MENU 
(
   ID              		NVARCHAR2(64)           not null,
   PARENT_ID            NVARCHAR2(64),
   NAME                 NVARCHAR2(50),
   URL                  NVARCHAR2(200),
   PERMS                NVARCHAR2(500),
   TYPE                 NUMBER(11),
   ICON                 NVARCHAR2(50),
   ORDER_NUM            NUMBER(11),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_MENU primary key (ID)
);

comment on table SYS_MENU is
'菜单管理';

comment on column SYS_MENU.PARENT_ID is
'父菜单ID，一级菜单为0';

comment on column SYS_MENU.NAME is
'菜单名称';

comment on column SYS_MENU.URL is
'菜单URL';

comment on column SYS_MENU.PERMS is
'授权(多个用逗号分隔，如：user:list,user:create)';

comment on column SYS_MENU.TYPE is
'类型   0：目录   1：菜单   2：按钮';

comment on column SYS_MENU.ICON is
'菜单图标';

comment on column SYS_MENU.ORDER_NUM is
'排序';

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE 
(
   ID              		NVARCHAR2(64)           not null,
   ROLE_NAME            NVARCHAR2(100),
   ROLE_SIGN            NVARCHAR2(100),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_ROLE primary key (ID)
);

comment on table SYS_ROLE is
'角色';

comment on column SYS_ROLE.ROLE_NAME is
'角色名称';

comment on column SYS_ROLE.ROLE_SIGN is
'角色标识';

/*==============================================================*/
/* Table: SYS_ROLE_MENU                                         */
/*==============================================================*/
create table SYS_ROLE_MENU 
(
   ID                   NVARCHAR2(64)           not null,
   ROLE_ID              NVARCHAR2(64),
   MENU_ID              NVARCHAR2(64),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_ROLE_MENU primary key (ID)
);

comment on table SYS_ROLE_MENU is
'角色与菜单对应关系';

comment on column SYS_ROLE_MENU.ROLE_ID is
'角色ID';

comment on column SYS_ROLE_MENU.MENU_ID is
'菜单ID';

/*==============================================================*/
/* Table: SYS_TASK                                              */
/*==============================================================*/
create table SYS_TASK 
(
   ID                   NVARCHAR2(64)           not null,
   CRON_EXPRESSION      NVARCHAR2(255),
   METHOD_NAME          NVARCHAR2(255),
   IS_CONCURRENT        NVARCHAR2(255),
   DESCRIPTION          NVARCHAR2(255),
   BEAN_CLASS           NVARCHAR2(255),
   JOB_STATUS           NVARCHAR2(255),
   JOB_GROUP            NVARCHAR2(255),
   SPRING_BEAN          NVARCHAR2(255),
   JOB_NAME             NVARCHAR2(255),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_TASK primary key (ID)
);

comment on column SYS_TASK.CRON_EXPRESSION is
'cron表达式';

comment on column SYS_TASK.METHOD_NAME is
'任务调用的方法名';

comment on column SYS_TASK.IS_CONCURRENT is
'任务是否有状态';

comment on column SYS_TASK.DESCRIPTION is
'任务描述';

comment on column SYS_TASK.BEAN_CLASS is
'任务执行时调用哪个类的方法 包名+类名';

comment on column SYS_TASK.JOB_STATUS is
'任务状态';

comment on column SYS_TASK.JOB_GROUP is
'任务分组';

comment on column SYS_TASK.SPRING_BEAN is
'Spring bean';

comment on column SYS_TASK.JOB_NAME is
'任务名';

CREATE TABLE sys_task_log (
  id NVARCHAR2(64) NOT NULL,
  job_name NVARCHAR2(64),
  job_group NVARCHAR2(64),
  job_type NVARCHAR2(50),
  job_event NVARCHAR2(200),
  job_message NVARCHAR2(500),
  is_exception CHAR(1),
  exception_info NVARCHAR2(500) ,
  create_by     NVARCHAR2(64),
  create_date     date,
  update_by     NVARCHAR2(64),
  update_date     date,
  remarks       NVARCHAR2(255),
  del_flag        char(1),
  constraint pk_sys_task_log primary key (ID)
);
comment on table sys_task_log is '任务调度日志表';
comment on column sys_task_log.id is '编号';
comment on column sys_task_log.job_name is '任务名称';
comment on column sys_task_log.job_group is '任务组名';
comment on column sys_task_log.job_type is '日志类型';
comment on column sys_task_log.job_event is '日志事件';
comment on column sys_task_log.job_message is '日志信息';
comment on column sys_task_log.is_exception is '是否异常';
comment on column sys_task_log.exception_info is '异常信息';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER 
(
   ID              		NVARCHAR2(64)           not null,
   USERNAME             NVARCHAR2(50),
   NAME                 NVARCHAR2(100),
   PASSWORD             NVARCHAR2(50),
   DEPT_ID              NVARCHAR2(64),
   EMAIL                NVARCHAR2(100),
   MOBILE               NVARCHAR2(100),
   STATUS               NUMBER(4),
   SEX                  NVARCHAR2(64),
   BIRTH                DATE,
   PIC_ID               NVARCHAR2(64),
   LIVE_ADDRESS         NVARCHAR2(500),
   HOBBY                NVARCHAR2(255),
   PROVINCE             NVARCHAR2(255),
   CITY                 NVARCHAR2(255),
   DISTRICT             NVARCHAR2(255),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_USER primary key (ID)
);

comment on column SYS_USER.USERNAME is
'用户名';

comment on column SYS_USER.PASSWORD is
'密码';

comment on column SYS_USER.EMAIL is
'邮箱';

comment on column SYS_USER.MOBILE is
'手机号';

comment on column SYS_USER.STATUS is
'状态 0:禁用，1:正常';

comment on column SYS_USER.SEX is
'性别';

comment on column SYS_USER.BIRTH is
'出身日期';

comment on column SYS_USER.LIVE_ADDRESS is
'现居住地';

comment on column SYS_USER.HOBBY is
'爱好';

comment on column SYS_USER.PROVINCE is
'省份';

comment on column SYS_USER.CITY is
'所在城市';

comment on column SYS_USER.DISTRICT is
'所在地区';

/*==============================================================*/
/* Table: SYS_USER_PLUS                                         */
/*==============================================================*/
create table SYS_USER_PLUS 
(
   ID                   NVARCHAR2(64)           not null,
   USER_ID              NVARCHAR2(64),
   PAYMENT              NVARCHAR2(200),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_USER_PLUS primary key (ID)
);

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE 
(
   ID                   NVARCHAR2(64)           not null,
   USER_ID              NVARCHAR2(64),
   ROLE_ID              NVARCHAR2(64),
   create_by			NVARCHAR2(64),
   create_date			date,
   update_by			NVARCHAR2(64),
   update_date			date,
   remarks				NVARCHAR2(255),
   del_flag				char(1),
   constraint PK_SYS_USER_ROLE primary key (ID)
);

comment on table SYS_USER_ROLE is
'用户与角色对应关系';

comment on column SYS_USER_ROLE.USER_ID is
'用户ID';

comment on column SYS_USER_ROLE.ROLE_ID is
'角色ID';

--quartz持久化

CREATE TABLE quartz_job_DETAILS
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    JOB_NAME  VARCHAR2(200) NOT NULL,
    JOB_GROUP VARCHAR2(200) NOT NULL,
    DESCRIPTION VARCHAR2(250) NULL,
    JOB_CLASS_NAME   VARCHAR2(250) NOT NULL, 
    IS_DURABLE VARCHAR2(1) NOT NULL,
    IS_NONCONCURRENT VARCHAR2(1) NOT NULL,
    IS_UPDATE_DATA VARCHAR2(1) NOT NULL,
    REQUESTS_RECOVERY VARCHAR2(1) NOT NULL,
    JOB_DATA BLOB NULL,
    CONSTRAINT quartz_job_DETAILS_PK PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE quartz_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    JOB_NAME  VARCHAR2(200) NOT NULL, 
    JOB_GROUP VARCHAR2(200) NOT NULL,
    DESCRIPTION VARCHAR2(250) NULL,
    NEXT_FIRE_TIME NUMBER(13) NULL,
    PREV_FIRE_TIME NUMBER(13) NULL,
    PRIORITY NUMBER(13) NULL,
    TRIGGER_STATE VARCHAR2(16) NOT NULL,
    TRIGGER_TYPE VARCHAR2(8) NOT NULL,
    START_TIME NUMBER(13) NOT NULL,
    END_TIME NUMBER(13) NULL,
    CALENDAR_NAME VARCHAR2(200) NULL,
    MISFIRE_INSTR NUMBER(2) NULL,
    JOB_DATA BLOB NULL,
    CONSTRAINT quartz_TRIGGERS_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT quartz_TRIGGER_TO_JOBS_FK FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP) 
      REFERENCES quartz_job_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP) 
);
CREATE TABLE quartz_simple_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    REPEAT_COUNT NUMBER(7) NOT NULL,
    REPEAT_INTERVAL NUMBER(12) NOT NULL,
    TIMES_TRIGGERED NUMBER(10) NOT NULL,
    CONSTRAINT quartz_SIMPLE_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT quartz_SIMPLE_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
	REFERENCES quartz_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE quartz_cron_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    CRON_EXPRESSION VARCHAR2(120) NOT NULL,
    TIME_ZONE_ID VARCHAR2(80),
    CONSTRAINT quartz_CRON_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT quartz_CRON_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
      REFERENCES quartz_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE quartz_simprop_triggers
  (          
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    STR_PROP_1 VARCHAR2(512) NULL,
    STR_PROP_2 VARCHAR2(512) NULL,
    STR_PROP_3 VARCHAR2(512) NULL,
    INT_PROP_1 NUMBER(10) NULL,
    INT_PROP_2 NUMBER(10) NULL,
    LONG_PROP_1 NUMBER(13) NULL,
    LONG_PROP_2 NUMBER(13) NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR2(1) NULL,
    BOOL_PROP_2 VARCHAR2(1) NULL,
    CONSTRAINT quartz_SIMPROP_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT quartz_SIMPROP_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
      REFERENCES quartz_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE quartz_blob_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    BLOB_DATA BLOB NULL,
    CONSTRAINT quartz_BLOB_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT quartz_BLOB_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
        REFERENCES quartz_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE quartz_calendars
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    CALENDAR_NAME  VARCHAR2(200) NOT NULL, 
    CALENDAR BLOB NOT NULL,
    CONSTRAINT quartz_CALENDARS_PK PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
);
CREATE TABLE quartz_paused_trigger_grps
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_GROUP  VARCHAR2(200) NOT NULL, 
    CONSTRAINT quartz_PAUSED_TRIG_GRPS_PK PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
);
CREATE TABLE quartz_fired_triggers 
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    ENTRY_ID VARCHAR2(95) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    INSTANCE_NAME VARCHAR2(200) NOT NULL,
    FIRED_TIME NUMBER(13) NOT NULL,
    SCHED_TIME NUMBER(13) NOT NULL,
    PRIORITY NUMBER(13) NOT NULL,
    STATE VARCHAR2(16) NOT NULL,
    JOB_NAME VARCHAR2(200) NULL,
    JOB_GROUP VARCHAR2(200) NULL,
    IS_NONCONCURRENT VARCHAR2(1) NULL,
    REQUESTS_RECOVERY VARCHAR2(1) NULL,
    CONSTRAINT quartz_FIRED_TRIGGER_PK PRIMARY KEY (SCHED_NAME,ENTRY_ID)
);
CREATE TABLE quartz_scheduler_state 
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    INSTANCE_NAME VARCHAR2(200) NOT NULL,
    LAST_CHECKIN_TIME NUMBER(13) NOT NULL,
    CHECKIN_INTERVAL NUMBER(13) NOT NULL,
    CONSTRAINT quartz_SCHEDULER_STATE_PK PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
);
CREATE TABLE quartz_locks
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    LOCK_NAME  VARCHAR2(40) NOT NULL, 
    CONSTRAINT quartz_LOCKS_PK PRIMARY KEY (SCHED_NAME,LOCK_NAME)
);

create index idx_qrtz_j_req_recovery on quartz_job_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
create index idx_qrtz_j_grp on quartz_job_DETAILS(SCHED_NAME,JOB_GROUP);

create index idx_qrtz_t_j on quartz_triggers(SCHED_NAME,JOB_NAME,JOB_GROUP);
create index idx_qrtz_t_jg on quartz_triggers(SCHED_NAME,JOB_GROUP);
create index idx_qrtz_t_c on quartz_triggers(SCHED_NAME,CALENDAR_NAME);
create index idx_qrtz_t_g on quartz_triggers(SCHED_NAME,TRIGGER_GROUP);
create index idx_qrtz_t_state on quartz_triggers(SCHED_NAME,TRIGGER_STATE);
create index idx_qrtz_t_n_state on quartz_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
create index idx_qrtz_t_n_g_state on quartz_triggers(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
create index idx_qrtz_t_next_fire_time on quartz_triggers(SCHED_NAME,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_st on quartz_triggers(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_misfire on quartz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_st_misfire on quartz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
create index idx_qrtz_t_nft_st_misfire_grp on quartz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

create index idx_qrtz_ft_trig_inst_name on quartz_fired_triggers(SCHED_NAME,INSTANCE_NAME);
create index idx_qrtz_ft_inst_job_req_rcvry on quartz_fired_triggers(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
create index idx_qrtz_ft_j_g on quartz_fired_triggers(SCHED_NAME,JOB_NAME,JOB_GROUP);
create index idx_qrtz_ft_jg on quartz_fired_triggers(SCHED_NAME,JOB_GROUP);
create index idx_qrtz_ft_t_g on quartz_fired_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
create index idx_qrtz_ft_tg on quartz_fired_triggers(SCHED_NAME,TRIGGER_GROUP);
