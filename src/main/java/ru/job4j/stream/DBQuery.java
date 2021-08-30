package ru.job4j.stream;

public class DBQuery {
    private String server;
    private String user;
    private String password;
    private String database;
    private String table;
    private String type;
    private String content;

    static class Builder {
        private String server;
        private String user;
        private String password;
        private String database;
        private String table;
        private String type;
        private String content;

        Builder buildServer(String server) {
            this.server = server;
            return this;
        }

        Builder buildUser(String user) {
            this.user = user;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildDatabase(String database) {
            this.database = database;
            return this;
        }

        Builder buildTable(String table) {
            this.table = table;
            return this;
        }

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildContent(String content) {
            this.content = content;
            return this;
        }

        DBQuery build() {
            DBQuery dbQuery = new DBQuery();
            dbQuery.server = server;
            dbQuery.user = user;
            dbQuery.password = password;
            dbQuery.database = database;
            dbQuery.table = table;
            dbQuery.type = type;
            dbQuery.content = content;
            return dbQuery;
        }
    }

    @Override
    public String toString() {
        return "DBQuery{"
                + "server='" + server + '\''
                + ", user='" + user + '\''
                + ", password='" + password + '\''
                + ", database='" + database + '\''
                + ", table='" + table + '\''
                + ", type='" + type + '\''
                + ", content='" + content + '\''
                + '}';
    }
}
