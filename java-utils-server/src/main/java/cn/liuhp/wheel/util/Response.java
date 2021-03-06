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
public class Response<T> {

    public static void main(String[] args) {
        Response response = new Response();
        new ResponseBuilder().setResult(new Object()).build();
        System.out.println(response.getResult());
    }

    private T result;

    private String errorMsg;

    private String status = "00000";

    private boolean success = Boolean.TRUE;

    /**
     * 构建器
     */
    public static class ResponseBuilder<T> {

        private T result;

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

        public Response<T> build() {
            return new Response<T>(result, errorMsg, status, success);
        }
    }

    private Response() {

    }

    private Response(T result, String errorMsg, String status, boolean success) {
        this.result = result;
        this.errorMsg = errorMsg;
        this.status = status;
        this.success = success;
    }

    public T getResult() {
        return result;
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

    public static <T> Response<T> success() {
        return new Response<T>();
    }

    public static <T> Response<T> fail(String status, String errorMsg) {
        Response<T> fail = new Response<T>();
        fail.errorMsg = errorMsg;
        fail.status = status;
        fail.success = Boolean.FALSE;
        return fail;
    }
}
 