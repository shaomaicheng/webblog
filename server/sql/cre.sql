create table tb_art(
    -- id
    a_id INT not null auto_increment primary key,
    -- 标题
    title varchar(255) not null,
    -- 作者
    author varchar(255) not null,
    -- 时间戳
    a_date integer(11) not null,
    -- 内容前面一部分
    content varchar(255) not null,
    -- 内容 md 文件 url
    url varchar(255) not null
)