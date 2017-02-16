package com.express.main.manager.dto;

/**
 * Created by 江俊超 on 2016/2/27.
 */
public class AllOperatorRequestDto {

    /**
     * action : GetOperatorPageManagerServiceAction
     * data : {"websiteId":1,"ticket":"20f960246806e5d49e448ecfe97dd859","imei":"493002407599521","isUpdateChangeSituation":0,"page":1}
     */

    private String action;

    public AllOperatorRequestDto(String action, DataEntity data) {
        this.action = action;
        this.data = data;
    }

    public AllOperatorRequestDto() {
    }

    /**
     * websiteId : 1
     * ticket : 20f960246806e5d49e448ecfe97dd859
     * imei : 493002407599521
     * isUpdateChangeSituation : 0
     * page : 1
     */


    private DataEntity data;

    public void setAction(String action) {
        this.action = action;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private int websiteId;
        private String ticket;
        private String imei;
        private int isUpdateChangeSituation;
        private int page;
        private String idNoCiphertext;

        public DataEntity() {
        }

        public DataEntity(int websiteId, String ticket, String imei, int isUpdateChangeSituation, int page, String idNoCiphertext) {
            this.websiteId = websiteId;
            this.ticket = ticket;
            this.imei = imei;
            this.isUpdateChangeSituation = isUpdateChangeSituation;
            this.page = page;
            this.idNoCiphertext = idNoCiphertext;
        }

        public String getIdNoCiphertext() {
            return idNoCiphertext;
        }

        public void setIdNoCiphertext(String idNoCiphertext) {
            this.idNoCiphertext = idNoCiphertext;
        }

        public DataEntity(int websiteId, String ticket, String imei, int isUpdateChangeSituation, int page) {
            this.websiteId = websiteId;
            this.ticket = ticket;
            this.imei = imei;
            this.isUpdateChangeSituation = isUpdateChangeSituation;
            this.page = page;
        }

        public void setWebsiteId(int websiteId) {
            this.websiteId = websiteId;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public void setIsUpdateChangeSituation(int isUpdateChangeSituation) {
            this.isUpdateChangeSituation = isUpdateChangeSituation;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getWebsiteId() {
            return websiteId;
        }

        public String getTicket() {
            return ticket;
        }

        public String getImei() {
            return imei;
        }

        public int getIsUpdateChangeSituation() {
            return isUpdateChangeSituation;
        }

        public int getPage() {
            return page;
        }
    }
}
