package com.philosopherzb.commonutil.i18n.bo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author philosopherZB
 * @date 2022/1/5
 */
@Data
public class OrderRequest implements Serializable {
    private static final long serialVersionUID = -6545018288178495132L;

    @NotBlank(message = "{PARAM_INVALID}")
    private String orderId;

    @Min(value = 0, message = "{ORDER_AMOUNTS_LESS_THEN_ZERO}")
    @NotNull(message = "{ORDER_AMOUNTS_IS_NULL}")
    private Integer orderAmt;
}
