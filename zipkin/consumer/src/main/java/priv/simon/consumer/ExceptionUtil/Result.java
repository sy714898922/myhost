package priv.simon.consumer.ExceptionUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Result implements Serializable {

        private Integer code;
        private String message;
        private Object data;
}

