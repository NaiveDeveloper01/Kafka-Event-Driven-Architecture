package common_bundle.vo;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class MessageData implements Serializable {
    private Long productCode;
    private String productName;
    private String productCategory;
    private Double productCost;
}
