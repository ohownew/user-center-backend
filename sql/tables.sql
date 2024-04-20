create table user_center.invite
(
    id         bigint auto_increment
        primary key,
    code       varchar(128)                       not null comment '邀请码',
    codeStatus int      default 0                 not null comment '邀请码状态 0-未使用 1-已使用',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除 0-未删除 1-已删除',
    constraint invite_pk
        unique (code)
)
    comment '邀请';

create table user_center.user_basic
(
    id           bigint auto_increment
        primary key,
    username     varchar(256)                       null comment '用户昵称',
    userAccount  varchar(256)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '用户头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(512)                       not null comment '密码',
    phone        varchar(128)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '用户状态 0-正常',
    createTime   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除 0-未删除 1-已删除',
    userRole     int      default 0                 not null comment '用户角色 0-普通用户 1-管理员',
    inviteCode   varchar(128)                       null comment '邀请码'
)
    comment '用户';

