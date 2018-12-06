package ems.member;

public class DataBaseConnectionInfo {
    /**
     * DB를 통신할 때 정의를 가진 class
     *
     * applicationContext.xml에서 Bean을 만들고 주입을 해준다*/
    private String jdbcUrl;
    private String userId;
    private String userPw;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

}
