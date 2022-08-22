FROM mariadb:10.8

# create table用の環境変数
ARG sqlFile="create_table.sql"
ARG sqlFilePath="/nob/db/sqls"
# コンテナ内で使う環境変数
ENV SQL_FILE=${sqlFile}
ENV SQL_FILE_PATH=${sqlFilePath}

RUN mkdir -p ${sqlFilePath}

COPY ./sqls ${sqlFilePath}