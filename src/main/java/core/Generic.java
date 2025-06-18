package core;

import java.util.List;

public class Generic {
    public void execute() {
        ApiResponse<String> response = new ApiResponse<>(true, "성공", "DTO");
        PageResult<String> page = new PageResult<>(0, 10, 100, List.of("hi"));
    }

    public class ApiResponse<T> {
        private boolean success;
        private String message;
        private T data;

        public ApiResponse(
                boolean success, String message, T data
        ) {
            this.success = success;
            this.message = message;
            this.data = data;
        }
    }

    public class PageResult<T> {
        private int page;
        private int size;
        private long totalElement;
        private List<T> contents;

        public PageResult(
                int page, int size, int totalElement, List<T> contents
        ) {
            this.page = page;
            this.size = size;
            this.totalElement = totalElement;
            this.contents = contents;
        }
    }


}
