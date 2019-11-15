package cn.liuhp.wheel.util;


/**
 * <p>
 * <p>
 * 结果泛型实体
 *
 * </p>
 *
 * @author hz16092620
 * @date 2018年9月14日 下午4:59:40
 */
public class PosResponse<T> {

    private Object result;//不用改成object也行，PosResponse这样写默认就是object

    private String errorMsg;

    private String status = "00000";

    private boolean success = Boolean.TRUE;

    /**
     * 构建器
     */
    public static class ResponseBuilder<T> {

        private Object result;

        private String errorMsg;

        private String status = "00000";

        private boolean success = Boolean.TRUE;

        public ResponseBuilder<T> setResult(T result) {
            this.result = result;
            return this;
        }

        public ResponseBuilder<T> setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public ResponseBuilder<T> setStatus(String status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder<T> setSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public PosResponse<T> build() {
            return new PosResponse<T>(result, errorMsg, status, success);
        }
    }

    private PosResponse() {

    }

    private PosResponse(Object result, String errorMsg, String status, boolean success) {
        this.result = result;
        this.errorMsg = errorMsg;
        this.status = status;
        this.success = success;
    }

    public T getResult() {
        return (T) result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }

    public static <T> PosResponse<T> success() {
        return new PosResponse<T>();
    }

    public static <T> PosResponse<T> fail(String status, String errorMsg) {
        PosResponse<T> fail = new PosResponse<T>();
        fail.errorMsg = errorMsg;
        fail.status = status;
        fail.success = Boolean.FALSE;
        return fail;
    }
}
 