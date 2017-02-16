package com.express.main.manager.dto;

import java.util.List;

/**
 * Created by 江俊超 on 2016/2/27.
 */
public class AllOperatorResponseDto {

    /**
     * pageCount : 1
     * result : 00
     * totalCount : 2
     * curPage : 1
     * pageSize : 15
     * list : [{"operatorPhoneNo":"13687586218","operatorName":"张三","operatorId":7,"status":0},{"operatorPhoneNo":"13687586218","operatorName":"张三","operatorId":8,"status":0}]
     */

    private DataEntity data;
    /**
     * data : {"pageCount":1,"result":"00","totalCount":2,"curPage":1,"pageSize":15,"list":[{"operatorPhoneNo":"13687586218","operatorName":"张三","operatorId":7,"status":0},{"operatorPhoneNo":"13687586218","operatorName":"张三","operatorId":8,"status":0}]}
     * action : GetOperatorPageManagerServiceAction
     */

    private String action;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public DataEntity getData() {
        return data;
    }

    public String getAction() {
        return action;
    }

    public static class DataEntity {
        private int pageCount;
        private String result;
        private int totalCount;
        private int curPage;
        private int pageSize;
        /**
         * operatorPhoneNo : 13687586218
         * operatorName : 张三
         * operatorId : 7
         * status : 0
         */

        private List<ListEntity> list;

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public int getPageCount() {
            return pageCount;
        }

        public String getResult() {
            return result;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getCurPage() {
            return curPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity {
            private String operatorPhoneNo;
            private String operatorName;
            private int operatorId;
            private int status;

            public void setOperatorPhoneNo(String operatorPhoneNo) {
                this.operatorPhoneNo = operatorPhoneNo;
            }

            public void setOperatorName(String operatorName) {
                this.operatorName = operatorName;
            }

            public void setOperatorId(int operatorId) {
                this.operatorId = operatorId;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getOperatorPhoneNo() {
                return operatorPhoneNo;
            }

            public String getOperatorName() {
                return operatorName;
            }

            public int getOperatorId() {
                return operatorId;
            }

            public int getStatus() {
                return status;
            }
        }
    }
}
