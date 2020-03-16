package Rule;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月20日12时51分
 */
@Data
@Builder
@ToString
public class PrinterRule implements Rule {

    private String clazzName;

    private String methodName;

    private int aloadNum;

}
